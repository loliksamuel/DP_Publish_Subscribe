package PublishSubscribeWithService;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    //store all messages received by the subscriber
    private List<Message> myMessages = new ArrayList<Message>();

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
    //  subscribe for a topic using PubSubService
    public abstract void subscribe(String topic, PubSubService pubSubService);

    //Unsubscribe from topic using PubSubService
    public abstract void unSubscribe(String topic, PubSubService pubSubService);

    //Request specifically for messages related to topic from PubSubService
    public abstract void update(String topic, PubSubService pubSubService);

}