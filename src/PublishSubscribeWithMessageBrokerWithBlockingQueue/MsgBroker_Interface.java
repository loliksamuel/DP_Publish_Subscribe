package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.List;

/**
 * sometimes called Observable_Interface in observer design pattern
 * sometimes called Message broker
 */
public interface MsgBroker_Interface {

    public void addMessageToQueue(Topic   topic, Message message) throws InterruptedException;

    public List<Message> getMessageFromQueue(Topic   topic,  Subscriber subscriber) throws InterruptedException;

    //Add a new Subscriber for a topic  (sometimes called addObserver)
    public void addSubscriber(Topic   topic, Subscriber subscriber);

    //Remove an existing subscriber for a topic (sometimes called removeObserver)
    public void removeSubscriber(Topic topic, Subscriber subscriber);

//    //Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
//    public void broadcastToAll();//(sometimes called notifyAll)
//
//    //Sends messages about a topic for subscriber at any point
//    public void broadcastToSubscriberOfTopic(String topic, Subscriber subscriber) throws InterruptedException;
}
