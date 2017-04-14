package PublishSubscribe;

public class SubscriberImpl extends Subscriber{
    // subscribe with PubSubService for a topic
    public void subscribe(String topic, PubSubService pubSubService){
        pubSubService.addSubscriber(topic, this);
    }

    //Unsubscribe from a topic
    public void unSubscribe(String topic, PubSubService pubSubService){
        pubSubService.removeSubscriber(topic, this);
    }

    //Request specifically for messages related to topic from PubSubService
    public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) { pubSubService.broadcastToSubscriberOfTopic(topic, this);

    }
}