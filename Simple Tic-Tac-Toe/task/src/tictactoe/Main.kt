package tictactoe
fun String.isDigitsOnly() = all(Char::isDigit) && isNotEmpty()
fun main() {

    var ch = MutableList(3) { MutableList(3) { " " } }

    var x = "X"
    var o = "O"
    var z = 9
    var xNum = 0
    var oNum = 0
    var stop = true
    while (stop) {
        println("""
        ---------
        | ${ch[0].joinToString(" ")} |
        | ${ch[1].joinToString(" ")} |
        | ${ch[2].joinToString(" ")} |
        ---------""".trimIndent())

        if (ch[0][0] == o && ch[0][1] == o && ch[0][2] == o ||
            ch[1][0] == o && ch[1][1] == o && ch[1][2] == o ||
            ch[2][0] == o && ch[2][1] == o && ch[2][2] == o ||
            ch[0][2] == o && ch[1][1] == o && ch[2][0] == o ||
            ch[0][0] == o && ch[1][1] == o && ch[2][2] == o ||
            ch[0][0] == o && ch[1][0] == o && ch[2][0] == o ||
            ch[0][1] == o && ch[1][1] == o && ch[2][1] == o ||
            ch[0][2] == o && ch[1][2] == o && ch[2][2] == o) o = "t"

        if (ch[0][0] == x && ch[0][1] == x && ch[0][2] == x ||
            ch[1][0] == x && ch[1][1] == x && ch[1][2] == x ||
            ch[2][0] == x && ch[2][1] == x && ch[2][2] == x ||
            ch[0][2] == x && ch[1][1] == x && ch[2][0] == x ||
            ch[0][0] == x && ch[1][1] == x && ch[2][2] == x ||
            ch[0][0] == x && ch[1][0] == x && ch[2][0] == x ||
            ch[0][1] == x && ch[1][1] == x && ch[2][1] == x ||
            ch[0][2] == x && ch[1][2] == x && ch[2][2] == x) x = "t"

        if (z == 0 && o != "t" && x != "t") {
            println("Draw")
            break
        }
        else if (x == "t") {
            println("X wins")
            break
        }
        else if (o == "t") {
            println("O wins")
            break
        }
        println(">")
        val inp = readln().split(" ")
        val one = inp[0]
        val two = inp[1]
        if (!inp[0].isDigitsOnly() && !inp[1].isDigitsOnly()) {
            println("You should enter numbers!")
        } else if ((one.toInt() == 0 || one.toInt() in 4..9) ||
            (two.toInt() == 0 || two.toInt() in 4..9)) {
            println("Coordinates should be from 1 to 3!")
        } else if (ch[one.toInt() - 1][two.toInt() - 1] != " ") {
            println("This cell is occupied! Choose another one!")
        } else if (ch[one.toInt() - 1][two.toInt() - 1] == " " && xNum == oNum) {
            ch[one.toInt() - 1].add(two.toInt() - 1, "X")
            ch[one.toInt() - 1].removeAt(two.toInt())
            xNum++
            z--
        } else if (ch[one.toInt() - 1][two.toInt() - 1] == " " && xNum > oNum) {
            ch[one.toInt() - 1].add(two.toInt() - 1, "O")
            ch[one.toInt() - 1].removeAt(two.toInt())
            oNum++
            z--
        }
    }
}

