FROM maven:3.8.4 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build ./build/target/*.jar ./order-.jar
ENTRYPOINT java -jar order-.jar