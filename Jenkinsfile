pipeline {
    agent any

    tools {
        maven 'Maven3'   // must match Jenkins Global Tool name
        jdk 'JDK21'      // must match your configured JDK
    }

    environment {
        ALLURE_RESULTS = 'target/allure-results'
        JMETER_HOME = 'C:\\Users\\RAUNAK\\Downloads\\apache-jmeter-5.6.3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Shra2411/Capstone-Capg.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('Archive Results') {
            steps {
                archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.log', allowEmptyArchive: true
        }
        success {
            echo 'BUILD SUCCESS 🎉'
        }
        failure {
            echo 'BUILD FAILED ❌'
        }
    }
}