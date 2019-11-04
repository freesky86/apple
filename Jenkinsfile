node{
      stage('SCM Checkout'){
	        git 'https://github.com/freesky86/apple'
      }
      stage('Compile-Package'){
	        sh 'mvn package'
      }
}
