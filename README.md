## Apache Camel Integration with Spring-boot and Kafka
### Services
* **superhero-searcher** (acts as a Kafka producer)

```
Application that searches for superheroes disguised as normal human beings, collects their information and publishes it to a kafka topic through a Camel Route
```
* **superhero-registry** (acts as a Kafka consumer)
```
Application that consumes superhero information from configured Kafka topic using a Camel Route and Stores it in an in-memory DB
```
### Flow 
* Superhero-searcher microservice creates a SuperHero POJO using [Java-faker](https://github.com/DiUS/java-faker) and publishes the created object to a Kafka topic `superhero-information` after every 5 seconds.
* A Dead letter topic `superhero-information-dlx` is configured for messages that are failed to published in the main Kafka topic 
* Superhero-registry consumes the messages from the Kafka topic, parses it and saves it to an in-memory DB.
* Dog-adoptiion-center exposes GET `/v1/registry/superheroes` API to retreive all records of superheroes
### Important Classes
* [SuperHeroSearchScheduler.class](https://github.com/hardikSinghBehl/camel-integration-spring-boot-kafka/blob/main/superhero-searcher/src/main/java/com/behl/searcher/route/SuperHeroSearchScheduler.java)
* [SuperHeroInformationConsumptionRoute.class](https://github.com/hardikSinghBehl/camel-integration-spring-boot-kafka/blob/main/superhero-registry/src/main/java/com/behl/registry/route/SuperHeroInformationConsumptionRoute.java)
* [KafkaConfigurationProperties.class](https://github.com/hardikSinghBehl/camel-integration-spring-boot-kafka/blob/main/superhero-searcher/src/main/java/com/behl/searcher/properties/KafkaConfigurationProperties.java)
* [SuperHeroRegistryDatasourceProcessor.class](https://github.com/hardikSinghBehl/camel-integration-spring-boot-kafka/blob/main/superhero-registry/src/main/java/com/behl/registry/processor/SuperHeroRegistryDatasourceProcessor.java)
---

### Local Setup with Docker

* Install Java 17 (recommended to use [SdkMan](https://sdkman.io))

```
sdk install java 17-open
```

* Install Maven (recommended to use [SdkMan](https://sdkman.io))

```
sdk install maven
```
* Clone the repo

```
git clone https://github.com/hardikSinghBehl/kafka-java-spring-boot-poc.git
```

* Run the below command inside both services

```
mvn clean install
```

* Run the below commands to start docker containers in the root directory

```
sudo docker-compose build
```

```
sudo docker-compose up -d
```

* Run the below command to stop docker containers

```
sudo docker-compose down
```

---

### Demonstration Recording

https://user-images.githubusercontent.com/69693621/169650284-c96c4075-02d6-4be3-9f1e-ab8d882dcf8e.mov



