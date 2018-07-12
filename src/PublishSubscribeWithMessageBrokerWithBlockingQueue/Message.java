package PublishSubscribeWithMessageBrokerWithBlockingQueue;

/**
 * Created by lolik on 2017-04-04.
 */
public class Message {
    private String header;
    private String payload;// the massage itself (can be big)

    public Message(){}
    public Message(String header, String payload) {
        this.header = header;
        this.payload = payload;
    }
    public String getHeader ()               { return header;           }
    public String getPayload()               { return payload;          }
    public void   setHeader (String header)  { this.header  = header;   }
    public void   setPayload(String payload) { this.payload = payload;  }
}
