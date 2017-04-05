package PublishSubscribe;

/**
 * Created by lolik on 2017-04-01.
 */
public class _MainApp {
    public static void main(String[] args) {

        Subject topic = new Subject();//create subject
         //create 3 observers or subscribers or listeners
        Observer subscriber1 = new Observer.ObserverBinary(topic);
        Observer subscriber2 = new Observer.ObserverOctal(topic);
        Observer subscriber3 = new Observer.ObserverHexa(topic);

        System.out.println( "after subscribing 3 subscribers,");
        topic.attach(subscriber1);
        topic.attach(subscriber2);
        topic.attach(subscriber3);
        System.out.println( "all 3 will get updates:");
        //change the topic
        topic.setState(1);
        topic.setState(10);
        topic.setState(15);

        System.out.println( "after removing subscriber #1,");
        topic.detach(subscriber1);
        System.out.println( "only 2 and 3 will get updates:");
        topic.setState(1);
        topic.setState(2);
        topic.setState(30);


        String a= new String("a");
        String b= new String("a");
        System.out.println( "hashcode of a and b are equals? "+ a.hashCode());
        System.out.println( "a.hashCode()="+ a.hashCode());
        System.out.println( "b.hashCode()="+ b.hashCode());

        System.out.println( "a equals b ? "+ a.equals(b));
        System.out.println( "a == b ? "+ (a==b));

         a= "a";
         b= "a";

        System.out.println( "a equals b ? "+ a.equals(b));
        System.out.println( "a == b ? "+ (a==b));

    }
}
