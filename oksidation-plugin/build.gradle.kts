plugins {
    kotlin("jvm") version "2.1.20"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "dev.the-nerd2.oksidation"
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
            id = "dev.the_nerd2.oksidation"
            implementationClass = "dev.the_nerd2.oksidation.OksidationPlugin"
        }
    }
}
