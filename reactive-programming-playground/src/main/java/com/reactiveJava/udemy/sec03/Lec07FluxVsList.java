package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import com.reactiveJava.udemy.sec01.subscriber.SubscriberImpl;
import com.reactiveJava.udemy.sec03.helper.NameGenerator;

public class Lec07FluxVsList {
    public static void main(String[] args) {
      /*  var list = NameGenerator.getNameList(10);
        System.out.println(list);*/

      /*  the above code will not give any output and simply waits for 10 seconds blocking the user*/

        NameGenerator.getNameFlux(10)
                .subscribe(Util.subscriber());

        /*this code will keep on giving data without blocking*/
      /*  also we can use cancel to stop the next execution immediately but
                this feature is not there is non-reactive prgm*/

        /*trying using section - 2 subscription method*/

        var subscriber = new SubscriberImpl();
        NameGenerator.getNameFlux(10)
                .subscribe(subscriber);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();


    }
}
