# Spring demo project (mvc, kafka)

#### requirements:
java 8, maven, kafka.

#### build
`mvn clean package`

#### run
run kafka:
`./bin/zookeeper-server-start.sh config/zookeeper.properties`
`./bin/kafka-server-start.sh config/server.properties`
  
run app:
`mvn spring-boot:run -pl kafka-messaging -am` or `java -jar target/kafka-messaging.jar`

### documentation

Domain model:
* SimpleModel

Rest apis:
* POST /api/kafka

