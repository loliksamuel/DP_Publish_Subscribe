package PublishSubscribeWithMessageBrokerWithBlockingQueue;

public interface Publisher_Interface {
    //Publishes new message to MsgBroker
    void publish(Message message, MsgBroker_Interface pubSubService) throws InterruptedException;
}
