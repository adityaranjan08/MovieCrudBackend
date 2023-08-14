FROM openjdk
WORKDIR usr/lib
ADD ./target/gatewayserver-0.0.1-SNAPSHOT.jar /usr/lib/gatewayserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "gatewayserver-0.0.1-SNAPSHOT.jar"]