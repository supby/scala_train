package module2_arrays

import scala.collection.mutable._

object TutorTransform extends App {
    val a = Array(2, 3, 5, 7, 11)

    val b = Array[Int]()
    a.filter(_ % 2 == 0).map(2 * _).foreach(i => println(i))

    val arrOf5 = Array.ofDim[Double](5, 5)

    arrOf5(2)(3)

    val mutableArray = new ArrayBuffer[Int]

    
}