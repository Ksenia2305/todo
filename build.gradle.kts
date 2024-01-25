import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

val allureVersion = "2.24.0"
val kotestVersion = "5.8.0"

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    // Import allure-bom to ensure correct versions of all the dependencies are used
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    // Add necessary Allure dependencies to dependencies section
    testImplementation("io.qameta.allure:allure-junit5")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation ("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation ("io.kotest:kotest-property:$kotestVersion")
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