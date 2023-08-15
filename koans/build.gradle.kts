plugins {
    kotlin("multiplatform")
}

kotlin {

    jvm("desktop") {
        jvmToolchain(11)
    }

    sourceSets {

        val commonMain by getting {}

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("reflect"))
            }
        }
    }
}
