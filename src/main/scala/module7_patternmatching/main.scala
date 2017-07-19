package module7_patternmatching

object Main extends App {
    var sign = 0

    val ch:Char = '+'

    sign = ch match {
        case '+' => 1
        case '-' => -1
        case _ => 0
    }

    sign = ch match {
        case '+' => 1
        case '-' => -1
        case _ if Character.isDigit(ch) => Character.digit(ch, 0)
        case _ => 0
    }

    val obj:Any = "15"

    val res = obj match {
        case x:Int => x
        case s:String => {
            println("I'm here")
            Integer.parseInt(s)
        }
        case _: BigInt => Int.MaxValue
        case _ => 0
    }

    val arr = Array(1,2)

    val res2 = arr match {
        case Array(0) => "0"
        case Array(x, y) => s"${x} + ${y}"
        case Array(0, _*) => "0 ..."
        case _ => "Nothing to do here"
    }

    println(res2)

    var lst = List(1, 2, 3)

    val res3 = lst match {
        case 3 :: Nil => "0"
        case x :: y :: z :: Nil => s"${x + y}"
        case 0 :: tail => "0 ..."
        case _ => "NTD"
    }

    println(res3)

    
    //--------------

    sealed trait Amount
    sealed abstract class Employee

    case class Developer(name:String) extends Employee
    case class Manager(name:String, unit:Developer*) extends Employee

    

}