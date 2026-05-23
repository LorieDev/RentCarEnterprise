pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh '/opt/homebrew/bin/mvn test'
            }
        }
    }
}