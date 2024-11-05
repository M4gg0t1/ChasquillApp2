plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.JSH.ChasquillApp" // Cambia esto a tu namespace real
    compileSdk = 34

    defaultConfig {
        applicationId = namespace // Usa el namespace aquí
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Cambiado a Java 17
        targetCompatibility = JavaVersion.VERSION_17 // Cambiado a Java 17
    }
}

dependencies {
    implementation(libs.appcompat) // Asegúrate de tener esta dependencia
    implementation(libs.material)
    implementation(libs.activity) // Asegúrate de tener esta dependencia si la usas
    implementation(libs.constraintlayout)

    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.play.services.maps)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Firebase In-App Messaging (agrega la versión correcta)
    implementation(libs.firebase.inappmessaging.ktx)
}