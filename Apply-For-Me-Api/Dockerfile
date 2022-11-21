FROM openjdk:8

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN mvn install

ADD target/Apply-For-Me-Api.jar Apply-For-Me-Api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Apply-For-Me-Api.jar"]
