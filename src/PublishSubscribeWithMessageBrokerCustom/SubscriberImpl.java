package PublishSubscribeWithMessageBrokerCustom;

public class SubscriberImpl extends Subscriber{
    // subscribe with MsgBroker for a topic, sometimes called onSubscribe(Subscription s)
    public void subscribe(String topic, PubSubService pubSubService) { pubSubService.addSubscriber(topic, this);   }

    //Unsubscribe from a topic
    public void unSubscribe(String topic, PubSubService pubSubService){
        pubSubService.removeSubscriber(topic, this);
    }

    //Request specifically for messages related to topic from MsgBroker. sometimes called onNext(T t)
    public void getUpdates(String topic, PubSubService pubSubService)      { pubSubService.broadcastToSubscriberOfTopic(topic, this);

    }
    
    public void onError(){}
    
    public void onComplete(){}
}
