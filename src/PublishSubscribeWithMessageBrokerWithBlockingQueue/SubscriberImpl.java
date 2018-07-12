package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriberImpl extends Subscriber implements Runnable{

    private MsgBroker_Interface msgBroker;
    private Topic topic = null;

    public SubscriberImpl(MsgBroker_Interface msgBroker, String name){
        this.msgBroker = msgBroker;
        this.setName(name);

    }

    // subscribe with MsgBroker for a topic
    public void subscribe(MsgBroker msgBroker, Topic topic) {
        this.topic = topic;
        msgBroker.addSubscriber(topic, this);   }

    //Unsubscribe from a topic
    public void unSubscribe(Topic topic, MsgBroker msgBroker){
        msgBroker.removeSubscriber(topic, this);
    }

    //Request specifically for messages related to topic from MsgBroker
    public List<Message> getUpdates(Topic topic, MsgBroker_Interface msgBroker, Subscriber subscriber) throws InterruptedException {

       // msgBroker.broadcastToSubscriberOfTopic(topic, this);
        return msgBroker.getMessageFromQueue(topic, subscriber);


    }

    @Override
    public void run() {

        while(true){

            try {
                 getUpdates(topic, msgBroker, this);

                 //Thread.sleep(50);
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}