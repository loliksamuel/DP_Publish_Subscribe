package PublishSubscribeWithMessageBroker;

public interface Publisher_Interface {
    //Publishes new message to PubSubService
    void publish(Message message, PubSubService pubSubService);
}
