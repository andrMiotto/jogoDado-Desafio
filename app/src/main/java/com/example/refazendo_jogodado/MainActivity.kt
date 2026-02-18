package com.example.refazendo_jogodado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.refazendo_jogodado.ui.theme.RefazendojogoDadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RefazendojogoDadoTheme {
                jogoDado(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                );
            }
        }
    }
}

@Composable
fun jogoDado(modifier: Modifier = Modifier) {

    var resultado by remember { mutableStateOf(1) }
    var resultado2 by remember { mutableStateOf(6) }

    var soma by remember { mutableStateOf(0) }

    var total by remember { mutableStateOf(0) }

    var imagemResultado = when (resultado) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6

    }

    var imagemResultado2 = when (resultado2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6

    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Image(painter = painterResource(imagemResultado), contentDescription = "Dado")

            Image(painter = painterResource(imagemResultado2), contentDescription = "Dado2")

            Spacer(modifier = Modifier.height(60.dp))


        }

        Button(onClick = {
            resultado = (1..6).random()
            resultado2 = (1..6).random()
            soma = resultado + resultado2
            total += soma;

        }) {
            Text(text = "Rolar", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { total = 0 }) {
            Text(text = "Reset", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Soma: $soma", fontSize = 20.sp)

        Text(text = "Total: $total", fontSize = 20.sp)

    }
}
