package PublishSubscribe;

public interface Publisher_Interface<E> {
    public void subscribe (Subscriber_Interface<E> sub);

    public void publish (E arg);
}
