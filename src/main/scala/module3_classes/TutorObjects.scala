package module3_classes

class TutorObjects extends App {
    object Accounts {
        private var lastNumber = 0

        def newUniqueNumber:Int = {
            lastNumber += 1
            lastNumber
        }
    }

    class Account private(val id: Int, initialBalance: Double) {
        private var balance = initialBalance
    }

    object Account {
        def apply(initialBalance: Double): Account = new Account(Accounts.newUniqueNumber, initialBalance)
    }

    val account = Account(100.0)
    val accs = List(account)

    
}


