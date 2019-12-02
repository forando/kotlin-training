repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation ("no.tornado:tornadofx:1.7.14")
    implementation ("com.intellij:forms_rt:7.0.3")
    implementation ("com.gitlab.malencur:file-utils:0.12.0")
    implementation ("com.jfoenix:jfoenix:8.0.7")
    implementation(project(":core"))
    implementation(project(":commons"))
}