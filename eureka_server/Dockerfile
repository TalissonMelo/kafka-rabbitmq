FROM maven:3.8 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build ./build/target/*.jar ./eureka_server-.jar
ENTRYPOINT java -jar eureka_server-.jar