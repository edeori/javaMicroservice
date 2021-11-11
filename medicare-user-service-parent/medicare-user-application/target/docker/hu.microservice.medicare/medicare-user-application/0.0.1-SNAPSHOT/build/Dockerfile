FROM adoptopenjdk:15.0.2_7-jre-hotspot
COPY maven /
ENTRYPOINT ["java","-Xms512m","-Xmx512m","-jar","/medicare-user-application-0.0.1-SNAPSHOT.jar"]
