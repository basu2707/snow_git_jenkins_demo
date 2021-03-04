// Sample script with simple workflow of publishing and installing an application on NOW platform

pipeline {
    agent any

    parameters {
            snParam(credentialsForPublishedApp: "comcastdemo", instanceForPublishedAppUrl: "https://comcastdemo.service-now.com",
                    credentialsForInstalledApp:"comcastdemo", instanceForInstalledAppUrl:"https://comcastdemo.service-now.com",
                    appScope: "global")
    }

    stages {
        stage('publishing') {
            steps {
                snPublishApp obtainVersionAutomatically: true
            }
        }
        stage('installation') {
            steps {
                snInstallApp()
                snRunTestSuite browserName: 'Firefox', osName: 'Windows', osVersion: '10', testSuiteName: 'My CHG:Change Management', withResults: true
            }
        }
    }
}
