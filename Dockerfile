FROM openjdk:11
ADD target/chess.jar chess.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chess.jar"]
