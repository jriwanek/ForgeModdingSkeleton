pipeline {
    agent any
    environment {
        GRADLE_OPTS = '-Dorg.gradle.caching=true -Dorg.gradle.configureondemand=true -Dorg.gradle.warning.mode=all'
//      JAVA_OPTS = ''
    }
    tools {
        git 'Git'
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
        stage('postbuild') {
            steps {
                recordIssues(tools: [java()])
                archiveArtifacts artifacts: 'build/libs/*.jar', followSymlinks: false
                javadoc javadocDir: 'build/docs/javadoc', keepAll: false
                junit allowEmptyResults: true, testResults: '**/build/test-results/junit-platform/*.xml'
                jacoco classPattern: '**/build/classes/java', execPattern: '**/build/jacoco/**.exec', sourceInclusionPattern: '**/*.java', sourcePattern: '**/src/main/java'
                recordIssues(tools: [checkStyle(pattern: '**/build/reports/checkstyle/*.xml')])
                recordIssues(tools: [pmdParser(pattern: '**/build/reports/pmd/*.xml')])
                recordIssues(tools: [spotBugs(pattern: '**/build/reports/spotbugs/*.xml', useRankAsPriority: true)])
            }
        }
    }
}
