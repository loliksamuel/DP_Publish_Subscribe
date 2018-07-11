package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriberImpl extends Subscriber implements Runnable{

    PubSubService_Interface pubSubService;
    String topic = null;

    public SubscriberImpl(PubSubService_Interface pubSubService, String topic){
        this.pubSubService=pubSubService;
        this.topic = topic;
    }

    // subscribe with PubSubService for a topic
    public void subscribe(String topic, PubSubService pubSubService) { pubSubService.addSubscriber(topic, this);   }

    //Unsubscribe from a topic
    public void unSubscribe(String topic, PubSubService pubSubService){
        pubSubService.removeSubscriber(topic, this);
    }

    //Request specifically for messages related to topic from PubSubService
    public Message getUpdates(String topic, PubSubService_Interface pubSubService) throws InterruptedException {

       // pubSubService.broadcastToSubscriberOfTopic(topic, this);
        return pubSubService.getMessageFromQueue();


    }

    @Override
    public void run() {

        while(true){

            try {
                Message msg = getUpdates(topic, pubSubService);
                System.out.println("consumed : "+msg.getTopic()+" : "+msg.getPayload());
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}