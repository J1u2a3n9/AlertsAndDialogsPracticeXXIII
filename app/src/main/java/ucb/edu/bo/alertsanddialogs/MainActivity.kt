package ucb.edu.bo.alertsanddialogs

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnAlert0= findViewById<View>(R.id.btn_0)
        var btnAlertI = findViewById<View>(R.id.btn_I)
        var btnAlertII=findViewById<View>(R.id.btn_II)
        var btnAlertIII = findViewById<View>(R.id.btn_III)
        var btnAlertIV=findViewById<View>(R.id.btn_IV)
        var btnAlertV = findViewById<View>(R.id.btn_V)
        var btnAlertVI=findViewById<View>(R.id.btn_VI)
        var btnAlertVII = findViewById<View>(R.id.btn_VII)

        /*Btn0*/
        btnAlert0.setOnClickListener {
            val builder = AlertDialog.Builder(it.context) // Builder needs a context
            builder.setTitle("Android Alert")
            builder.setMessage("We have a message")
            builder.show()


        }

        /*BtnI*/
        btnAlertI.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Android Alert")
            builder.setMessage("We have a message")

            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(it.context, "Okey", Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("No okey") {
                    dialog, i ->
                Toast.makeText(it.context, "No Okey", Toast.LENGTH_LONG).show()
            }

            builder.setNeutralButton("Maybe", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(it.context, "Maybe", Toast.LENGTH_LONG).show()
            })
            builder.show()
        }
        /*Btn II*/
        btnAlertII.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Android Alert")
            builder.setMessage("We have a message")

            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(it.context, "Okey", Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("No okey",  null)

            builder.setNeutralButton("Maybe", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(it.context, "Maybe", Toast.LENGTH_LONG).show()
            })
            builder.show()


        }
        /*Btn III*/
        btnAlertIII.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            with(builder) {
                setTitle("Icon and Button Color")
                setMessage("We have a message")
                setPositiveButton("OK", null)
                setNegativeButton("CANCEL", null)
                setNeutralButton("NEUTRAL", null)
            }
            val alertDialog = builder.create()
            alertDialog.show()

            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            with(button) {
                setBackgroundColor(Color.BLACK)
                setPadding(0, 0, 20, 0)
                setTextColor(Color.WHITE)
            }
        }
        /*Btn IV*/
        btnAlertIV.setOnClickListener {
            val items = arrayOf("Red", "Orange", "Yellow", "Blue")
            val builder = AlertDialog.Builder(it.context)
            with(builder) {
                setTitle("List of Items")
                setItems(items)
                {
                        dialogInterface, i ->
                    Toast.makeText(it.context, items[i] + " is clicked", Toast.LENGTH_LONG).show()
                }
                show()
            }
        }

        /*Btn V*/
        btnAlertV.setOnClickListener {
            val items = arrayOf("Microsoft", "Apple", "Amazon", "Google")
            val selectedList = ArrayList<Int>()
            val builder = AlertDialog.Builder(it.context)

            builder.setTitle("This is list choice dialog box")
            builder.setMultiChoiceItems(items, null
            ) { dialog, which, isChecked ->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(Integer.valueOf(which))
                }
            }

            builder.setPositiveButton("DONE") { dialogInterface, i ->
                val selectedStrings = ArrayList<String>()

                for (j in selectedList.indices) {
                    selectedStrings.add(items[selectedList[j]])
                }

                Toast.makeText(it.context, "Items selected are: " + Arrays.toString(selectedStrings.toTypedArray()), Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }
        /*Btn VI*/
        btnAlertVI.setOnClickListener {
            val builder = AlertDialog.Builder(ContextThemeWrapper(it.context, android.R.style.Holo_SegmentedButton))

            with(builder)
            {
                setTitle("Androidly Alert")
                setMessage("We have a message")
                setPositiveButton("OK", null)
                setNegativeButton(android.R.string.no, null)
                setNeutralButton("Maybe", null)
                show()
            }
        }

        /*Btn VII*/
        btnAlertVII.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            val inflater = layoutInflater
            builder.setTitle("With EditText")
            val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
            val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") { dialogInterface, i -> Toast.makeText(it.context, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show() }
            builder.show()
        }
    }




}
