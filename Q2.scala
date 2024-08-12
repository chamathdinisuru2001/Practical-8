object patternMatching{
    def main(args: Array[String]):Unit ={
        if(args.length != 1){
            println("Please enter a one integer")
        }else{
            try{
                val number = args(0).toInt

                val classify: Int => String = (n:Int) => n match{
                    case x if x % 3 == 0 && x % 5 == 0 => "Multiple of both 3 and 5"
                    case x if x % 3 == 0 => "Multiple of 3"
                    case x if x % 5 == 0 => "Multiple of 5"
                    case _ => "Not a multiple of 3 or 5"
                }
                println(classify(number))
            }catch{
                case _: NumberFormatException => println("Invalid input !!!")
            }
        }
    }
}