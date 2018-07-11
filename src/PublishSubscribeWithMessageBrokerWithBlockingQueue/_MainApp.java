package PublishSubscribeWithMessageBrokerWithBlockingQueue;

/**
 * Created by lolik on 2017-04-01.
 */
public class _MainApp {
    public static void main(String[] args) {
        PubSubService_Interface ps = new PubSubService();
        Publisher_Impl prod = new Publisher_Impl(ps);
        SubscriberImpl cons = new SubscriberImpl(ps);


        Thread prodThread = new Thread(prod);
        Thread consThread = new Thread(cons);
        prodThread.start();
        consThread.start();
    }

    /**
     *
     1  1
     2  10
     3  11
     4  100
     5  101
     6  110
     7  111
     8  1000
     900
     10
     11
     12
     13
     14
     15
     16
     17
     18
     19
     20
     21
     22
     23
     24
     Messages of Java Subscriber are:
     Message Topic -> Java : Core Java Concepts
     Message Topic -> Java : Spring MVC : Dependency Injection and AOP
     Message Topic -> Java : JPA & Hibernate

     Messages of Python Subscriber are:
     Message Topic -> Python : Easy and Powerful programming language
     Message Topic -> Python : Advanced Python message

     Messages of All Languages Subscriber are:
     Message Topic -> Java : Core Java Concepts
     Message Topic -> Java : Spring MVC : Dependency Injection and AOP
     Message Topic -> Java : JPA & Hibernate
     Message Topic -> Python : Easy and Powerful programming language
     Message Topic -> Python : Advanced Python message

     Publishing 2 more Java Messages...

     Messages of Java Subscriber now are:
     Message Topic -> Java : Core Java Concepts
     Message Topic -> Java : Spring MVC : Dependency Injection and AOP
     Message Topic -> Java : JPA & Hibernate
     Message Topic -> Java : JSP and Servlets
     Message Topic -> Java : Struts framework




     */
}
