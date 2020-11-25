package pubsub;

import java.util.HashSet;
import java.util.Set;

public class Subscriber implements Client {

    int id;
    boolean isRegistered = false;
    Set<Topic> subscriptions = new HashSet<>();

    public Subscriber(int id) {
        this.id = id;
    }

    public void subscribeToTopic(Topic topic) {
        subscriptions.add(topic);
    }

    public void showSubscribedMessages() {
        System.out.println("Show all messages under the topics subscribed by subscriber#" + id);
        for (Topic topic: subscriptions) {
            System.out.println("Topic: " + topic.getTopicName());
            System.out.println("----------------------------------------------");
            for (Message m : topic.getMessageList()) {
                System.out.println(m.getTitle());
            }
            System.out.println("----------------------------------------------");
        }
    }

    @Override
    public void register() {
        isRegistered = true;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    /**
     * To check if it is subscribed to the pertaining topic
     * @param topic
     * @return
     */
    public boolean isSubscribedTo(Topic topic) {
        for (Topic topic1 : subscriptions) {
            if (topic.equals(topic1)) {
                return true;
            }
        }
        return false;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Topic> getSubscriptions() {
        return subscriptions;
    }

    public void addToSubscriptions(Topic subscription) {
        this.subscriptions.add(subscription);
    }
}
