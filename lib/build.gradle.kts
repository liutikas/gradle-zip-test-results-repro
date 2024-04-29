plugins {
    alias(libs.plugins.jvm)
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

val testTask = tasks.named<Test>("test") {
    useJUnitPlatform()
}

val zipTask = project.tasks.register<Zip>("zipTestResults") {
    destinationDirectory.set(layout.buildDirectory.dir("host-test-reports"))
    archiveFileName.set("test-results.zip")
    from(testTask.flatMap { it.reports.junitXml.outputLocation })
}
