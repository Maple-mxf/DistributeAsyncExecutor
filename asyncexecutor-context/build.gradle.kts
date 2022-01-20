plugins {
    java
}

group = "io.asyncexecutor.context"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.projectlombok", name = "lombok", version = "1.18.20")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.11.0")
    testCompile("junit", "junit", "4.12")
}
