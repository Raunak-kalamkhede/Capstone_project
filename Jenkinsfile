pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    environment {
        JMETER_HOME = 'C:\\Users\\RAUNAK\\Downloads\\apache-jmeter-5.6.3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Raunak-kalamkhede/Capstone_project.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'allure generate target/allure-results -o target/allure-report --clean'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'target/allure-report',
                    reportFiles: 'index.html',
                    reportName: 'Allure Report'
                ])
            }
        }
    }
}