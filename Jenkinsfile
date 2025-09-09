pipeline {

  agent any

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

    stage('Deploy to Tomcat') {
      steps {
        bat "copy target\\mes.war C:\\apache-tomcat-9.0.108\\webapps\\mes.war"
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
