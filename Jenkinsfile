pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh '/usr/local/bin/docker build -t rentcar .'
            }
        }

        stage('Docker Run') {
            steps {
                sh '/usr/local/bin/docker stop rentcar-container || true'
                sh '/usr/local/bin/docker rm rentcar-container || true'
                sh '/usr/local/bin/docker run -d -p 8082:8080 --name rentcar-container rentcar'
            }
        }
    }
}