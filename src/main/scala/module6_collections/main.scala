package module6_collections

import scala.collection.immutable
import scala.collection.{SortedSet, mutable}
import scala.collection.mutable.ArrayBuffer
import scala.math._

object Main extends App {

    Iterable(0xFF, 0xFF00, 0xFF0000)
    Set(1,3,2,3,4)
    Map(1 -> 0xFF, 2 -> 0xF00)
    SortedSet("Hello", "World")

    var ints = immutable.Set(1, 2, 3, 4)
    ints += 5 // new set
    ints = ints + 6 // new set

    val numbers = ArrayBuffer(1,2,3)
    numbers += 5

    val mints = mutable.Set(1, 2, 3)
    mints += 5
    mints -= 2
    mints += (4, 6)
    println(mints)
    mints -= (4, 6)

    println(mints)

    numbers ++= mints
    println(numbers)
    numbers --= mints

    val vec = Vector(1, 2, 3)

    def up(v:Vector[Int]) = v.updated(1, 9)

    val vector = up(vec)
    println(vec)
    println(vector)

    val buffered = Vector(numbers)
    println(numbers.toIndexedSeq)

    val vec2 = vec :+ 10 :+ 20
    println(vec2)

    val vec3 = 30 +: vec2
    val vec4 = 4 +: Seq(1,2,3)
    val vec5 = vec2 ++ vec4
    println(vec5)

    val digits = List(4, 2)
    val list2 = 9 :: digits
    val list3 = 9 :: digits :: 2 :: Nil

    println(list2)
    println(list3)

    val list4 = 9 :: digits ::: 2 :: Nil
    println(list4)

    def sum(l: List[Int]): Int = l match {
        case Nil => 0
        case h::t => h + sum(t)
    }

    println(sum(digits))

    var seq = Seq(1,2,3,4,5)

    println(seq.reduceLeft(_ + _))
    println(seq.reduceRight(_ - _)) // 1 - (2 - (3 - (4 - 5)))
    println(seq.reduceLeft(_ - _)) // (((1-2)-3)-4)-5

    println(seq.foldLeft(2)(_+_))
    println(seq.foldLeft(".")(_+_))
    println(seq.foldRight(".")(_+_))

    println(seq.partition(_ % 2 == 0))
    println(seq.span(_ < 3))

    println(seq.permutations.mkString(","))
    println(seq.combinations(2).mkString(","))


    def numsFrom(n: Int): Stream[Int] = n #:: numsFrom(n + 1)

    val tenOrMode = numsFrom(10)

    println(tenOrMode.tail)
    println(tenOrMode.tail.tail(0))
    println(tenOrMode.tail.tail(3))
    println(tenOrMode.take(5).force)

    val powers = (0 to 1000).view.map(pow(10, _))
    println(powers(3))

}