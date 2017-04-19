package PublishSubscribe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PubSubService implements PubSubService_Interface {
    //Keeps a map of topic per set of subscriber (using set to prevent duplicates)
    Map<String, Set<Subscriber>> topic2SubscriberMap = new HashMap<String, Set<Subscriber>>();

    //Holds messages published by publishers
    Queue<Message> messagesQueue = new LinkedList<Message>();

    //Adds message sent by publisher to queue
    public void addMessageToQueue(Message message){
        messagesQueue.add(message);
    }

    //Add a new Subscriber for a topic
    public void addSubscriber(String topic, Subscriber subscriber){

        if(topic2SubscriberMap.containsKey(topic)){
            Set<Subscriber> subscribers = topic2SubscriberMap.get(topic);
            subscribers.add(subscriber);
            topic2SubscriberMap.put(topic, subscribers);
        }else{
            Set<Subscriber> subscribers = new HashSet<Subscriber>();
            subscribers.add(subscriber);
            topic2SubscriberMap.put(topic, subscribers);
        }
    }

    //Remove an existing subscriber for a topic
    public void removeSubscriber(String topic, Subscriber subscriber){

        if(topic2SubscriberMap.containsKey(topic)){
            Set<Subscriber> subscribersNewSet = topic2SubscriberMap.get(topic);
            subscribersNewSet.remove(subscriber);
            topic2SubscriberMap.put(topic, subscribersNewSet);
        }
    }

    //Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
    public void broadcastToAll(){
        if(messagesQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!messagesQueue.isEmpty()){
                Message message = messagesQueue.remove();
                String topic = message.getTopic();

                Set<Subscriber> subscribersOfTopic = topic2SubscriberMap.get(topic);

                for(Subscriber subscriber : subscribersOfTopic){
                    //add broadcasted message to subscribers message queue
                    List<Message> subscriberMessages = subscriber.getMyMessages();
                    subscriberMessages.add(message);
                    subscriber.setMyMessages(subscriberMessages);
                }
            }
        }
    }

    //Sends messages about a topic for subscriber at any point
    public void broadcastToSubscriberOfTopic(String topic, Subscriber subscriber) {
        if(messagesQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!messagesQueue.isEmpty()){
                Message message = messagesQueue.remove();

                if(message.getTopic().equalsIgnoreCase(topic)){

                    Set<Subscriber> subscribersOfTopic = topic2SubscriberMap.get(topic);

                    for(Subscriber _subscriber : subscribersOfTopic){
                        if(_subscriber.equals(subscriber)){
                            //add broadcasted message to subscriber message queue
                            List<Message> subscriberMessages = subscriber.getMyMessages();
                            subscriberMessages.add(message);
                            subscriber.setMyMessages(subscriberMessages);
                            subscriber.update(topic,this);
                        }
                    }
                }
            }
        }
    }

}
