FROM radut/openjdk-21-maven as builder

COPY src /usr/app/src
COPY pom.xml /usr/app

RUN mvn -f /usr/app/pom.xml clean package -DskipTests

FROM radut/openjdk-21-maven

COPY --from=builder /usr/app/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]