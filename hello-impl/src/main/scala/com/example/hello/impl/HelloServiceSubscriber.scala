package com.example.hello.impl

import akka.Done
import akka.stream.scaladsl.Flow
import com.example.hello.api.HelloService

class HelloServiceSubscriber(helloService: HelloService) {

  helloService
    .greetingsTopic()
    .subscribe // <-- you get back a Subscriber instance
      .atLeastOnce(
    Flow.fromFunction { msg =>
      // Do somehting with the `msg`]
      println(msg.message)
      //doSomethingWithTheMessage(msg)
      Done
    }
  )

}