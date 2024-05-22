package com.example.learing_phase.ui.theme

import android.icu.util.Output
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.io.DataInput

class UnitConverter : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learing_phaseTheme {
            }
        }
    }
}

@Composable
fun UnitConverterUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        var input by remember { mutableStateOf("") }
        var output by remember { mutableStateOf("") }
        var inputunit by remember { mutableStateOf("Meter") }
        var outputunit by remember { mutableStateOf("Centimeter") }
        var iExpand by remember { mutableStateOf(false) }
        var oExpand by remember { mutableStateOf(false) }
        val conversionFactor = remember { mutableStateOf(0.01) }
        val OutputValue = remember { mutableStateOf("") }

        //        fun ConversionFactorfun( inputunit:String ,outputunit:String ){
//            if(inputunit.equals(outputunit)){
//                conversionFactor.value = 1.0
//            }
//            else if(inputunit.equals("Meter") and outputunit.equals("Centimeter")){
//                conversionFactor.value = 100.0
//            }
//            else if(inputunit.equals("Meter") and outputunit.equals("Millimeter")){
//                conversionFactor.value = 1000.0
//            }
//            else if(inputunit.equals("Meter") and outputunit.equals("Feet")){
//                conversionFactor.value = 3.28084
//            }
//            else if(inputunit.equals("Centimeter") and outputunit.equals("meter")){
//                conversionFactor.value = 0.01
//            }
//        }
        /*Generic Code Below*/
        fun ConversionFactorfun(inputUnit: String, outputUnit: String): Double {
            val conversionFactors = mapOf(
                Pair("Meter", "Centimeter") to 100.0,
                Pair("Meter", "Millimeter") to 1000.0,
                Pair("Meter", "Feet") to 3.28084,
                Pair("Centimeter", "Meter") to 0.01,
                Pair("Centimeter", "Millimeter") to 10.0,
                Pair("Centimeter", "Feet") to 0.0328084,
                Pair("Millimeter", "Meter") to 0.001,
                Pair("Millimeter", "Centimeter") to 0.1,
                Pair("Millimeter", "Feet") to 0.00328084,
                Pair("Feet", "Meter") to 0.3048,
                Pair("Feet", "Centimeter") to 30.48,
                Pair("Feet", "Millimeter") to 304.8
                // Add more conversions as needed
            )

            return if (inputUnit == outputUnit) {
                1.0
            } else {
                conversionFactors[Pair(inputUnit, outputUnit)]
                    ?: throw IllegalArgumentException("Conversion not supported")
            }
        }

        fun UnitConvert(inputvalue: String, conversionFactor: Double): String {
            var value = inputvalue.toDoubleOrNull() ?: 0.0
            value = value * conversionFactor
            return value.toString()
        }



        Text(
            text = "Unit Converter App",
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        var typedText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = input,
            onValueChange = {
                //shows what happens on value change
                input = it
            }  //shows nothing on value change
            ,
            label = {
                Text(text = "Enter the Input Value")
            },
            placeholder = {
                Text(text = "Enter input")
            },
            textStyle = TextStyle(color = Color.Black)

        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row {

//            val context = LocalContext.current //used for toast

//            Button(onClick = {
//                Toast.makeText(
//                    context,//
//                    "thanks for clicking",//
//                    Toast.LENGTH_LONG //
//                ).show() //method call to show the toast


//            }
//            ) {
//                Text(text = "Submit")
//            }

            Box {
                Button(onClick = {
                    /*TODO*/
                    iExpand = true
                }) {

                    Text(text = inputunit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null
                    ) //Import the default icon pakc and then fetch the icons
                }
                DropdownMenu(expanded = iExpand, onDismissRequest = {
                    /*TODO*/
                    iExpand = false

                }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = {
                            /*TODO*/
                            inputunit = "Centimeter"
                            iExpand = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meter") },
                        onClick = {
                            /*TODO*/
                            inputunit = "Meter"
                            iExpand = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            /*TODO*/
                            inputunit = "Feet"
                            iExpand = false

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeter") },
                        onClick = {
                            /*TODO*/
                            inputunit = "Millimeter"
                            iExpand = false
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box {
                Button(onClick = {
                    /*TODO*/
                    oExpand = true
                }) {
                    Text(
                        text = outputunit
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
                DropdownMenu(expanded = oExpand, onDismissRequest = {
                    /*TODO*/
                    oExpand = false
                }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = { /*TODO*/
                            outputunit = "Centimeter"
                            oExpand = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meter") },
                        onClick = {
                            /*TODO*/
                            outputunit = "Meter"
                            oExpand = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = { /*TODO*/ outputunit = "Feet"
                            oExpand = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeter") },
                        onClick = { /*TODO*/ outputunit = "Millimeter"
                            oExpand = false
                        }
                    )
                }
            }


        }
        conversionFactor.value = ConversionFactorfun(inputunit, outputunit)
        OutputValue.value = UnitConvert(input, conversionFactor.value)
        Text(
            text = "Result: ${OutputValue.value} $outputunit",
            style = MaterialTheme.typography.headlineSmall
        )
    }
//    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterUI()
}
