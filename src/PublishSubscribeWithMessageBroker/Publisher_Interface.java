package PublishSubscribeWithMessageBroker;

public interface Publisher_Interface {
    //Publishes new message to MsgBroker
    void publish(Message message, PubSubService pubSubService);
}
