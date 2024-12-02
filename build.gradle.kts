import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform(kotlin("bom")))
    implementation(platform("org.junit:junit-bom:5.11.3"))

    constraints {
        implementation("io.strikt:strikt-core:0.35.1")
        implementation("io.mockk:mockk:1.13.13")
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("io.strikt:strikt-core")
    testImplementation("io.mockk:mockk")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}


tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "21"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
