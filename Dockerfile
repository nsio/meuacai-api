FROM openjdk:8-jdk
EXPOSE 8080
ADD target/meuacai-api.jar meuacai-api.jar
ENTRYPOINT ["java","-jar","/meuacai-api.jar"]