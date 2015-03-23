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

package com.kanterov.scalajs.react.event

import org.scalajs.dom
import org.scalajs.dom.HTMLInputElement

import scala.scalajs.js

trait TypedSyntheticEvent[+T <: dom.EventTarget] extends SyntheticEvent {
  override val target: T = js.native
}

trait TypedClipboardEvent[T <: dom.EventTarget] extends ClipboardEvent with TypedSyntheticEvent[T]
trait TypedFocusEvent[T <: dom.EventTarget] extends FocusEvent with TypedSyntheticEvent[T]
trait TypedFormEvent[T <: dom.EventTarget] extends FormEvent with TypedSyntheticEvent[T]
trait TypedKeyboardEvent[T <: dom.EventTarget] extends KeyboardEvent with TypedSyntheticEvent[T]
trait TypedMouseEvent[T <: dom.EventTarget] extends MouseEvent with TypedSyntheticEvent[T]
trait TypedTouchEvent[T <: dom.EventTarget] extends TouchEvent with TypedSyntheticEvent[T]
trait TypedUIEvent[T <: dom.EventTarget] extends UIEvent with TypedSyntheticEvent[T]
trait TypedWheelEvent[T <: dom.EventTarget] extends WheelEvent with TypedSyntheticEvent[T]

trait TypedInputFormEvent extends TypedFormEvent[HTMLInputElement] {
  val value: String = js.native
}

trait TypedCheckboxFormEvent extends TypedFormEvent[HTMLInputElement] {
  val checked: Boolean = js.native
}

trait TypedOptionFormEvent extends TypedFormEvent[HTMLInputElement] {
  val selected: Boolean = js.native
}
