package tictactoe

import kotlin.math.absoluteValue
import java.util.Scanner


fun main() {
    val scan = Scanner(System.`in`)
    var gridd = Array(3){Array(3){' '} }

    fun printgrid(){
        val line = "---------"
        println(line)
        for(i in 0 until 3){
            print("| ")
            for(j in 0 until 3){
                print("${gridd[i][j]} ")
            }
            println("|")
        }
        println(line)
    }

    var end = 0

    fun isWins(): Int{
        var a = gridd[0][0].toString()+ gridd[0][1].toString()+gridd[0][2].toString()
        var b = gridd[1][0].toString()+ gridd[1][1].toString()+gridd[1][2].toString()
        var c = gridd[2][0].toString()+ gridd[2][1].toString()+gridd[2][2].toString()
        var d = a.substring(0,1)+b.substring(0,1)+ c.substring(0,1)
        var e = a.substring(1,2)+b.substring(1,2)+ c.substring(1,2)
        var f = a.substring(2)+b.substring(2)+ c.substring(2)
        var k = a.substring(0,1)+b.substring(1,2)+ c.substring(2)
        var m = a.substring(2)+ b.substring(1,2)+ c.substring(0,1)
        val conx = "XXX"
        val cono = "OOO"
        if (a==conx || b==conx || c==conx || d==conx || e==conx || f==conx || k==conx || m==conx){
            println("X wins")
            return 1
        }
        else if (a==cono || b==cono || c==cono || d==cono || e==cono || f==cono || k==cono || m==cono){
            println("O wins")
            return 1
        }
        else return 0

    }


    fun move(){
        var letter1 = 'X'
        var letter2 = 'O'

        while (true) {
            var move1 = scan.next()
            var move2 = scan.next()
            if (move1.first().isLetter() || move2.first().isLetter()) {
                println("You schould enter numbers!")
            } else if (move1.toInt() < 1 || move1.toInt() > 3 || move2.toInt() < 1 || move2.toInt() > 3) {
                println("Coordinates schould be from 1 to 3!")
            } else if (gridd[move1.toInt()-1][move2.toInt()-1] != ' ') println("This cell is occupied! Choose another one!")
            else {
                gridd[move1.toInt()-1][move2.toInt()-1] = letter1
                printgrid()
                letter1 = letter2.also { letter2 = letter1 }
            }
            if (isWins() == 1) break


        }
    }
    printgrid()
    move()

}
