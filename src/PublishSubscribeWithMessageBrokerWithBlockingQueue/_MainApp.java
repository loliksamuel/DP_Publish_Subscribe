package PublishSubscribeWithMessageBrokerWithBlockingQueue;

/**
 * Created by lolik on 2017-04-01.
 * still bug with NoSuchElementException on some runs
 */
public class _MainApp {
    public static void main(String[] args) throws InterruptedException {

        Topic topicJava             = new Topic("java  Topic");
        Topic topicScala            = new Topic("scala Topic");
        MsgBroker broker            = new MsgBroker();
        Publisher publishJava  = new Publisher(broker, topicJava);
        Publisher publishScala = new Publisher(broker, topicScala);
        SubscriberImpl consJvm      = new SubscriberImpl(broker, "consJvm");
        SubscriberImpl consScala    = new SubscriberImpl(broker,"consScala");

        consJvm  .subscribe(broker, topicJava);
        consJvm  .subscribe(broker, topicScala);
        consScala.subscribe(broker, topicScala);

        Thread threadPublishJava   = new Thread(publishJava);
        Thread threadPublishScala  = new Thread(publishScala);
        Thread threadConsumerJvm   = new Thread(consJvm);
        Thread threadConsumerScala = new Thread(consScala);

        threadPublishJava  .start();
        threadPublishScala .start();
        threadConsumerJvm  .start();
        threadConsumerScala.start();


    }


}
