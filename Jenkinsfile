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

    stage 'Test image'
    docker.withRegistry('http://localhost:5000') {
        def image =
        docker.image('jenkins-docker-test').withRun { c ->
            //Get the container ip.
            def ip = "\$(docker inspect --format '{{ .NetworkSettings.IPAddress }}' ${c.id})"
            //Sleep while the container starts up
            sleep 10
            //Make sure the container is running and responding inside of the image
            sh "curl -# http://${ip}:8080"
        }
    }
}