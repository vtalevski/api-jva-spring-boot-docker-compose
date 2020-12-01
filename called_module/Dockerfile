FROM openjdk:latest

LABEL author = "Viktor Talevski"

ADD ./target/api-jva-spring-boot-docker-compose-called-module.jar ./api-jva-spring-boot-docker-compose-called-module.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "./api-jva-spring-boot-docker-compose-called-module.jar"]
