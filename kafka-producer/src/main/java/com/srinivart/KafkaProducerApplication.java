package com.srinivart;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.srinivart.akka.ChildActor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);



		//ActorSystem system = ActorSystem.create("MainActor");
					//ActorRef mySystem = system.actorOf(Props.create(MainActor.class),"MainActor2");
					//ActorRef childActor = system.actorOf(Props.create(ChildActor.class));
		//ActorRef childActor = system.actorOf(Props.create(ChildActor.class), "ChildActor");

					//childActor.tell("Hey !!",ActorRef.noSender());
		//childActor.tell("Hey !!",childActor);
	}

}
