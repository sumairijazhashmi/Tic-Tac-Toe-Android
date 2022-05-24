//     Copyright (C) 2022  Sumair Ijaz Hashmi - LUMS roll number: 24100004

//     This program is free software: you can redistribute it and/or modify
//     it under the terms of the GNU General Public License as published by
//     the Free Software Foundation, either version 3 of the License, or
//     (at your option) any later version.

//     This program is distributed in the hope that it will be useful,
//     but WITHOUT ANY WARRANTY; without even the implied warranty of
//     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//     GNU General Public License for more details.

//     You should have received a copy of the GNU General Public License
//     along with this program.  If not, see <https://www.gnu.org/licenses/>.

package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var tile1: ImageView? = null
    private var tile2: ImageView? = null
    private var tile3: ImageView? = null
    private var tile4: ImageView? = null
    private var tile5: ImageView? = null
    private var tile6: ImageView? = null
    private var tile7: ImageView? = null
    private var tile8: ImageView? = null
    private var tile9: ImageView? = null
    private var num = 1 // odd = "o" = player 1, even = "x" = player 2
    private var restartButton: Button? = null

    private var tiles = arrayOf("0", "0", "0", "0", "0", "0", "0", "0", "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        restartButton = findViewById(R.id.button)
        tile1 = findViewById(R.id.tile1)
        tile2 = findViewById(R.id.tile2)
        tile3 = findViewById(R.id.tile3)
        tile4 = findViewById(R.id.tile4)
        tile5 = findViewById(R.id.tile5)
        tile6 = findViewById(R.id.tile6)
        tile7 = findViewById(R.id.tile7)
        tile8 = findViewById(R.id.tile8)
        tile9 = findViewById(R.id.tile9)

        // for each tile set a listener to check if its clicked
        tile1!!.setOnClickListener() {
            setImage(tile1!!, num, 0)
            num++
        }

        tile2!!.setOnClickListener() {
            setImage(tile2!!, num, 1)
            num++
        }

        tile3!!.setOnClickListener() {
            setImage(tile3!!, num, 2)
            num++
        }

        tile4!!.setOnClickListener() {
            setImage(tile4!!, num, 3)
            num++
        }

        tile5!!.setOnClickListener() {
            setImage(tile5!!, num, 4)
            num++
        }

        tile6!!.setOnClickListener() {
            setImage(tile6!!, num, 5)
            num++
        }

        tile7!!.setOnClickListener() {
            setImage(tile7!!, num, 6)
            num++
        }

        tile8!!.setOnClickListener() {
            setImage(tile8!!, num, 7)
            num++
        }

        tile9!!.setOnClickListener() {
            setImage(tile9!!, num, 8)
            num++
        }

        // restart button click listener
        restartButton!!.setOnClickListener() {
            restartGame()
        }
    }

    private fun restartGame() {
        recreate()
    }

    private fun setImage(image: ImageView, num: Int, tilenum: Int) {
        // set image to x or o depending on whos turn is it
        // check whether either player wins or its a draw after each turn
        if (num % 2 == 0) {
            image.setImageResource(R.drawable.x)
            tiles[tilenum] = "x"
            checkDrawAndWin(num)
        } else {
            image.setImageResource(R.drawable.o)
            tiles[tilenum] = "o"
            checkDrawAndWin(num)
        }
        // set that tile's listener to null so that it cant be changed afterwards
        image.setOnClickListener(null)
    }

    private fun checkDrawAndWin(num: Int) {
        var hasWon = checkWin(num)
        // draw is checked only after win is checked
        if (!hasWon) {
            checkDraw(num)
        }
    }

    private fun checkDraw(num: Int) {
        var text: TextView = findViewById(R.id.textView)
        var drawText = getString(R.string.draw)
        // if all tiles have been used then its a draw
        if (num == 9) {
            text.setText(drawText)
            stopGame()
        }
    }

    private fun checkWin(num: Int): Boolean {
        // player wins if they are in any one of the winning positions
        if (num % 2 == 0) {
            if (tiles[0] == "x" && tiles[1] == "x" && tiles[2] == "x") { //|| () || () || () || () || () || () || ()) {
                player2win()
                var winLine: ImageView = findViewById(R.id.row1)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
            else if (tiles[0] == "x" && tiles[3] == "x" && tiles[6] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.column1)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[0] == "x" && tiles[4] == "x" && tiles[8] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.mainDiagonal)
                winLine.setImageResource(R.drawable.maindiagonal)
                stopGame()
                return true
            }
            else if (tiles[1] == "x" && tiles[4] == "x" && tiles[7] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.column2)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[2] == "x" && tiles[4] == "x" && tiles[6] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.offDiagonal)
                winLine.setImageResource(R.drawable.offdiagonal)
                stopGame()
                return true
            }
            else if (tiles[2] == "x" && tiles[5] == "x" && tiles[8] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.column3)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[3] == "x" && tiles[4] == "x" && tiles[5] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.row2)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
            else if (tiles[6] == "x" && tiles[7] == "x" && tiles[8] == "x") {
                player2win()
                var winLine: ImageView = findViewById(R.id.row3)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
        } else {
            if (tiles[0] == "o" && tiles[1] == "o" && tiles[2] == "o") { //|| () || () || () || () || () || () || ()) {
                player1win()
                var winLine: ImageView = findViewById(R.id.row1)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
            else if (tiles[0] == "o" && tiles[3] == "o" && tiles[6] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.column1)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[0] == "o" && tiles[4] == "o" && tiles[8] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.mainDiagonal)
                winLine.setImageResource(R.drawable.maindiagonal)
                stopGame()
                return true
            }
            else if (tiles[1] == "o" && tiles[4] == "o" && tiles[7] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.column2)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[2] == "o" && tiles[4] == "o" && tiles[6] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.offDiagonal)
                winLine.setImageResource(R.drawable.offdiagonal)
                stopGame()
                return true
            }
            else if (tiles[2] == "o" && tiles[5] == "o" && tiles[8] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.column3)
                winLine.setImageResource(R.drawable.veritcal)
                stopGame()
                return true
            }
            else if (tiles[3] == "o" && tiles[4] == "o" && tiles[5] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.row2)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
            else if (tiles[6] == "o" && tiles[7] == "o" && tiles[8] == "o") {
                player1win()
                var winLine: ImageView = findViewById(R.id.row3)
                winLine.setImageResource(R.drawable.horizontal)
                stopGame()
                return true
            }
        }
        return false
    }

    private fun player2win() {
        var text: TextView = findViewById(R.id.textView)
        var p2_wins = getString(R.string.win_2)
        text.setText(p2_wins)
    }

    private fun player1win() {
        var text: TextView = findViewById(R.id.textView)
        var p1_wins = getString(R.string.win_1)
        text.setText(p1_wins)
    }

    private fun stopGame() {
        tile1?.setOnClickListener(null)
        tile2?.setOnClickListener(null)
        tile3?.setOnClickListener(null)
        tile4?.setOnClickListener(null)
        tile5?.setOnClickListener(null)
        tile6?.setOnClickListener(null)
        tile7?.setOnClickListener(null)
        tile8?.setOnClickListener(null)
        tile9?.setOnClickListener(null)
    }
}
