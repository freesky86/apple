node{
      	stage('SCM Checkout'){
	        git 'https://github.com/freesky86/apple'
      	}
     	 stage('Compile-Package'){
	        sh 'mvn package'
      	}
	stage('Deploy-war'){
		sh 'cp /root/.jenkins/workspace/maven-project/target/apple-0.0.1-SNAPSHOT.war /opt/Tools/tomcat/webapps/apple.war'
		echo 'Copy War successfully!!!'
	}
	stage('Start-Tomcat'){	
		echo '--begin to stop tomcat...'
		sh '/opt/Tools/tomcat/bin/shutdown.sh'
		echo '--tomcat is stopped.'
		sh '/opt/Tools/tomcat/bin/startup.sh'
		echo '--tomcat is started.'
	}
}
