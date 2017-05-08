node {

    stage 'Checkout git'
    git branch: 'database', url: 'https://github.com/snscaimito/jenkins-docker-test.git'

    stage 'Run tests'
    def db = docker.image('postgres').withRun('-p 5432:5432 -P --name db -e POSTGRES_DB=jenkinstest -e POSTGRES_USER=test -e POSTGRES_PASSWORD=test') { db ->
        docker.image('mygradle').inside('-P --name g2 --link db:db') {
            sh 'gradle clean build'
        }
    }

    stage 'Build image'
	sh  "docker build -t myjenkins-docker-test --build-arg HTTP_PROXY=${env.PROXY} . "

    stage 'Test image'
    docker.image('mydocker-compose').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
        sh 'docker-compose up -d'
        def ip = "\$(docker inspect --format '{{ .NetworkSettings.Networks.jenkinsdockertest_jdt.Gateway }}' jenkins-docker-test)"
        sleep 15
        sh "curl -# http://${ip}:9000/name/all"
        sh 'docker-compose down'
    }

}
