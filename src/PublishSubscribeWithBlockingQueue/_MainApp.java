package PublishSubscribeWithBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class _MainApp {

    public static void main(String args[]){
  
     //Creating shared object Read more: https://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz5KwgGkycE
     BlockingQueue sharedQueue = new LinkedBlockingQueue();//it uses reentrant lock on put and take
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer(sharedQueue));
     Thread consThread = new Thread(new Consumer(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}


