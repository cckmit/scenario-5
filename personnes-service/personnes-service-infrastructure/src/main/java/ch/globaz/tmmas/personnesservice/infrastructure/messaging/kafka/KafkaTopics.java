package ch.globaz.tmmas.personnesservice.infrastructure.messaging.kafka;

public enum KafkaTopics {

    PERSONNE_CREE("personne-index-cree");

    String nom;

    KafkaTopics(String nom){
        this.nom = nom;
    }

    public String nom() {
        return nom;
    }
}
