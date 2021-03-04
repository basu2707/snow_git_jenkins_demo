// Simple script with one step

pipeline {
    agent any

    stages {
        stage('preparation') {
            steps {
                snApplyChanges url: "https://comcastdemo.service-now.com", credentialsId: "comcastdemo", appScope: "global"
            }
        }
    }
}
