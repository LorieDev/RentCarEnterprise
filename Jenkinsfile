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
                sh 'docker build -t rentcar .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker stop rentcar-container || true'
                sh 'docker rm rentcar-container || true'
                sh 'docker run -d -p 8082:8080 --name rentcar-container rentcar'
            }
        }
    }
}