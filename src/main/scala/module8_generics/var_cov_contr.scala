package module8_generics

object VarCovContrmain extends App {
    class Person(val name: String) {
        var friend: Person = null
    }

    class Child(m: String) extends Person(m)

    class Pair[T](val f: T, val s: T)
    class CoPair[+T](val f: T, val s: T)

    def makeFriends(p: Pair[Person]): Unit = {
        p.f.friend = p.s
        p.s.friend = p.f
    }

    val jas = new Child("Jas")
    val malgosia = new Child("Malgosia")

    val p = new Pair[Person](jas, malgosia)
    makeFriends(p)

    /*

    A -> B

    variance
        M[A] !-> M[B]

    invariance
        M[A] -> M[B]

    covariance
        M[B] <- A

    */


}
