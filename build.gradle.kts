plugins {
    kotlin("jvm") version "1.3.61" apply false
}

group = "com.malencur"

allprojects {
    apply (plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}