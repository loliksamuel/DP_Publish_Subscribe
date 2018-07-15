package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//A topic in kafka can be split into 1 or more partition
//ordering is guranteed only in 1 partition
public class Topic {


    private String name;
    private Set<Subscriber> subscribers = new HashSet<>();
    private final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public Topic(String name) {
        this.name = name;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }


    public BlockingQueue<Message> getQueue() {
        return queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }


}
