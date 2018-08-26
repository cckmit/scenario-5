package ch.globaz.tmmas.personnesservice.infrastructure.messaging;

import ch.globaz.tmmas.personnesservice.domain.event.PersonneMoraleCreeEvent;
import ch.globaz.tmmas.personnesservice.infrastructure.messaging.kafka.KafkaTopics;


public interface MessagingService {

    void sendForTopics(KafkaTopics topic, PersonneMoraleCreeEvent event);
}
