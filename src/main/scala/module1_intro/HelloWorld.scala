//package module1_intro

class HelloWorld {
    def name(): String = {
        "Luxoft"
    }
}

object HelloWorld {
    def main(args: Array[String]): Unit = {
        println("Hello World" + new HelloWorld().name())
    }
}