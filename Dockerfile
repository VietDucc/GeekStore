# Stage 1: Build với Maven và JDK 17
FROM maven:3-openjdk-17 AS build

WORKDIR /app

# Copy toàn bộ code vào container
COPY . .

# Build project, bỏ qua test để nhanh hơn
RUN mvn clean package -DskipTests

# Stage 2: Chạy app với JDK 17 nhẹ (slim)
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy file jar từ stage build sang
COPY --from=build /app/target/hello-spring-boot-0.0.1-SNAPSHOT.jar app.jar

# Mở cổng ứng dụng
EXPOSE 8081

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java","-jar","app.jar"]
