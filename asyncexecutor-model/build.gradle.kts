plugins {
    java
}

group = "io.asyncexecutor.model"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.projectlombok", name = "lombok", version = "1.18.20")

    testCompile("junit", "junit", "4.12")
}
