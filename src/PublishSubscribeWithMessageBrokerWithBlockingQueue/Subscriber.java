package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.List;

public abstract class Subscriber {


    private String name;
    //store all messages received by the subscriber
//    private List<Message> myMessages = new ArrayList<Message>();
//
//    public List<Message> getMyMessages() {
//        return myMessages;
//    }
//
//    public void setMyMessages(List<Message> myMessages) {
//        this.myMessages = myMessages;
//    }
//
//    //Print all messages received by the subscriber
//    public void printMyMessages() {
//        for (Message message : myMessages) {
//            System.out.println("Message Topic -> " + message.getHeader() + " : " + message.getPayload());
//        }
//    }
    //  subscribe for a topic using MsgBroker
    public abstract void subscribe(MsgBroker pubSubService, Topic topic);

    //Unsubscribe from topic using MsgBroker
    public abstract void unSubscribe(Topic topic, MsgBroker pubSubService);

    //Request specifically for messages related to topic from MsgBroker
    public abstract List<Message> getUpdates(Topic topic, MsgBroker_Interface pubSubService, Subscriber subscriber) throws InterruptedException;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}