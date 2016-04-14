FROM alpine
MAINTAINER Dag Heradstveit <dagherad@gmail.com>

# Install dependencies
RUN apk --update upgrade --no-cache && apk add libstdc++ bash openjdk8

VOLUME /tmp
ADD build/libs/jenkins-docker-test.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar","/app.jar"]