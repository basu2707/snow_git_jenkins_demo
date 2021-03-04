// Simple script with one step and ServiceNow Parameters

pipeline {
    agent any

    parameters {
            snParam(credentialsForPublishedApp: "comcastdemo", instanceForPublishedAppUrl: "https://comcastdemo.service-now.com", appScope: "global")
    }

    stages {
        stage('preparation') {
            steps {
                echo "${params.snParam}"

                snApplyChanges()
            }
        }
    }
}
