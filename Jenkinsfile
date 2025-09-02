pipeline {
  agent any

  environment {
    NODE_ENV = 'test'
  }

  stages {
    stage('Build Backend') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('Run JUnit Tests') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Install Playwright') {
      steps {
        sh 'npm ci'
        sh 'npx playwright install'
      }
    }

    stage('Run Playwright Tests') {
      steps {
        sh 'npx playwright test'
      }
    }
  }

  post {
    always {
      publishHTML([
        reportDir: 'playwright-report',
        reportFiles: 'index.html',
        reportName: 'Playwright Test Report',
        allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true
      ])
    }
    failure {
      echo 'Build failed due to test errors.'
    }
  }
}
