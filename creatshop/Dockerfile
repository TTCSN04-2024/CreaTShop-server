# Sử dụng hình ảnh Java chính thức
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR của ứng dụng vào container
COPY target/*.jar app.jar

# Expose cổng mà ứng dụng Spring Boot sử dụng
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
