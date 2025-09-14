package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

import java.util.concurrent.Flow;

/* Just is the factory method */
public class Lec02MonoJust {

    public static void main(String[] args) {
        /* mono.just is the easiest way to create a publisher
        will accepts anything integer or string */
        var mono = Mono.just("User");
      //  System.out.println(mono);
         /*we will not get any output here
         bcz we have not subscribed and requested anything (the terminal operations)*/
       // mono.subscribe();

        /* ABOVE also won't give any output
             we need subscriber object*/

        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
    }
}
