# Step 1: Base image
FROM eclipse-temurin:21-jdk

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy JAR file
COPY target/greetings-service.jar app.jar

# Step 4: Expose port
EXPOSE 8000

# Step 5: Run application
CMD ["java", "-jar", "app.jar"]