pipeline {

  agent any

  environment {
    CATALINA_HOME = "${env.CATALINA_HOME}"
  }  

  stages {

    // skipping tests until after Docker/Tomcat is running
    stage('Build & Test Backend') {
      steps {
        bat 'mvn clean package -DskipTest'
      }
    }

    stage('Copy WAR file to Docker context') {
      steps {
        sh 'cp target/mes.war docker/tomcat/webapps/'
      }
    }    

    stage('Docker Compose Up') {
      steps {
        sh 'docker-compose -f docker/docker-compose.yml up -d --build'
      }
    }    
/*
    stage('Deploy to Docker/Tomcat'){
      steps {
        bat "docker rm -f tomcat-docker-sandbox"  // stop running instance
        bat '''
        docker run -d ^
          --name tomcat-docker-sandbox ^
          -p 8080:8080 ^
          -v C:/development/projects/mes/target/mes.war:/usr/local/tomcat/webapps/mes.war ^
          tomcat:9.0
        '''
      }
    }
*/
/*     stage('Deploy to Tomcat') {
      steps {
        bat "copy target\mes.war $CATALINA_HOME\webapps"
      }
    }
 */
/*     stage('Install Playwright') {
      steps {
        // bat 'npm ci || exit 1'
        // bat 'npx playwright install || exit 1'
      }
    }
 */

    stage('Verify'){
      steps {
        bat "mvn verify"
      }
    }
/*    
    stage('Run Playwright Tests') {
      steps {
        bat 'npx playwright test || exit 1'
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
