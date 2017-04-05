package PublishSubscribe;

public interface Publisher_Impl<E> {
    //Publishes new message to PubSubService
    void publish(Message message, PubSubService pubSubService);
}
