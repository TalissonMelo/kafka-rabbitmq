FROM maven:3.8.4 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build ./build/target/*.jar ./api_gateway-.jar
ENTRYPOINT java -jar api_gateway-.jar