package module8_generics

object GenericsMain extends App {

    class Pair[T, S](val f: T, val s: S) {
        def replaceFirst[R >: T](newFirst:R) = new Pair[R, S](newFirst, s)
    }

    val pair = new Pair[Any, Any](42, "String")

    def getMiddle[T](arr: Array[T]) = arr(arr.length /2)

    getMiddle(Array(1, 2, 3, 4))

    val f = getMiddle[String] _
    f(Array("1", "2", "3"))

    class CPair2[T <: Comparable[T]](val f:T, val s:T)

    new CPair2("1", "2")

    //new CPair2(new CPair2(1,2), new CPair2(1,2)) // should inherit Comparable

    class Person(val name: String)

    class Employee(_n: String) extends Person(_n)

    val smith = new Employee("Smith")
    val johnson = new Person("Johnson")
    val p = new Pair(smith, "Director")
    val pp = p.replaceFirst(johnson) // R >: T, smith(T) should be subtype of jhonson(R) (should inherit it)

    class Person2(val name: String)
    class Employee2(_n: String, val salary:Int) extends Person2(_n)
        with Comparable[Employee2] {
            override def compareTo(o: Employee2): Int = {
                salary.compareTo(o.salary)
            }
        }

    class EPair[T <: Comparable[T]](val f: T, val s: T) { //  <% - depricated 
        def smaller = if (f.compareTo(s) < 0) f else s
    }

    val smith2 = new Employee2("Smith", 1000)
    val alice2 = new Employee2("Alice", 11000)
    val johnson2 = new Person2("Johnson")

    val ep = new EPair(smith2, alice2)
    //val ep2 = new EPair(smith2, johnson2) // Person should inherit Comparable[Person2]





    
}