package PublishSubscribe;

/**
 * replace the Observable_Interface in observer design pattern
 */
public interface PubSubService_Interface {

    public void addMessageToQueue(Message message);

    //Add a new Subscriber for a topic
    public void addSubscriber(String topic, Subscriber subscriber);

    //Remove an existing subscriber for a topic
    public void removeSubscriber(String topic, Subscriber subscriber);

    //Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
    public void broadcastToAll();

    //Sends messages about a topic for subscriber at any point
    public void broadcastToSubscriberOfTopic(String topic, Subscriber subscriber);
}
