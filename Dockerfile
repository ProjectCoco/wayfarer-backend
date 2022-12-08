FROM adoptopenjdk/openjdk11
COPY backend/application/build/libs/application-0.0.1-SNAPSHOT.jar wayfarer.jar
COPY /home/ec2-user/resources/application.yml application.yml
ENTRYPOINT ["java", "-jar", "-Dspring.config.location=./application.yml", "wayfarer.jar"]
