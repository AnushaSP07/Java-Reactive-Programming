package com.reactiveJava.udemy.sec01;

/*
1. publisher does not produce data unless subscriber requests for it
2. Publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer
 interested in consuming the data
4. producer can send the error signal to indicate something is wrong
 */


import com.reactiveJava.udemy.sec01.publisher.PublisherImpl;
import com.reactiveJava.udemy.sec01.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        demo4();

    }

    /*step1 from the above mentioned case*/
    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    /*step2 from the above mentioned case*/
    /* Step 2 - Publisher can also produce 0 items
     * - to handle this case, changing the max_items to 0
     * - will give no data to produce
     * */
    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2)); // Duration.ofSeconds is from Java 17 and above
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
    }

    /* Step 3 - subscriber can cancel the subscription */
    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }

    /* Step 4 - producer can send error signal */
    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }
}
