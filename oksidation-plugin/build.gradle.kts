plugins {
    kotlin("jvm") version "2.1.20"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "org.oksidation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

gradlePlugin {
    plugins {
        create("oksidation") {
            id = "org.oksidation"
            implementationClass = "org.oksidation.OksidationPlugin"
        }
    }
}