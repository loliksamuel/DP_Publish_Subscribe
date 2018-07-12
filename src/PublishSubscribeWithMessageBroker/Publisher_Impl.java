package PublishSubscribeWithMessageBroker;

public class Publisher_Impl implements Publisher_Interface {
    //Publishes new message to MsgBroker
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}
