plugins {
    `kotlin-dsl`
}

group = "advent.of.code"
version = "1.0.0"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}
repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}