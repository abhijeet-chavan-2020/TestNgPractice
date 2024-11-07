pipeline {
    agent any

    stages {
        stage('Building') {
            steps {
                echo 'Code building in progress'
                }
            }
             stage('Testing') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abhijeet-chavan-2020/TestNgPractice.git']])
                sh 'mvn clean test'
                }
            }
             stage('Deployment') {
            steps {
                 echo 'Deploying the code to staging'

                }
            }
        }
    }

