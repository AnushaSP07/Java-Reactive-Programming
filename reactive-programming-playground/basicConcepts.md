<h1>Reactive Streams: Publisher-Subscriber Model</h1>

<h2>Overview</h2>
<p>This document explains the interaction between a <strong>Publisher</strong> and a <strong>Subscriber</strong> in a reactive stream system, following the standard specification. It covers the lifecycle from subscription to completion or error.</p>

<hr>

<h2>Step 1: Subscriber Wants to Connect</h2>
<p>There are two main components:</p>
<ul>
  <li><strong>Publisher</strong></li>
  <li><strong>Subscriber</strong></li>
</ul>
<p>The subscriber wants to receive updates from the publisher. The publisher exposes a <code>subscribe</code> method:</p>

<pre><code>public interface Publisher&lt;T&gt; {
    public void subscribe(Subscriber&lt;? super T&gt; s);
}
</code></pre>

<p>Using this method, the subscriber instance is passed to the publisher to initiate the connection.</p>

<hr>

<h2>Step 2: Publisher Calls <code>onSubscribe</code></h2>
<p>Once the publisher accepts the subscription request, it provides a <code>Subscription</code> object to the subscriber:</p>

<pre><code>public interface Subscriber&lt;T&gt; {
    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
    public void onComplete();
}
</code></pre>

<p>The <code>onSubscribe</code> method is invoked with the <code>Subscription</code> object, establishing the communication channel.</p>

<hr>

<h2>Step 3: Subscription</h2>
<p>The <code>Subscription</code> object acts as a bridge between the publisher and the subscriber.</p>
<ul>
  <li>The subscriber can <strong>request items</strong> from the publisher.</li>
  <li>The subscriber can <strong>cancel</strong> the subscription to stop receiving updates.</li>
</ul>

<hr>

<h2>Step 4: Publisher Pushes Data via <code>onNext</code></h2>
<p>When the subscriber requests items (e.g., <code>request(3)</code>), the publisher responds by invoking <code>onNext</code>:</p>

<pre><code>subscription.request(3);
</code></pre>

<ul>
  <li>The publisher calls <code>onNext</code> <strong>sequentially</strong> for each item.</li>
  <li>It <strong>must not exceed</strong> the number of requested items.</li>
</ul>

<h3>Important Notes:</h3>
<ul>
  <li>Publisher emits <strong>only the requested number of items or fewer</strong>.</li>
  <li>Emitting more than requested <strong>violates the specification</strong>.</li>
  <li>The subscriber can <strong>request more items</strong> later using the same subscription.</li>
</ul>

<hr>

<h2>Step 5: <code>onComplete</code></h2>
<p>When the publisher has no more items to emit, it calls:</p>

<pre><code>subscriber.onComplete();
</code></pre>

<ul>
  <li>This signals that the data stream is finished.</li>
  <li>No further items will be sent after this.</li>
</ul>

<hr>

<h2>Step 6: <code>onError</code></h2>
<p>If an error occurs during processing, the publisher calls:</p>

<pre><code>subscriber.onError(Throwable t);
</code></pre>

<ul>
  <li>This sends the error details to the subscriber.</li>
  <li>After this, the subscription is considered <strong>terminated</strong>.</li>
</ul>

<hr>

<h2>Summary</h2>
<ul>
  <li><strong>Publisher</strong> has a <code>subscribe</code> method to accept a <strong>Subscriber</strong>.</li>
  <li>Upon subscription, a <strong>Subscription</strong> object is passed to the subscriber.</li>
  <li>The subscriber uses this object to <strong>request items</strong>.</li>
  <li>The publisher sends items via <code>onNext</code>, respecting the requested count.</li>
  <li>Completion is signaled via <code>onComplete</code>.</li>
  <li>Errors are communicated via <code>onError</code>.</li>
</ul>

<hr>

<h2>Terminologies</h2>

<table>
  <thead>
    <tr>
      <th>Role</th>
      <th>Alternate Names</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Publisher</strong></td>
      <td>Source, Observable, Upstream, Producer</td>
    </tr>
    <tr>
      <td><strong>Subscriber</strong></td>
      <td>Sink, Observer, Downstream, Consumer</td>
    </tr>
    <tr>
      <td><strong>Processor</strong></td>
      <td>Operator</td>
    </tr>
  </tbody>
</table>