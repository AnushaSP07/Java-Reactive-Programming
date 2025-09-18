package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import com.reactiveJava.udemy.sec03.assignment.StockPriceObserver;
import com.reactiveJava.udemy.sec03.client.ExternalServiceClient;

public class Lec12Assignment {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        var subscriber = new StockPriceObserver();
        client.getPriceChanges()
                .subscribe(subscriber);

        Util.sleepSeconds(20);
    }
}
