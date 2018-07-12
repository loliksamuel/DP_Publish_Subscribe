package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

/* MsgBroker
sometimes called
   Observable_Interface in observer design pattern
or ProducerConsumerService
or Message broker
Advantages:
Loose coupling
Publishers are loosely coupled to subscribers,
and need not even know of their existence.
With the topic being the focus,
publishers and subscribers are allowed to remain ignorant of system topology.
Each can continue to operate normally regardless of the other. In the traditional tightly coupled client–server paradigm,
the client cannot post messages to the server while the server process is not running,
nor can the server receive messages unless the client is running.

Scalability
Provides the opportunity for better scalability than traditional client–server,
through parallel operation, message caching, tree-based or network-based routing, etc.
However, in certain types of tightly coupled, high-volume enterprise environments,
as systems scale up to become data centers with thousands of servers sharing the pub/sub infrastructure,
current vendor systems often lose this benefit; scalability for pub/sub products under high load in these contexts is a research challenge.
* */
public class MsgBroker implements MsgBroker_Interface {
    //Keeps a map of topic per set of subscriber (using set to prevent duplicates)


    private Set<Topic> topics = new HashSet<>();

    //Holds messages publishedby publishers. should use LinkedBlockingQueue for thread safety
    //private Map<String, BlockingQueue<Message>> topic2queue = new HashMap<>();

    //Add a new Subscriber for a topic

    public void addSubscriber(Topic topic, Subscriber subscriber) {
        topic.addSubscriber(subscriber);
        if (!topics.contains(topic)) {
            topics.add(topic);
        }
    }

    //Remove an existing subscriber for a topic
    public void removeSubscriber(Topic topic, Subscriber subscriber){
        if(topics.contains(topic)){
            topic.removeSubscriber(subscriber);
        }
    }




    //Adds message sent by publisher to queue
    public void addMessageToQueue(Topic topic, Message message) throws InterruptedException {
        topic.getQueue().put(message);
        if(!topics.contains(topic)) {
            topics.add(topic);
        }
    }

    //get message sent by publisher to queue
    public List<Message> getMessageFromQueue(Topic topic, Subscriber subscriber) throws InterruptedException {
        List<Message> msgs = new ArrayList<>();
        int count = topic.getQueue().size();
        Stream<Topic> ts = topics.stream ()
                                .filter (e->e.getSubscribers().contains(subscriber));
        Iterator<Topic> topicsRelevant =  ts.iterator();

        topicsRelevant.forEachRemaining(e-> {

                                    BlockingQueue<Message> bq = e.getQueue();
                                    if (!bq.isEmpty()) {
                                        Message m = new Message(bq.element().getHeader(), bq.element().getPayload());
                                        System.out.println(count+ " messages left in queue. subscriber " + subscriber.getName() + " consumed : " + m.getHeader() + " : " + m.getPayload());
                                        msgs.add(m);

                                        e.getQueue().remove();

                                    }


        });
        //topic.getQueue().take();

        return msgs;
    }

//    private Map<String, Map<Subscriber, BlockingQueue<Message>>> topics = new HashMap<>();
//
//
//
//    //Add a new Subscriber for a topic
//    public void addSubscriber(String topic, Subscriber subscriber){
//        BlockingQueue<Message> q = new LinkedBlockingQueue<>();
//        Map<Subscriber, BlockingQueue<Message>> sub2Queue = null;
//        if(topics.containsKey(topic)){
//
//            sub2Queue = topics.get(topic);
//
//        }else{
//
//            sub2Queue = new HashMap<>();
//
//        }
//        sub2Queue.put(subscriber, q );
//        topics.put(topic, sub2Queue);
//    }
//
//    //Remove an existing subscriber for a topic
//    public void removeSubscriber(String topic, Subscriber subscriber){
//
//        if(topics.containsKey(topic)){
//            Map<Subscriber, BlockingQueue<Message>> sub2Queue = topics.get(topic);
//            sub2Queue.remove(subscriber);
//            topics.put(topic, sub2Queue);
//        }
//    }


}
