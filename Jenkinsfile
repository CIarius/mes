pipeline {
  agent any

  environment {
    NODE_ENV = 'test'
  }

  stages {
    stage('Build Backend') {
      steps {
        bat 'mvn clean compile'
      }
    }

    stage('Run JUnit Tests') {
      steps {
        bat 'mvn test'
      }
    }

    stage('Install Playwright') {
      steps {
        bat 'npm ci'
        bat 'npx playwright install'
      }
    }

    stage('Run Playwright Tests') {
      steps {
        bat 'npx playwright test'
      }
    }

    stage('Deploy to Tomcat') {
      steps {
        bat 'scp target\myapp.war manager@localhost:/opt/tomcat/webapps/'
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
