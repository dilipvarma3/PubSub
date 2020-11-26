package pubsub;

import java.util.*;

/**
 * The broker maintains a list of topics, and knows about the publishers and subscribers
 */
public class MessageBroker {

    static List<Topic> topicList = new ArrayList<>();
    Set<Publisher> publishers = new HashSet<>();
    Set<Subscriber> subscribers= new HashSet<>();

    HashMap<Topic, Integer> topicsLengthMap = new HashMap<>();

    public  void notifySubscribers() {
                // a message has been added
                
        for (Subscriber s : subscribers) {
            System.out.println("Show all messages under the topics subscribed by subscriber#" + s.getId());
            for (Topic topic: topicList) {
                if (topic.getMessageList().size() != topicsLengthMap.get(topic)) {
                    if (s.isRegistered() && s.isSubscribedTo(topic)) {
                        System.out.println("Topic: " + topic.getTopicName());
                        System.out.println("------------------------------------------------------------------------------------------");
                        for (Message m : topic.getMessageList()) {
                            System.out.println(m.getTitle());
                        }
                        System.out.println("------------------------------------------------------------------------------------------");
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
            System.out.println("Topic: " + topic.getTopicName());
            System.out.println("------------------------------------------------------------------------------------------");
            for (Message m : topic.getMessageList()) {
                System.out.println(m.getTitle());
            }
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public List<Topic> getTopicList() {                            // get list of topics available
        return topicList;
    }

    public void addToTopicList(Topic topic) {                       //used to add topics 
        this.topicList.add(topic);
    }

    public void setTopicList(List<Topic> topicList) {               
        this.topicList = topicList;
    }

    public Set<Publisher> getPublishers() {                         //get total publishers
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {          //setting publishers
        this.publishers = publishers;
    }

    public Set<Subscriber> getSubscribers() {                       // get subscribers
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {       //set subscribers
        this.subscribers = subscribers;
    }

    public HashMap<Topic, Integer> getTopicsLengthMap() {
        return topicsLengthMap;
    }

    public void setTopicsLengthMap(HashMap<Topic, Integer> topicsLengthMap) {
        this.topicsLengthMap = topicsLengthMap;
    }
}
