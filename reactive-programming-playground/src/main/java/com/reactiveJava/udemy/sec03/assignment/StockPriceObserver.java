package com.reactiveJava.udemy.sec03.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StockPriceObserver implements Subscriber<Integer> {
    private static Logger log = LoggerFactory.getLogger(StockPriceObserver.class);

    private int quantity = 0;
    private int balance = 1000;
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        if(price < 90 && balance >= price){
            quantity++;
            balance = balance - price;
            log.info("bought a stock at {}, total quantity {}, remaining balance: {}", price, quantity, balance);
        }else if(price > 100 && quantity > 0){
            log.info("selling price {} quantities at {}", quantity, price);
            balance = balance + (quantity * price);
            quantity = 0;
            subscription.cancel();
            log.info("profit is {}",balance - 1000);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("error", throwable);
    }

    @Override
    public void onComplete() {
        log.info("completed");
    }
}
