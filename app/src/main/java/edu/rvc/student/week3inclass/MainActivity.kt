package edu.rvc.student.week3inclass

//import android.content.Context
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNum1 = findViewById<EditText>(R.id.txtNum1)
        var txtNum2 = findViewById<EditText>(R.id.txtNum2)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtShow = findViewById<TextView>(R.id.txtVIew)


        //button click
        btnSubmit.setOnClickListener {
            // your code to perform when the user clicks on the button
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            val showcalc: Int = calculate(n1, n2)
            txtShow.text = "The sum is ${showcalc}"
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }

    //Math fun
    fun calculate(a: Int, b: Int): Int {
        return a + b
    }

    // function to hide keyboard
    //import android.content.Context
    //import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
