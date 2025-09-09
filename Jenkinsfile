pipeline {

  agent any

  stages {

    stage('Build & Test Backend') {
      steps {
        bat 'mvn clean package'
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
/*
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
*/
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
