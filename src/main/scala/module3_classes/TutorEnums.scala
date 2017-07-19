package module3_classes

object TutorEnums extends App {
    object TrafficLightColor extends Enumeration {
        type TrafficLightColor = Value
        val Red, Yellow, Green = Value
    }

    import TrafficLightColor._

    def action(c: TrafficLightColor): String = {
        if(c == TrafficLightColor.Red) "Stop"
        else if (c == TrafficLightColor.Yellow) "hurry up"
        else if (c == TrafficLightColor.Green) "GO"
        else ""
    }

    println(action(TrafficLightColor.Red))
    println(action(TrafficLightColor.Yellow))
    println(action(TrafficLightColor.Green))
}
