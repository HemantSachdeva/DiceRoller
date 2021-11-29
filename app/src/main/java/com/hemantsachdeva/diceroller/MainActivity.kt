package com.hemantsachdeva.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/*
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /*
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Show a random dice view when user opens the app
        rollDice()

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /*
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)

        // Find the ImageView in the layout
        val leftDiceImage: ImageView = findViewById(R.id.leftDice)
        val rightDiceImage: ImageView = findViewById(R.id.rightDice)

        // Determine which drawable resource ID to use based on the dice roll
        var pass: Int = 1

        // Update dices one by one to get different number on each
        repeat(2) {
            val drawableResource = when (dice.roll()) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            // Update the ImageView with the correct drawable resource ID
            if (pass == 1) {
                leftDiceImage.setImageResource(drawableResource)
            } else {
                rightDiceImage.setImageResource(drawableResource)
            }
            pass += 1
        }
    }
}

/*
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /*
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
