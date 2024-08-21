# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot jar file into the container
COPY build/libs/backend-api-1.0-SNAPSHOT.jar /app/backend-api.jar

# Expose the port that the application will run on
EXPOSE 8080

# Set the entry point to run the jar file
ENTRYPOINT ["java","-jar","backend-api.jar"]
