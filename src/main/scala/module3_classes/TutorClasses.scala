package module3_classes

object TutorClasses extends App {
    class First

    class Second {
        println("Hello")
    }

    val second = new Second

    class Third(_a:Int) {
        val a = _a
        var b = _a
    }

    val third = new Third(2)

    class Forth(var a: Int, var b: Int = 1) {
        override def toString: String = a + ":" + b
    }

    val forth = new Forth(1,2)

    println(forth)

    class Person {
        private var name = ""
        private var age = 0

        def this(name:String) {
            this()
            this.name = name
        }

        def this(name:String, age:Int) {
            this(name)
            this.age = age
        }

        def apply(name: String, age: Int): Person = new Person(name, age)
    }

    val p1 = new Person("Andre", 34)
    p1("eeeee", 88) // aplpy
    p1("dedd", 99)("ddddd", 55)

    class Counter {
        private var value:Int = 0

        def ++():Unit = {
            value = value + 1
        }

        def current = value
    }

    val counter = new Counter

    counter.++
    counter ++

    println(counter.current)

    // getter, setter
    class Baby {
        private var _name = ""

        def name = _name
        def name_= (newVal:String):Unit = {
            _name = newVal
        }
    }

    val mati = new Baby
    mati.name = "Mati"

    class BikeCounter {
        private[this] var _km = 0 // private even for instance
        private var km = 0 // private even for instance

        def inc() = km += 1

        //def <=(other: BikeCounter): Boolean = km <= other._km // Erorr: it uses private for instance _km var
        def <=(other: BikeCounter): Boolean = km <= other.km
    }

    class Network {
        import scala.collection.mutable._

        private val members = new ArrayBuffer[Member]
        private val outerMembers = new ArrayBuffer[Network#Member]
        
        def join(name:String) = {
            val m = new Member(name)
            members += m
            m
        }

        def join(m:Member) = {
            members += m
            m
        }

        //private val members = new ArrayBuffer[Network#Member]

        def joinOutside(m:Network#Member) = {
            outerMembers += m
            m
        }

        class Member(name:String)
    }

    val cosaNostra = new Network
    val facebook = new Network

    val mark = cosaNostra.join("Mark")
    //facebook.join(mark) // Error. cosaNostra.Member != facebok.Member
    facebook.joinOutside(mark) // use Network#Member to allow use Member class from different instances



}