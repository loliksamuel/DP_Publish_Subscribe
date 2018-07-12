package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Publisher implements Runnable, Publisher_Interface {


    private MsgBroker_Interface pubSubService = null;

    private Topic topic;

    public Publisher(MsgBroker_Interface pubSubService, Topic topic){
        this.pubSubService = pubSubService;

        this.topic = topic;
    }


    //Publishes new message to MsgBroker
    public void publish(Message message, MsgBroker_Interface pubSubService) throws InterruptedException {
        pubSubService.addMessageToQueue(topic, message);
    }


    @Override
    public void run() {
        for (int i=1; i<=10; i++){
            try {
                Message message = new Message(topic.getName(), ""+i);
                publish(message, pubSubService  );
                //sharedQueue.put("published : "+i);
                //Thread.sleep(10);
                System.out.println("published :"+ topic.getName() +" : "+i);
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
