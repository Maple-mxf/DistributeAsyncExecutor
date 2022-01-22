plugins {
    java
}

group = "io.asyncexecutor.communicator.api"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":asyncexecutor-context"))
    testCompile("junit", "junit", "4.12")
}
