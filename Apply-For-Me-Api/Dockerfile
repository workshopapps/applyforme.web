FROM openjdk:8
WORKDIR /frontend
COPY ./Apply-For-Me-Api .
RUN mvn install
ADD target/Apply-For-Me-Api.jar Apply-For-Me-Api.jar
ENTRYPOINT ["java", "-jar","Apply-For-Me-Api.jar"]
EXPOSE 8080