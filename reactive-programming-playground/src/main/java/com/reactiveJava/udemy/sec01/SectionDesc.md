Section 1

- contains our own implementation of publisher and subscriber
- In real life this scenario will never come,
- this is just for basic understanding
- in real life we will be using project reactors


Use case is :
Publisher
    - Gives customer email address
 Subscription
 Subscriber
    - is interested in the customer email address so that it can send some promotional emails


Note:
1. publisher does not produce data unless subscriber requests for it
2. Publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer
 interested in consuming the data
4. producer can send the error signal to indicate something is wrong