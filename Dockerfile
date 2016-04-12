############################################################
# Simple image to test Jenkins ability to build in docker. #
############################################################

    #mkdir /var/jenkins_home && \
    #mkdir /var/jenkins_home/jobs && \
    #mkdir /var/jenkins_home/jobs/jenkins-docker-test && \

FROM alpine
MAINTAINER Dag Heradstveit <dagherad@gmail.com>

# Install dependencies
RUN apk upgrade --update --no-cache && apk add libstdc++ bash openjdk8 curl

# Disable root, add jenkins user and create host keys
RUN passwd -d root && \
    adduser -D -s /bin/ash jenkins && \
    echo "jenkins:jenkins" | chpasswd && \
    chown -R jenkins:jenkins /home/jenkins


# Gradle
ENV	GRADLE_HOME /opt/gradle
ENV	PATH $PATH:$GRADLE_HOME/bin
ENV	GRADLE_VERSION	2.10

RUN	curl -Lks https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-all.zip -o /root/gradle.zip && \
	mkdir -p /opt/ && cd /opt/ && \
	unzip /root/gradle.zip && \
	ln -s gradle-${GRADLE_VERSION} gradle && \
	rm -f /root/gradle.zip

CMD ["gradle", "build"]