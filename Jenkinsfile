node('docker-slave') {

    stage 'Checkout git'
    git 'https://github.com/scav/jenkins-docker-test.git'

    stage 'Run tests'
    docker.image('localhost:5000/gradle').inside {
        sh 'gradle clean build'
    }

    stage 'Build image'
    docker.withRegistry('http://localhost:5000') {
        def image =
            docker.build("jenkins-docker-test:latest", '.')

        stage 'Push image to registry'
        image.push('latest')
    }
}