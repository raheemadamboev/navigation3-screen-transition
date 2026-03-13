import com.android.build.api.dsl.ApplicationExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.android)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            // compose
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.resources)
            implementation(libs.compose.preview)

            // compose material3
            implementation(libs.compose.material3)

            // lifecycle
            implementation(libs.lifecycle.runtime)
            implementation(libs.lifecycle.viewmodel)
            implementation(libs.lifecycle.viewmodel.navigation3)

            // navigation3
            implementation(libs.navigation3)

            // serialization
            implementation(libs.serialization)
        }

        androidMain.dependencies {
            // compose preview
            implementation(libs.compose.preview)

            // compose activity
            implementation(libs.compose.activity)
        }
    }
}

extensions.configure<ApplicationExtension> {
    namespace = "xyz.teamgravity.navigation3screentransition"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "xyz.teamgravity.navigation3screentransition"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.tooling)
}