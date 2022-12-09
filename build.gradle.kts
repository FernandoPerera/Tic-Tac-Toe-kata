plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.assertj:assertj-core:3.20.0")
    testImplementation("org.mockito:mockito-core:4.7.0")
}

testing {
    // change test class name

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}