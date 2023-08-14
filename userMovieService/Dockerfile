FROM openjdk
WORKDIR usr/lib1
ENV MONGO_DATABASE=productdb
ENV MONGO_URL=mongodb://localhost:27017/productdb
ADD ./target/productSpring-0.0.1-SNAPSHOT.jar /usr/lib1/productSpring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","productSpring-0.0.1-SNAPSHOT.jar"]