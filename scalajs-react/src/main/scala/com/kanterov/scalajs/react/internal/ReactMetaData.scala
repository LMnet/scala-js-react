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

package com.kanterov.scalajs.react.internal

import scala.scalajs.js

trait ReactMetaData

object ReactMetaData {

  def empty() = js.Dictionary.empty[js.Any]

  def apply(key: String, value: Option[(_) => _], md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    value match {
      case Some(x) => apply(key, x, md)
      case None => md
    }
  }

  def apply(key: String, value: () => _, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, js.Any.fromFunction0(value))
    md
  }

  def apply(key: String, value: ( _ ) => _, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, js.Any.fromFunction1(value))
    md
  }

  def apply(key: String, value: (_, _) => _, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, js.Any.fromFunction2(value))
    md
  }

  def apply(key: String, value: (_, _, _) => _, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, js.Any.fromFunction3(value))
    md
  }

  def apply(key: String, value: String, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, value)
    md
  }

  def apply(key: String, value: Boolean, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, value)
    md
  }

  def apply(key: String, value: Double, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, value)
    md
  }

  def apply[T](key: String, value: Map[String, T], md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, js.Dictionary.apply(value.toSeq: _*))
    md
  }

  def apply[T](key: String, value: js.Dictionary[T], md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, value)
    md
  }

  def apply(key: String, value: js.Dynamic, md: js.Dictionary[js.Any]): js.Dictionary[js.Any] = {
    md.update(key, value)
    md
  }
}
