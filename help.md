Setup Process

Checkout project fom Git and follow belo steps

mvn clean install -DapplicationName=microservice-archetype

Generate a new project using below command

Replace orgname with your orgname here and in archetype-metadata.xml
3279
mvn archetype:generate -DarchtetypeArtifactId=microservice-archetype -DarchetypeGroupId=com.orgname
-DarchetypeVersion=0.0.1-SNAPSHOT -DgroupId=com.orgname -DartifactId=<project servlet context name>

Example


mvn archetype:generate -Dfilter=com.orgname:microservice-archetype -DarchtetypeArtifactId=microservice-archetype -DarchetypeGroupId=com.orgname -DarchetypeVersion=0.0.1-SNAPSHOT -DgroupId=com.orgname -DartifactId=partner-integration
