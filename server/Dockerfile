from openjdk:17-jdk-slim

run ls
copy target/*.jar app.jar

expose 8080

cmd java -jar app.jar
