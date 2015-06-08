#!/bin/sh
## mvn clean process-classes exec:java -Dexec.mainClass=org.example.main.MainPackage
mvn clean process-classes exec:java -Dlogback.configurationFile=src/test/resources/logback-test.xml -Dexec.mainClass=org.example.main.MainPackage
