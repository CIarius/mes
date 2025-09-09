pipeline {

  agent any

  environment {
    WAR_PATH = 'target/mes.war'
    TOMCAT_USER = credentials('manager') // Jenkins credential ID
    TOMCAT_URL  = 'http://localhost:8080/manager/text'
  }

  stages {

    stage('Build & Test Backend') {
      steps {
        bat 'mvn clean verify'
      }
    }

    stage('Install Playwright') {
      steps {
        bat 'npm ci || exit 1'
        bat 'npx playwright install || exit 1'
      }
    }

    stage('Run Playwright Tests') {
      steps {
        bat 'npx playwright test || exit 1'
      }
    }

    stage('Package WAR') {
      steps {
        bat 'mvn package'
      }
    }

    stage('Archive WAR') {
      steps {
        archiveArtifacts artifacts: "${env.WAR_PATH}", fingerprint: true
      }
    }

    stage('Deploy to Tomcat') {
      steps {
        bat '''copy C:\Users\ramcc\.jenkins\workspace\mes\target\mes.war C:\apache-tomcat-9.0.108\webapps\mes.war'''
      }
    }

  }

  post {
    failure {
      echo '❌ Build failed. Check logs for details.'
    }
    success {
      echo '✅ Build and deployment completed successfully.'
    }
  }

}
