package PublishSubscribeWithMessageBrokerCustom;

/**
 * Created by lolik on 2017-04-01.
 */
public class _MainApp {
    public static void main(String[] args) {

        //Instantiate publishers, subscribers and MsgBroker
        Publisher_Interface javaPublisher   = new Publisher_Impl();
        Publisher_Interface pythonPublisher = new Publisher_Impl();

        Subscriber javaLover         = new SubscriberImpl();
        Subscriber allLanguagesLover = new SubscriberImpl();
        Subscriber pythonLover       = new SubscriberImpl();

        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to MsgBroker
        Message javaMsg1 = new Message("Java", "Core Java Concepts");
        Message javaMsg2 = new Message("Java", "Spring MVC : Dependency Injection and AOP");
        Message javaMsg3 = new Message("Java", "JPA & Hibernate");

        javaPublisher.publish(javaMsg1, pubSubService);
        javaPublisher.publish(javaMsg2, pubSubService);
        javaPublisher.publish(javaMsg3, pubSubService);

        Message pythonMsg1 = new Message("Python", "Easy and Powerful programming language");
        Message pythonMsg2 = new Message("Python", "Advanced Python message");

        pythonPublisher.publish(pythonMsg1, pubSubService);
        pythonPublisher.publish(pythonMsg2, pubSubService);

        //Declare Subscribers
        javaLover.subscribe("Java",pubSubService);		//Java subscriber only subscribes to Java topics
        pythonLover.subscribe("Python",pubSubService);   //Python subscriber only subscribes to Python topics
        allLanguagesLover.subscribe("Java", pubSubService);	//all subscriber, subscribes to both Java and Python
        allLanguagesLover.subscribe("Python", pubSubService);

        //Trying unSubscribing a subscriber
        pythonLover.unSubscribe("Python", pubSubService);

        //Broadcast message to all subscribers. After broadcastToAll, messageQueue will be empty in MsgBroker
        pubSubService.broadcastToAll();
        System.out.println("broadcast To All successfully Done");

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of Java Subscriber are: ");
        javaLover.printMyMessages();

        System.out.println("\nMessages of Python Subscriber after unsubscription are: ");
        pythonLover.printMyMessages();

        System.out.println("\nMessages of All Languages Subscriber are: ");
        allLanguagesLover.printMyMessages();

        //After broadcastToAll the messagesQueue will be empty, so publishing new messages to server
        System.out.println("\nPublishing 2 more Java Messages...");
        Message javaMsg4 = new Message("Java", "JSP and Servlets");
        Message javaMsg5 = new Message("Java", "Struts framework");

        javaPublisher.publish(javaMsg4, pubSubService);
        javaPublisher.publish(javaMsg5, pubSubService);

        javaLover.getUpdates("Java", pubSubService);
        System.out.println("\nMessages of Java Subscriber now are: ");
        javaLover.printMyMessages();
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
