package PublishSubscribeWithMessageBrokerWithBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Publisher_Impl implements Runnable, Publisher_Interface {


    private PubSubService_Interface pubSubService = null;
    private String topic;


    public Publisher_Impl(PubSubService_Interface pubSubService, String topic){
        this.pubSubService = pubSubService;
        this.topic = topic;
    }


    //Publishes new message to PubSubService
    public void publish(Message message, PubSubService_Interface pubSubService) throws InterruptedException {
        pubSubService.addMessageToQueue(message);
    }


    @Override
    public void run() {
        for (int i=0; i<10; i++){
            try {
                Message message = new Message(topic, ""+i);
                publish(message, pubSubService);
                //sharedQueue.put("published : "+i);
                System.out.println("published :"+topic+" : "+i);
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
