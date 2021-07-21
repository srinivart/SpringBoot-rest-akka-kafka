package com.srinivart.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.srinivart.message.ProducerMessage;
import com.srinivart.producer.KafkaMessageProducer;
import org.springframework.kafka.core.KafkaTemplate;

    //public class ChildActor extends UntypedAbstractActor {
    public class ChildActor extends AbstractActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props(KafkaMessageProducer producer, KafkaTemplate<String, ProducerMessage> kafkaTemplate) {
        return Props.create(ChildActor.class, producer,kafkaTemplate);
    }



    private KafkaMessageProducer producer;
    private final KafkaTemplate<String, ProducerMessage> kafkaTemplate;

    public ChildActor(KafkaMessageProducer producer, KafkaTemplate<String, ProducerMessage> kafkaTemplate) {
        this.producer = producer;
        this.kafkaTemplate = kafkaTemplate;
    }

        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(ProducerMessage.class, this::sendToProducer)
                    .matchAny(message -> {
                        log.info("message is unhandled = {}", message.getClass().getName());
                        super.unhandled(message);
                    })
                    .build();
        }

        private void sendToProducer(ProducerMessage message){
            producer.send(message);
        }







/*
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String) {
            System.out.println("Sender : " + getSender());
            log.info("Message From Main Actor: " + message);
        }
             System.out.println("msg -->"+ message);
            if(message instanceof ProducerMessage)
                producer.send((ProducerMessage) message);

   }
   */



}