package com.srinivart.producer;

import com.srinivart.message.ProducerMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Service
//@AllArgsConstructor
public class KafkaMessageProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);
    private final KafkaTemplate<String, ProducerMessage> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, ProducerMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(ProducerMessage producerMessage) {
        log.info("Published message to kafka queue: {}", producerMessage.getMessage());

        final String topic = kafkaTemplate.getDefaultTopic();
        //final String key = "producer key";
        //kafkaTemplate.send(topic, key, producerMessage);
        kafkaTemplate.send(topic, producerMessage);

        //final int partition = 0;
       //kafkaTemplate.send(topic, producerMessage.getPartition(), key, producerMessage);
    }

}
