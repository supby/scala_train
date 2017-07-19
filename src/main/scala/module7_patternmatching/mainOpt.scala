package module7_patternmatching

object OptionalMain extends App {

    val scores = Map("Alice" -> 1, "Bob" -> 2)

    scores.get("Alice") match {
        case Some(score) => println(score)
        case None => println(" - ")
    }
    println(scores.getOrElse("Alice", 0))

    for (score <- scores.get("Eva")) println(score)

    def getCapital(country: String): Option[String] = {
        country match {
            case "Poland" => Some("Warsaw")
            case "Russia" => Some("Moscow")
            case "France" => Some("Paris")
            case _ => None
        }
    }

    println(getCapital("Poland").map(_.length))

    /*

    Monad[T]

    LI: f:T => R

        f(M[T]) => M[R] == f(T) => R
        m.map(f)

    RI: f:T => M[R]

        f(M[T]) => M[R] == f(T) => M[R]
        m.flatMap(f)

    Assio f:T => R & g:R => S

        g(f(M[T])) => g(M[R]) => M[S] == g(f(t)) = s
    */

    def getCapitalPF: PartialFunction[String, String] = {
        case "Poland" => "Warsaw"
        case "Russia" => "Moscow"
        case "France" => "Paris"
    }

    def getCapitalPF2: PartialFunction[String, String] = {
        case "UK" => "London"
    }

    val pfr = "-3+4-1".collect({
        case '+' => 1
        case '-' => -1
        case _ => 0
    })

    println(pfr)
}