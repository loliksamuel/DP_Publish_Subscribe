package PublishSubscribeWithMessageBrokerCustom;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    //store all messages received by the subscriber
    private List<Message> myMessages = new ArrayList<>();

    public List<Message> getMyMessages() {
        return myMessages;
    }

    public void setMyMessages(List<Message> myMessages) {
        this.myMessages = myMessages;
    }

    //Print all messages received by the subscriber
    public void printMyMessages() {
        for (Message message : myMessages) {
            System.out.println("Message Topic -> " + message.getTopic() + " : " + message.getPayload());
        }
    }
    //  subscribe for a topic using MsgBroker, sometimes called onSubscribe(Subscription s)
    public abstract void subscribe(String topic, PubSubService pubSubService);

    //Unsubscribe from topic using MsgBroker. sometimes called cancel()
    public abstract void unSubscribe(String topic, PubSubService pubSubService);

    //Request specifically for messages related to topic from MsgBroker. sometimes called getUpdates or consume or onNext(T t)
    public abstract void getUpdates(String topic, PubSubService pubSubService);

}
