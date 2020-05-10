FROM maven:3.5.4-jdk-8

LABEL maintainer="subbareddygangalal@gmail.com"

EXPOSE 8081-8086

COPY target/customer-*.jar customer.jar 

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer.jar"]
