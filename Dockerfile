FROM java:8
VOLUME /tmp
EXPOSE 8080:8080
ADD cardservices-1.0.jar cards.jar
RUN bash -c 'touch /cards.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/cards.jar"]
