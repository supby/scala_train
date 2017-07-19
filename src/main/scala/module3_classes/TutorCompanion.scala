package module3_classes

class TutorCompanion {
    private var b:Int = 0

    def apply(a:Int): TutorCompanion = {
        val obj = new TutorCompanion()
        obj.b = this.b + a
        obj
    }
}

object TutorCompanion {
    def setB(t: TutorCompanion, b: Int):Unit = if (b > 0) t.b = b // have access to private stuff
}