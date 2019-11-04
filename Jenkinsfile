node{
      	stage('SCM Checkout'){
	        git 'https://github.com/freesky86/apple'
      	}
     	 stage('Compile-Package'){
	        sh 'mvn package'
      	}
	stage('Deploy-war'){
		cp /root/.jenkins/workspace/maven-project/target/apple-0.0.1-SNAPSHOT.war /opt/Tools/tomcat/webapps	
	}
	stage('Start-Tomcat'){
		cd /opt/Tools/tomcat/bin
		sh shutdown.sh
		sh startup.sh
	}
}
