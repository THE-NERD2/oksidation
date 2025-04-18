plugins {
    kotlin("jvm") version "2.1.20"
    id("org.oksidation")
}

group = "org.oksidation.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}