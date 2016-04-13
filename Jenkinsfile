node('docker-slave') {
    docker.image('localhost:5000/gradle').inside {
        stage 'Checkout from git'
        git 'https://github.com/scav/jenkins-docker-test.git'
        stage 'Running tests'

        sh 'gradle clean build'
    }
}