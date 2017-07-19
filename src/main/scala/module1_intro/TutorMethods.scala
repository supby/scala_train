//package module1_intro

object TutorMethods extends App {
    
    // Java-style
    def f0(x:Int, y:Int):Int = {
        return x*x+y*y;
    }

    def f1(x:Int, y:Int):Int = {
        return x*x+y*y
    }

    def f2(x:Int, y:Int):Int = {
        x*x+y*y
    }

    def f3(x:Int, y:Int):Int = x*x+y*y

    def f4(x:Int, y:Int):Unit = x*x+y*y

    def f5(x:Int, y:Int) = {
        def sqr(x:Int) = x*x
        sqr(x) + sqr(y)
    }
}