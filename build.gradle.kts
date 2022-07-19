import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
}

object Versions {
    const val JUNIT = "5.8.2"
    const val MOCKK = "1.12.0"
    const val ASSERTJ = "3.20.2"
    const val ARROW = "1.1.2"
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.arrow-kt:arrow-core:${Versions.ARROW}")

    testImplementation(group = "io.mockk", name = "mockk", version = Versions.MOCKK)
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = Versions.JUNIT)
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = Versions.JUNIT)
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params", version = Versions.JUNIT)
    testImplementation(group = "org.assertj", name = "assertj-core", version = Versions.ASSERTJ)
}


tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes")
        }
    }
}