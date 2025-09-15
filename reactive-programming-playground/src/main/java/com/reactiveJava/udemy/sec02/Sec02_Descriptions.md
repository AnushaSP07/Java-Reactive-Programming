Project Reactor

- As said earlier, reactive stream is a specification, Reactor is a library and one of the implementations (like hibernate for JPA)
- We know that publisher is one of the interface in the reactive stream for which the reactor library provides two different implementations
	1. Mono
	2. Flux

1. Mono
- can emit 0 or 1 item, followed by an onComplete or onError Signal
- if the publisher does not have data to give, in this case, we will get onComplete directly without any itme
- it is not mandatory for a publisher to emit an item they can simply call onComplete
- No Stream
- no Backpressure
- a light weight publisher
- Request -> response model

2. Flux
- can emit 0 or n items, it is like a never ending infinite stream
- the stream can be completed via onComplete method once it has emitted all the data
- or the subscriber can also cancel when it no longer needs the data
- the flux can close the call when it encounters any exceptions after emitting the error via onError method
- gives streams of messages
- Backpressure (producer emits too much data which consumer can not handle)
- many additional methods specific to handle stream processing


3. Mono
Provides set of factory methods
Just - when the value is in memory already
empty - no itme to emit
error - emit error
fromSupplier - defer execution by using Supplier<T>
fromCallable - defer execution by using Callable<T>
fromFuture - Publisher from completableFuture<T>

Difference between supplier and callable is
- supplier will not throw exception or it does not have the exception as 
- part of method signature
- It can throw run time exception, but it does not have the checked exception