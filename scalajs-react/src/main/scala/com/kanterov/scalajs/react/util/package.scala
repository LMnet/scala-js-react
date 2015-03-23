/*
 * Copyright 2014 Xored Software, Inc.
 * Copyright 2015 Gleb Kanterov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kanterov.scalajs.react

import com.kanterov.scalajs.react.event.TypedSyntheticEvent
import org.scalajs.dom

import scala.scalajs.js

package object util {

  @deprecated("use TypedSyntheticEvent", "0.3.2")
  type TypedEvent[+T <: dom.EventTarget] = TypedSyntheticEvent[T]

  implicit class RichDictionary[T](val dict: js.Dictionary[T]) {
    def += (kv: (String, T)): js.Dictionary[T] = {
      dict.update(kv._1, kv._2)
      dict
    }
  }
}
