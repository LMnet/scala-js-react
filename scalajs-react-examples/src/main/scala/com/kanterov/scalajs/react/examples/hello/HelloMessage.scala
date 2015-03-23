package com.kanterov.scalajs.react.examples.hello

import com.kanterov.scalajs.react._

object HelloMessage extends TypedReactSpec {

  case class State()
  case class Props(name: String)

  def getInitialState(self: This) = State()

  @scalax
  def render(self: This) = {
    <div>Hello {self.props.name}</div>
  }
}
