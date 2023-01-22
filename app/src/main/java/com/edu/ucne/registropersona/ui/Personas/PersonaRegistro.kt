package com.edu.ucne.registropersona.ui.Personas

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.ucne.registropersona.R

@Composable
fun PersonaRegistro(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
                Registro(Modifier.align(Alignment.Center))
            }

}

@Composable
fun ButtonGuardar(modifier: Modifier) {
    OutlinedButton(onClick = { },
        contentPadding = PaddingValues(
            start = 80.dp,
            top = 16.dp,
            end =  50.dp,
            bottom = 16.dp
        ),


        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color(0xFFB76AE0)
        ), modifier = modifier)
    {
        Image(painter = painterResource(id = R.drawable.save),
            contentDescription = "Header")

        Text(text = "Guardar", fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun OcupacionBox() {
   val ocupaciones = listOf("Estilista", "Enfermera", "Abogado", "Doctor", "Albañil", "Ingeniero")
    var ocupacionSeleccionada by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            label = { Text("Selecciona Ocupacion")},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            },
            value =  ocupacionSeleccionada,
            onValueChange = {ocupacionSeleccionada = it},
            readOnly = true, enabled = false,
            modifier = Modifier
                .clickable {
                    expandido = true
                    Log.e("tag", "expandio")
                }
                .fillMaxWidth()
        )

    }
    DropdownMenu(
        expanded = expandido,
        onDismissRequest = { expandido = false},
        modifier = Modifier.fillMaxWidth()
        ) {
            ocupaciones.forEach { item ->
                DropdownMenuItem(onClick = {
                    expandido = false
                    ocupacionSeleccionada = item
                }) {
                    Text(text = item)
                }
            }
    }
}

@Composable
fun FechaNacimientoField() {
    var  fechaNacimiento by remember {
        mutableStateOf("")
    }
    Row() {

        OutlinedTextField(
            value = fechaNacimiento,
            onValueChange = {value -> fechaNacimiento = value},
            label = {
               /* Image(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null)*/
                Text(text = "Fecha de Nacimiento")},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {

                        }
                        .size(30.dp, 30.dp),
                    tint = MaterialTheme.colors.onSurface
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF3A3939),
                backgroundColor = Color(0xD0FCFCFC)
            )
        )
    }

}

@Composable
fun DireccionField() {
    var  direccion by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = direccion,
        onValueChange = {direccion = it},
        label = { Text(text = "Direccion")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xD0FCFCFC)
        )
    )
}

@Composable
fun EmailField() {
    var  email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = email,
        onValueChange = {email = it},
        label = { Text(text = "Email")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xD0FCFCFC)
        )
    )
}

@Composable
fun Celular() {
    var  celular by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = celular,
        onValueChange = {celular = it},
        label = { Text(text = "Celular")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xD0FCFCFC)
        )
    )
}

@Composable
fun Telefono() {
    var  telefono by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
    value = telefono,
    onValueChange = {telefono = it},
    label = { Text(text = "Telefono")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xD0FCFCFC)
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NombresField() {
    var nombres by remember {
       mutableStateOf("")
    }
    OutlinedTextField(
        value = nombres,
        onValueChange = { nombres = it},
        label = { Text(text ="Nombres")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xD0FCFCFC)
        )
    )
}
@Composable
fun HearderText(modifier: Modifier) {
    Text(text = "Registro de Personas",
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = modifier)
}

    @Composable
    fun Registro(modifier: Modifier) {
        Card(
            elevation = 16.dp
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                HearderText(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(8.dp))
                NombresField()
                Spacer(modifier = Modifier.padding(4.dp))
                Telefono()
                Spacer(modifier = Modifier.padding(4.dp))
                Celular()
                Spacer(modifier = Modifier.padding(4.dp))
                EmailField()
                Spacer(modifier = Modifier.padding(4.dp))
                DireccionField()
                Spacer(modifier = Modifier.padding(4.dp))
                FechaNacimientoField()
                Spacer(modifier = Modifier.padding(4.dp))
                OcupacionBox()
                Spacer(modifier = Modifier.padding(4.dp))
               ButtonGuardar(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }

