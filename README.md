# DP_Publish_Subscribe
Design pattern publish subscribe(also known as Observer or Listener)
What is topic based Publish-Subscribe (Pub-Sub) design pattern?

Publishers are the entities who create/publish a message on a topic. Subscribers are the entities who subscribe to messages on a topic.

In a topic based Publish-Subscribe pattern, Publishers tag each message with the a topic instead of referencing specific Subscribers. Messaging system then sends the message to all Subscribers who have asked to receive messages on that topic.

Publishers only concern themselves with creating the original message and can leave the task of servicing the Subscribers to the messaging infrastructure (this is where pattern comes into picture).
