package module5_collections

import scala.collection.mutable

object Main extends App {
    class Phonebook {
        val numbers = mutable.Map[String, String]()

        def apply(name: String): String = numbers(name)

        def update(name: String, number: String): Unit = numbers(name) = number
    }

    val book = new Phonebook

    book("Alice") = "555-555-555" // update method will be called
    println(book("Alice")) // apply method will be called

    class Person(val name: String, var age: Int)
    object Person {
        def apply(name: String, age: Int): Person = 
            new Person(name, age)

        def update(p: Person, age: Int): Unit = p.age = age

        def unapply(arg: Person): Option[(String, Int)] = {
            if(!arg.name.isEmpty)
                Some((arg.name, arg.age))
            else
                None
        }
    }

    val alice = Person("Alice", 24)
    Person(alice) = 25

    val maybeTuple = Person.unapply(alice)
    println(maybeTuple)

    // unapply is used. It match by tuple (name, age)
    alice match {
        case Person("Alice", 24) => println("Nice")
        case Person("Alice", 25) => println("Nice too")
    }
}