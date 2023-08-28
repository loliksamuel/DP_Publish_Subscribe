# DP Publish Subscribe
What is pattern publish subscribe (also known as Observer or Listener)?

Publishers  are the entities who create/publish a message on a header. 
Subscribers/listeners/observers are the entities who subscribe  to a messages on a header.


In a header based Publish-Subscribe pattern, Publishers tag each message with the a header instead of referencing specific Subscribers. 
Messaging system then sends the message to all Subscribers who have asked to receive messages on that header.

Publishers only concern themselves with creating the original message and can leave the task of servicing the Subscribers to the messaging infrastructure (this is where pattern comes into picture).

<img class="irc_mi" src="https://image.slidesharecdn.com/broker2-100713053847-phpapp02/95/towards-improved-data-dissemination-of-publishsubscribe-systems-6-728.jpg?cb=1278999567" alt="Image result for publish subscribe broker architecture" onload="typeof google==='object'&amp;&amp;google.aft&amp;&amp;google.aft(this)" width="304" height="228" style="margin-top: 63px;">

see other reactive streams projects (build with functional pipeline & lazy evaluation):
- RxJava - https://github.com/ReactiveX/RxJava
- Vert.x - https://github.com/eclipse-vertx/vert.x (wrapper over RxJava)
- Akka - https://github.com/akka/akka
- Java 9 reactive streams - https://github.com/reactive-streams/reactive-streams-jvm
- Spring reactor - https://github.com/reactor/projectreactor.io
- Kafka
```
public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> s);
}
public interface Subscriber<T> {//with 3 channels
     public void onSubscribe(Subscription s);
     public void onNext(T t);//data
     public void onComplete();//all finished successfully
     public void onError(Throwable t);//to deal with exceptions
 }
 public interface Subscription {
    public void request(long n);//back pressure support
    public void cancel();
}
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
```

- https://www.youtube.com/watch?v=kG2SEcl1aMM

<img src="javaStream_Vs_ReactiveStream.png">


