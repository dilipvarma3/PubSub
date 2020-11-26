package pubsub;

import java.util.*;

public class PubSub{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("*****Implementation of pub sub model*****");
        System.out.println("------------------------------------------------------------------------------------------");

        MessageBroker messageBroker = new MessageBroker();              //Initialization of Messagebroker
        Publisher pub1 = new Publisher(1);                                //Publisher
        Publisher pub2 = new Publisher(2);
        

        Subscriber sub1 = new Subscriber(1);                               //Subscriber
        Subscriber sub2 = new Subscriber(2);
        Subscriber sub3 = new Subscriber(3);
        

        Topic sports = messageBroker.getTopicList().get(0);
        Topic technology = messageBroker.getTopicList().get(1);
       

        // register clients

        pub1.register();
        pub2.register();
        
        Set<Publisher> p =new HashSet<>();
        p.add(pub1);
        p.add(pub2);
        sub1.register();
        sub2.register();
        sub3.register();
        Set<Subscriber> s =new HashSet<>();
        s.add(sub1);
        s.add(sub2);
        s.add(sub3);
        messageBroker.setPublishers(p);             // adding list of publishers to messagebroker
        messageBroker.setSubscribers(s);             // adding list of subscribers to messagebroker
        // setting subscriptions 
        sub1.subscribeToTopic(sports);                                  // subscribe to the sports topic
        sub2.subscribeToTopic(technology);
        sub3.subscribeToTopic(sports);
        sub3.subscribeToTopic(technology);
        // Add messages asynchronously
        Thread pubThread1 = new Thread(() -> {
            Message message = new Message(1,"I play soccer"); // creating a message
            pub1.setMessage(message);
            pub1.publishMessage(sports); // posting the message to a topic called sports
            System.out.println("Published message with id and title:" + message + " under topic: " + sports.getTopicName());
            System.out.println("Processed thread " + Thread.currentThread().getName());
        });

        Thread pubThread2 = new Thread(() -> {
            Message message = new Message(2,"I love java"); // creating a message
            pub1.setMessage(message);
            pub1.publishMessage(technology);// posting the message to a topic called technology
            System.out.println("Published message with id and title:" + message + " under topic: " + technology.getTopicName());
            System.out.println("Processed thread " + Thread.currentThread().getName());
        });

        Thread pubThread3 = new Thread(() -> {
            Message message = new Message(3,"I play cricket"); // creating a message
            pub2.setMessage(message);
            pub2.publishMessage(sports); // posting the message to a topic called sports
            System.out.println("Published message with id and title:" + message + " under topic: " + sports.getTopicName());
            System.out.println("Processed thread " + Thread.currentThread().getName());
        });


        pubThread1.start();                         // Starting a thread
        pubThread2.start();
        pubThread3.start();

        pubThread1.join();                          //Waiting for a thread to die
        pubThread2.join();
        pubThread3.join();

        // Once published, the subscribers that are subscribed to the topic are triggered
       
        Thread subThread1 = new Thread(() -> {
            messageBroker.notifySubscribers();
        });
        
        subThread1.start();
        subThread1.join();
        
        
         messageBroker.showAllMessages();                           //displaying all the messages available in each topic

    }
}