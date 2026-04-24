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
                git 'https://github.com/Raunak-kalamkhede/Capstone_project.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure results: [[path: 'target/allure-results']]
            }
        }
    }
}
