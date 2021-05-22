pipeline {
    agent any
    tools {
        gradle 'Gradle 4.9'
        jdk 'oraclejdk8'
    }
    stages {
        stage('prebuild') {
            steps {
                sh 'rm -rf build/libs'
                sh 'chmod +x gradlew'
                sh 'java -version'
                sh 'gradle -version'
                sh './gradlew -version'
                sh 'export'
            }
        }
        stage('CIWorkspace') {
            steps {
                withGradle {
                    sh './gradlew clean setupCiWorkspace'
		}
            }
        }
        stage('build') {
            steps {
                withGradle {
                    sh './gradlew clean build'
                }
            }
        }
        stage('publish') {
            steps {
                withCredentials([file(credentialsId: 'secret.json', variable: 'SECRET_FILE')]) {
                    withGradle {
                        sh './gradlew publish'
                    }
                }
            }
        }
        stage('CurseForge') {
            steps {
                withCredentials([file(credentialsId: 'secret.json', variable: 'SECRET_FILE')]) {
                    withGradle {
                        sh './gradlew curseforge'
                    }
                }
            }
        }
        stage('SonarQube') {
            tools {
                jdk "oraclejdk11"
            }
            environment {
                scannerHome = tool 'SonarQube'
            }
            steps {
//              withCredentials([file(credentialsId: 'secret.json', variable: 'SECRET_FILE')]) {
//                  withGradle {
//                      sh './gradlew sonarqube'
//                  }
//              }
                withSonarQubeEnv(installationName: 'SonarCloud', , envOnly: false) {
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.java.jdkHome=${JAVA_HOME}"
                }
            }
        }
    }
}
