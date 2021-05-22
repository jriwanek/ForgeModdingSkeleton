pipeline {
    agent any
    tools {
        gradle 'Gradle 4.9'
        jdk 'oraclejdk8'
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
                withGradle {
                    sh './gradlew clean setupCiWorkspace'
		}
            }
        }
        stage('Build') {
            steps {
                withGradle {
                    sh './gradlew clean build'
                }
            }
        }
        stage('Deploy to maven') {
            steps {
                withGradle {
                    sh './gradlew publish'
                }
            }
        }
        stage('Deploy to curseforge') {
            steps {
                withGradle {
                    sh './gradlew curseforge'
                }
            }
        }
        stage('SonarQube analysis') {
            tools {
                jdk "oraclejdk11"
            }
            environment {
                scannerHome = tool 'SonarQube'
            }
            steps {
//              withGradle {
//                  sh './gradlew sonarqube'
//              }
                withSonarQubeEnv(installationName: 'SonarCloud', , envOnly: false) {
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.java.jdkHome=${JAVA_HOME}"
                }
            }
        }
    }
}
