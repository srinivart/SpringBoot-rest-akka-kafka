# SpringBoot-rest-akka-kafka



Local Installation
--------------
cd /Users/srinivaspanaganti/Music/Servers/kafka_2.13-2.8.0/bin




Start zookeeper
----------
sh bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka
----------
sh bin/kafka-server-start.sh config/server.properties


Crete Topic
----------
bin/kafka-topics.sh --create --topic mytopic --bootstrap-server localhost:9092
Created topic mytopic.


bin/kafka-topics.sh --bootstrap-server=localhost:9092 --list
mytopic


Start Producer / consumer
----------------

binkafka-console-producer.sh --broker-list localhost:9092 --topic mytopic

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic --from-beginning





Postman
----------

@POST
----------
http://localhost:8888/message/send

Body
-------
{
	"message" : "Hey Srini"
}





TEst the output
--------------------
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic --from-beginning

{"message":"Hey Srini"}
