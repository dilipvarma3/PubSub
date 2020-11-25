package pubsub;

import java.util.*;

/**
 * The broker maintains a list of topics, and knows about the publishers and subscribers
 *
 */
public class MessageBroker {

    static List<Topic> topicList = new ArrayList<>();
    Set<Publisher> publishers = new HashSet<>();
    Set<Subscriber> subscribers= new HashSet<>();

    HashMap<Topic, Integer> topicsLengthMap = new HashMap<>();

    public void notifySubscribers() {
        for (Topic topic: topicList) {
            if (topic.getMessageList().size() != topicsLengthMap.get(topic)) {
                // a message has been added
                for (Subscriber s : subscribers) {
                    if (s.isRegistered() && s.isSubscribedTo(topic)) {
                        
                    }
                }
            }
        }
    }

    public MessageBroker() {                                                                //used to add various topics into a Message broker
        topicList.add(new Topic("Sports"));
        topicList.add(new Topic("Technology"));
        

        for (Topic topic : topicList) {
            topicsLengthMap.put(topic, topic.getMessageList().size()); // set how many messages each topic has
        }
    }


    public void showAllMessages() {
        System.out.println();
        System.out.println("Showing all messages under all the topics");
        for (Topic topic: topicList) {
            System.out.println("Topic: " + topic);
            System.out.println("----------------------------------------------");
            for (Message m : topic.getMessageList()) {
                System.out.println(m.getTitle());
            }
            System.out.println("----------------------------------------------");
            System.out.println();
        }
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void addToTopicList(Topic topic) {
        this.topicList.add(topic);
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public HashMap<Topic, Integer> getTopicsLengthMap() {
        return topicsLengthMap;
    }

    public void setTopicsLengthMap(HashMap<Topic, Integer> topicsLengthMap) {
        this.topicsLengthMap = topicsLengthMap;
    }
}
