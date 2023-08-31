FROM gradle:8.3.0-jdk11-alpine AS build
COPY --chown=gradle:gradle /src /home/gradle/src/src
COPY --chown=gradle:gradle build.gradle /home/gradle/src
COPY --chown=gradle:gradle gradlew /home/gradle/src
COPY --chown=gradle:gradle settings.gradle /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM tomcat:jdk11

COPY --from=build /home/gradle/src/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war
