pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew check'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            junit 'build/test-results/**/*.xml'
        }
    }
}