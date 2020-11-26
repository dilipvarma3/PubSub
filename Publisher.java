package pubsub;

/**
 * Can independently publish messages to a topic in a broker
 * attributes: message
 * methods: publishMessage() -> send message to the broker on a given topic
 */
public class Publisher implements Client {

    int id;
    boolean isRegistered;
    Message message;

    static int MESSAGE_ID = 0;

    public Publisher(int id) {
        this.id = id;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * The publisher can publish a message at a time under a certain topic selected from different topics.
     * Subscriber that subscribe to a topic then receive messages under that topic.
     */
    public synchronized void publishMessage(Topic topic) {          
        MESSAGE_ID += 1;
        topic.addToMessageList(message);
    }

    @Override
    public void register() {
        
        isRegistered = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

}
