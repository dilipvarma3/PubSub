package pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Topic {

    private String topicName;
    private List<Message> messageList = new ArrayList<>(); // queue of messages

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {                             //used to get topic name
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void addToMessageList(Message message) {             //used to add message to the specifc topic
        this.messageList.add(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(getTopicName(), topic.getTopicName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopicName());
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                '}';
    }
}
