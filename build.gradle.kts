// build.gradle.kts (nivel de proyecto)
plugins {
    // Puedes agregar plugins necesarios aquí si es necesario
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}