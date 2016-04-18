node('docker-slave') {

    stage 'Checkout git'
    git branch: 'database', url: 'https://github.com/scav/jenkins-docker-test.git'

    stage 'Run tests'

    def db = docker.image('postgres').withRun('-p 5432:5432 -P --name db -e POSTGRES_DB=jenkinstest -e POSTGRES_USER=test -e POSTGRES_PASSWORD=test') { db ->
        docker.image('localhost:5000/gradle').inside('-P --name g2 --link db:db') {
            sh 'gradle clean build'
        }
    }

    stage 'Build image'
    docker.withRegistry('http://localhost:5000') {
        def image =
        docker.build("jenkins-docker-test:latest", '.')

        stage 'Push image to registry'
        image.push('latest')
    }

    stage 'Test image'
    sh 'docker-compose up -d'
    def ip = "\$(docker inspect --format '{{ .NetworkSettings.Networks.jenkinsdockertest_jdt.Gateway }}' jenkins-docker-test)"
    sleep 10
    sh "curl -# http://${ip}:9000/name/all"
    sh 'docker-compose down'


}