## user/pass
```
admin
test
```
## gradle
### build.gradle.kts
```
plugins {
  id("org.sonarqube") version "4.2.1.3168"
}
```
### run
```
./gradlew jacocoTestReport sonar -Dsonar.projectKey=test -Dsonar.projectName='test' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_85590b3e4631a37824afa67eb47b139e93253a9d
```
