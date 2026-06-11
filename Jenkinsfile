pipeline {

agent any

tools {

maven 'Maven'

}

stages {

stage('Checkout') {

steps {

git branch: 'main',
url: 'https://github.com/user/repo.git'

}

}

stage('Build') {

steps {

sh 'mvn clean compile'

}

}

stage('Unit Test') {

steps {

sh 'mvn test'

}

post {

always {

junit 'target/surefire-reports/*.xml'

}

}

}

stage('Code Quality') {

steps {

sh '''
mvn sonar:sonar \
-Dsonar.host.url=http://SONAR-IP:9000 \
-Dsonar.login=TOKEN
'''
}

}

stage('Package') {

steps {

sh 'mvn clean package'

}

}

stage('Deploy') {

steps {

sshPublisher(
publishers: [
sshPublisherDesc(
configName: 'tomcat-server',
transfers: [
sshTransfer(
sourceFiles: 'target/*.war',
remoteDirectory: '/opt/tomcat/webapps'
)
]
)
]
)

}

}

}

}