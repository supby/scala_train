package module5_function

import scala.math._

object Fun extends App {
    val num = 3.14

    val fun = ceil _
    println(fun(num))

    Array(3.14, 1.42, 2.0).map(fun)

    val triple = (x: Double) => x * 3
    def triple2(x: Double) = x * 3

    Array(3.14, 1.42, 2.0).map((x: Double) => x * 3)
    Array(3.14, 1.42, 2.0).map { (x: Double) => x * 3 }
    println(((x: Double) => x * 3)(3))

    def valAtOnQuarter(f: (Double) => Double) = f(0.25)

    valAtOnQuarter(ceil)
    valAtOnQuarter(sqrt)
    valAtOnQuarter((x: Double) => x * 3)
    valAtOnQuarter(x => x * 3)
    valAtOnQuarter(_ * 3)

    val fun1 = 3 * (_:Double)
    val fun2: Double => Double = 3 * _


    def multiplyBy(factor: Double) = (x: Double) => factor * x

    val double = multiplyBy(2)
    val triple3 = multiplyBy(3)
    println(multiplyBy(3)(2))

    println(double(2))

    (1 to 3).map("*" * _ + " ").foreach(print(_))
    (1 to 9).filter(_ % 2 == 0).foreach(print(_))
    (1 to 9).reduceLeft(_ * _)

    val words = "Ala ma kota".split(" ")
                    .sortWith(_.length < _.length)
                    .mkString(", ")
    println(words)

    val capital: String => String =
        Map(
            "France" -> "Paris",
            "Japan" -> "Tokyo"
        )

    val population: String => Int = {
        case "Paris" => 5 * 1000
        case "Tokyo" => 15 * 1000
    }

    val h: String => Int = population compose capital
    val h2: String => Int = capital andThen population

    println(h("France"))

    def runInThread(block: => Unit): Unit = {
        new Thread() {
            override def run(): Unit = {
                block
            }
        }
        .start()
    }

    runInThread {
        println("Hello")
        Thread.sleep(100)
        println("Bye!")
    }

    def until(condition: => Boolean)(block: => Unit): Unit = {
        if(!condition) {
            block
            until(condition)(block)
        }
    }

    var x = 10

    until (x == 5) {
        x -= 1
        println(x)
    }
}