package module4_traits

object TutorTraits extends App {

    trait Logger {
        var prefix = ""
        def log(msg:String): Unit = println(msg)
    }

    trait ConsoleLogger extends Logger {
        override def log(msg: String): Unit = println(msg)
    }

    trait FileLogger extends Logger {
        override def log(msg: String): Unit = println(s"Write to file")
    }

    class Account(var balance:Double = 0.0)

    object Account extends Logger {
        prefix = "Acc"

        def canWithdraw(a: Account): Boolean = {
            log(s"${prefix} It can? ${a.balance > 0}")
            a.balance > 0
        }
    }

    class SavingAccount(b:Double) extends Account(b) with Logger {
        prefix = "SA"
    }

    // wrong inheritance. Extends can be class or trait but With can be only trait
    // class SavingAccountWrong(b:Double) extends Logger with Account(b) {
    // }

    class OperAccount(b:Double = 0.0) extends Account(b)

    // last implementation of logger will be used
    var oper = new OperAccount(6) with FileLogger with ConsoleLogger // .log from ConsoleLogger will be used 
    var oper2 = new OperAccount with ConsoleLogger with FileLogger // .log from FileLogger will be used

    oper.log("msg")
    oper2.log("msg")

    println(Account.canWithdraw(oper))

    abstract class AbsIter(throwing:Boolean) {
        type T

        def hasNext: Boolean

        def next: T
    }

    trait WhileIter extends AbsIter {
        def forEach(f: T => Unit): Unit = {
            while(hasNext) f(next)
        }
    }

    class StringIterator(s: String) extends AbsIter(true) {
        override type T = Char

        private var i = 0

        override def hasNext: Boolean = i < s.length

        override def next: Char = {
            val ch = s.charAt(i)
            i += 1
            ch
        }
    }

    //--------------

    trait L {
        println("L")

        def log(msg: String)
    }

    class A {
        println("A")
    }

    trait FL extends L {
        println("FL")
    }
    trait SL {
        println("SL")
    }

    class SA extends A with FL with SL {
        println("SA")

        def log(msg:String):Unit = {
            
        }
    }

    val sa  = new SA

    // trait canbe inherited with class which has getId() method
    trait IdL extends L {
        this: { def getId():Int } =>
        def log(): Unit = log(getId.toString)
    }

    class Entity {
        def getId = 1
    }

    //val ent = new Entity() with IdL
}