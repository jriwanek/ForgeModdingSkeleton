pipeline {
    agent any
    tools {
        gradle 'Gradle 4.9'
        jdk 'oraclejdk8' // the name you have given the JDK installation in Global Tool Configuration
    }
    stages {
        stage('Prepare for build') {
            steps {
                sh 'rm -rf build/libs'
                sh 'chmod +x gradlew'
                sh 'java -version'
                sh 'gradle -version'
                sh './gradlew -version'
                sh 'export'
            }
        }
        stage('Set up CI Workspace') {
            steps {
                sh './gradlew clean setupCiWorkspace'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Deploy to maven') {
            steps {
                sh './gradlew publish'
				
            }
        }
        stage('Deploy to curseforge') {
            steps {
                sh './gradlew curseforge'
            }
        }
        stage('SonarQube analysis') {
            tools {
                jdk "oraclejdk11" // the name you have given the JDK installation in Global Tool Configuration
            }
            environment {
                scannerHome = tool 'SonarQube' // the name you have given the Sonar Scanner (in Global Tool Configuration)
            }
            steps {
//                sh './gradlew curseforge'
                withSonarQubeEnv(installationName: 'SonarCloud', , envOnly: false) {
                    sh "${scannerHome}/bin/sonar-scanner -X -Dsonar.java.jdkHome=${JAVA_HOME}"
                }
            }
        }
    }
}
