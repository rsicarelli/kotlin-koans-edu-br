/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm("desktop") {
        jvmToolchain(17)
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
