############################################################
# Simple image to test Jenkins ability to build in docker. #
############################################################

    #mkdir /var/jenkins_home && \
    #mkdir /var/jenkins_home/jobs && \
    #mkdir /var/jenkins_home/jobs/jenkins-docker-test && \

FROM alpine
MAINTAINER Dag Heradstveit <dagherad@gmail.com>

# Install dependencies
RUN apk upgrade --update --no-cache && apk add libstdc++ bash openjdk8 gradle

# Disable root, add jenkins user and create host keys
RUN passwd -d root && \
    adduser -D -s /bin/ash jenkins && \
    echo "jenkins:jenkins" | chpasswd && \
    chown -R jenkins:jenkins /home/jenkins && \

CMD ["gradle"]