package com.srinivart.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.srinivart.akka.ChildActor;
import com.srinivart.message.ProducerMessage;
import com.srinivart.producer.KafkaMessageProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
public class SendMessageController {
    private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);

    private ActorRef childActor;
    private ActorSystem system;

    private KafkaMessageProducer producer;
    private final KafkaTemplate<String, ProducerMessage> kafkaTemplate;

    public SendMessageController(KafkaMessageProducer producer, KafkaTemplate<String, ProducerMessage> kafkaTemplate) {
        this.producer = producer;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody ProducerMessage message) {
        log.info("Received request message send with body {} ", message);
        //producer.send(message);

        system = ActorSystem.create("MainActor");
        //ActorRef childActor = system.actorOf(Props.create(ChildActor.class), "ChildActor");
        childActor = system.actorOf(ChildActor.props(producer,kafkaTemplate), "ChildActor");
        childActor.tell(message,childActor);
    }

}
