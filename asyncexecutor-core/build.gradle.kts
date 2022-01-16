plugins {
    java
}

group = "io.asyncexecutor.core"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")

    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.30")
    implementation(group = "ch.qos.logback", name = "logback-core", version = "1.1.7")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.1.7")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.11.0")
    implementation(group = "com.google.protobuf", name = "protobuf-java", version = "3.15.8")
    implementation(group = "org.projectlombok", name = "lombok", version = "1.18.20")
    implementation(group = "com.google.guava", name = "guava", version = "29.0-jre")
}
