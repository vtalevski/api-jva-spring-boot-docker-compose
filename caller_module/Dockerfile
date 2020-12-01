FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-docker-compose-caller-module.jar ./api-jva-spring-boot-docker-compose-caller-module.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "./api-jva-spring-boot-docker-compose-caller-module.jar"]
