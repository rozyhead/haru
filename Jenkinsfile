#!groovy

node {
  stage('Checkout') {
    checkout scm
  }

  stage('Build'){
    sh './gradlew build'
  }

  stage('Archive'){
    archiveArtifacts artifacts: '**/build/libs/*.jar'
  }
}
