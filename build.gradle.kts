import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val allureVersion = "2.24.0"
val aspectJVersion = "1.9.20.1"

plugins {
    kotlin("jvm") version "1.9.21"
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.30"
    id("io.qameta.allure") version "2.11.2"
    id("org.jlleitschuh.gradle.ktlint") version "12.0.3"
    application
    checkstyle

}

group = "org.example"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    testImplementation("io.qameta.allure:allure-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testImplementation("net.serenity-bdd:serenity-core:4.0.28")
    testImplementation("net.serenity-bdd:serenity-junit5:4.0.28")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
