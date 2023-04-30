#!/bin/sh
exec java -XX:CompileThreshold=1000 -XX:+TieredCompilation -XX:+UseG1GC -Djava.awt.headless=true -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Djasypt.encryptor.password=$JASYPT_KEY -jar integration-service.jar