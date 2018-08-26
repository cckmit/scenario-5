package ch.globaz.tmmas.personnesservice.application.event;




import ch.globaz.tmmas.personnesservice.domain.event.DomainEvent;
import ch.globaz.tmmas.personnesservice.domain.event.PersonneMoraleCreeEvent;
import ch.globaz.tmmas.personnesservice.domain.model.index.PersonneIndex;
import ch.globaz.tmmas.personnesservice.infrastructure.elasticsearch.ElasticSearchClient;
import ch.globaz.tmmas.personnesservice.infrastructure.messaging.MessagingService;
import ch.globaz.tmmas.personnesservice.infrastructure.messaging.kafka.KafkaTopics;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class DomainEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainEventListener.class);

    @Autowired
    MessagingService messagingService;


    @EventListener
    void onDomainEvent(DomainEvent event) throws JsonProcessingException {

        LOGGER.info("onDomainEvent {}",event);

    }

    @Async
    @EventListener
    void onPersonneMoraleCreeEvent(PersonneMoraleCreeEvent event) throws IOException {

        LOGGER.info("onPersonneMoraleCreeEvent {}",event);

        messagingService.sendForTopics(KafkaTopics.PERSONNE_CREE,event);
    }




}
