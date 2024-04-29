# Gradle zipping test results repro

1. `./gradlew zipTestResults`

## Expected
Success

## Actual
Failure
```
FAILURE: Build failed with an exception.

* What went wrong:
Could not determine the dependencies of task ':lib:zipTestResults'.
> Property 'outputLocation' is declared as an output property of Report junitXml (type DefaultJUnitXmlReport) but does not have a task associated with it.
```
