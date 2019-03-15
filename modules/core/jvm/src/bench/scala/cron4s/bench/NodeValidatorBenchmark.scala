/*
 * Copyright 2017 Antonio Alonso Dominguez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cron4s
package bench

import cron4s.expr._
import cron4s.validation.NodeValidator

import org.scalameter.api._
import org.scalameter.picklers.noPickler._

object NodeValidatorBenchmark extends Bench.OfflineRegressionReport {
  import CronField._

  override def persistor = new SerializationPersistor

  val severalNodes = Gen.enumeration("several")(
    SeveralNode(ConstNode[Second](35), ConstNode[Second](40))
  )

  val severalNodeValidator = NodeValidator[SeveralNode[Second]]

  performance of "NodeValidator[SeveralNode]" in {
    measure method "validate" in {
      using(severalNodes) in { node =>
        severalNodeValidator.validate(node)
      }
    }
  }
}
