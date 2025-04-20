package com.example.calculadoraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions // Import correct KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadoraapp.ui.theme.CalculadoraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculadoraCompose()
                }
            }
        }
    }
}

@Composable
fun CalculadoraCompose() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull()
                val n2 = numero2.toDoubleOrNull()
                resultado = if (n1 != null && n2 != null) {
                    "Resultado: ${n1 + n2}"
                } else {
                    "Insira dois números válidos"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Somar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultado, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculadora() {
    CalculadoraAppTheme {
        CalculadoraCompose()
    }
}