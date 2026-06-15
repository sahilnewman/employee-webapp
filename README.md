"# employee-webapp" 

Phase 1: Prerequisites
=========================
Verify on the putty server:

java -version
mvn -version
git --version

In Jenkins:
Manage Jenkins → Tools
Configure:

JDK
Name: JDK17
JAVA_HOME: /usr/lib/jvm/java-17-openjdk-amd64 (as per the output of putty server)

Maven
Name: Maven3
MAVEN_HOME: /usr/share/maven

Publish Over SSH plugin.

Configure:
Manage Jenkins
→ System
→ Publish Over SSH

Add:

Name: TOMCAT-SERVER
Hostname: EC2-IP <server public IP address>
Username: ubuntu
Key: Private Key

Test Connection.

##########################################################################

Phase 2: Install Required Plugins
==================================
Manage Jenkins → Plugins
Install:
	• Git Plugin
	• Git Client Plugin
	• Pipeline Plugin
	• Maven Integration Plugin
	• JUnit Plugin
	• Credentials Plugin
	• SSH Agent Plugin
	• Publish Over SSH Plugin
	• Pipeline Stage View Plugin
	• Blue Ocean Plugin
    • Build Timestamp Plugin
Restart Jenkins.

#############################################################################

Phase 3: Create Freestyle Project
==================================


Job1-devops-workshop-code pull: 
--------------------------------

Source Code Management
Select: Git
Repository URL:https://github.com/<your-repo>.git
If private: Add Credentials
Branch: */main

Build Environment
Check: Delete workspace before build starts

Job2-devops-workshop-code build
--------------------------------

Build
Add Build Step: Invoke top-level Maven targets
Maven Version: Maven3
Goals: clean compile

Job3-devops-workshop-code Testing
---------------------------------- 

Add Unit Testing

Build Step: clean test or clean compile test

Publish Test Results
Post Build Actions

Add: Publish JUnit test result report
Report XMLs: **target/surefire-reports/*.xml

Job4-devops-workshop-code package
----------------------------------

Package WAR File

Add Build Step: Invoke top-level Maven targets
Maven Version: Maven3
Goals: clean package


Archive WAR Artifact

Post Build Action: Archive Artifacts
Files: target/*.war

Job5-devops-workshop-code deploy
---------------------------------
Post Build Action
Send build artifacts over SSH

Transfer:

Source Files: target/*.war
Remote Directory: deploy

Then execute a remote command:

sudo cp /home/ubuntu/deploy/target/*.war /opt/tomcat/webapps/
Sudo systemctl restart tomcat 

#############################################################################
