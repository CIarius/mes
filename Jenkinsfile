pipeline {

  agent any

  environment {
    CATALINA_HOME = "${env.CATALINA_HOME}"
  }  

  stages {

    stage('Build & Test Backend') {
      steps {
        bat 'mvn clean verify'
      }
    }

    stage('Package WAR') {
      steps {
        bat 'mvn package'
      }
    }

    stage('Deploy to Tomcat') {
      steps {
        bat "copy target\\mes.war $CATALINA_HOME/webapps/"
      }
    }

/*     stage('Install Playwright') {
      steps {
        // bat 'npm ci || exit 1'
        // bat 'npx playwright install || exit 1'
      }
    }
 */
    stage('Run Playwright Tests') {
      steps {
        bat 'npx playwright test || exit 1'
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
