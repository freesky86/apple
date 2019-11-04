node{
      	stage('SCM Checkout'){
	        git 'https://github.com/freesky86/apple'
      	}
     	 stage('Compile-Package'){
	        sh 'mvn package'
      	}
	stage('Deploy-war'){
		echo '--delete war file'
		sh 'rm -rf /opt/Tools/tomcat/webapps/apple*'
		echo '--begin copy war...'
		sh 'cp /root/.jenkins/workspace/maven-project/target/apple-0.0.1-SNAPSHOT.war /opt/Tools/tomcat/webapps/apple.war'
		echo 'Copy War successfully!!!'
	}
	stage('Start-Tomcat'){	
		//echo '--begin to stop tomcat...'
		//sh '/opt/Tools/tomcat/bin/shutdown.sh'
		//echo '--tomcat is stopped.'
		echo '--begin to start tomcat...'
		sh '/opt/Tools/tomcat/bin/startup.sh'
		echo '--tomcat is started.'
	}
}
