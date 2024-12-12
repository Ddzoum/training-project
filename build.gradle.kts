import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("net.java.dev.jna:jna:5.14.0")
    testImplementation("net.java.dev.jna:jna-platform:5.14.0")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.cucumber:cucumber-java8:7.18.1")
    testImplementation("io.cucumber:cucumber-spring:7.18.0")
    testImplementation("io.cucumber:cucumber-junit:7.18.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0")
    testImplementation("com.willowtreeapps.assertk:assertk:0.28.1")
    testRuntimeOnly("org.junit.platform:junit-platform-console")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "21"
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = false
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    maxHeapSize = "1G"
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    val tests by registering(JavaExec::class) {
        dependsOn(testClasses)
        doFirst {
            println("Running parallel test")
        }
        classpath = sourceSets["test"].runtimeClasspath
        mainClass.set("org.junit.platform.console.ConsoleLauncher")
        args("--include-engine", "cucumber")
        args("--details", "tree")
        args("--scan-classpath")
        systemProperty("cucumber.execution.parallel.enabled", false)
        systemProperty("cucumber.execution.parallel.config.strategy", "fixed")
        systemProperty("cucumber.execution.parallel.config.fixed.parallelism", 2)
        systemProperty(
            "cucumber.plugin",
            "pretty, summary, timeline:build/reports/timeline, html:build/reports/cucumber.html"
        )
        systemProperty("cucumber.ansi-colors.disabled", false)
        systemProperty("cucumber.publish.quiet", true)
        systemProperty("cucumber.filter.tags", "not @ignore")

    }
}