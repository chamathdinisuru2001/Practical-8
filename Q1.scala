object CaeserCipher{
    def encrypt(text:String,shift:Int):String={
        text.map{char =>
        if(char.isLetter){
            val base = if(char.isUpper) 'A' else 'a'
            ((char-base+shift) % 26 + base).toChar
        }else{
            char
        }
        }
    }

    def decrypt(text:String, shift:Int): String ={
        text.map{char=>
        if(char.isLetter){
            val base = if(char.isUpper) 'A' else 'a'
            ((char-base-shift+26) % 26 +base).toChar
        }else{
            char
        }
        }
    }

    def ciper(text: String, shift: Int, mode: String): String ={
        mode.toLowerCase match{
            case "encrypt" => encrypt(text,shift)
            case "decrypt" => decrypt(text,shift)
            case _ => throw new IllegalArgumentException("Mode should be either 'encrypt' or 'decrypt' ")
        }
    }

    def main(args:Array[String]):Unit ={
        val text = "UCSC"
        val shift = 3
        
        println(s"Text: $text")
        val encrypted = ciper(text,shift,"encrypt")
        println(s"Encrypted: $encrypted")

        val decrypted= ciper(encrypted,shift,"decrypt")
        println(s"Decrypted: $decrypted")
    }
}