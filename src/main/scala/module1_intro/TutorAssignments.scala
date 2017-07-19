object TutorAssignments extends App {
    class Holder {
        println("Holder")
    }

    val a = 1

    def minMax(x: Int, y: Int): (Int, Int, Boolean) = if (x < y) (x, y, true) else (y, x, false)

    val (min, max, b) = minMax(5, 10)
    val mm = minMax(5, 10)

    var i = 10 + Int.MaxValue

    
}