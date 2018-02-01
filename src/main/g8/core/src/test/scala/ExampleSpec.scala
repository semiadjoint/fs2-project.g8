package com.example

import org.scalatest._

class ExampleSpec extends FreeSpec with MustMatchers {
  "it works" - {
    "ex1" in {
      true mustBe true
    }
  }
}
