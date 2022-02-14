pipeline {
    agent any
    stages {

        stage('Checkout') {
            agent {label 'Test_VM'}
            steps{
                echo 'start checkout'
                echo env.PATH
                echo env.BUILD_ID
                // git branch: 'main', credentialsId: '7c06e1bd-1b78-44d6-b061-89984c4c37ab', url: 'https://github.com/luchengcheng/MosaiqUITest.git'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '7c06e1bd-1b78-44d6-b061-89984c4c37ab', url: 'https://github.com/luchengcheng/luchengcheng.git']]])
            }

        }
        stage('Build'){
            steps{
                echo 'start build'
            }
        }
    }
}