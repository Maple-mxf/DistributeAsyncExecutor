plugins {
    java
}

group = "io.asyncexecutor.agent"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")

    implementation(project(":asyncexecutor-context"))
}
