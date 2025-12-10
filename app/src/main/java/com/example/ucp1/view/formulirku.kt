package com.example.ucp1.view


import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirPendaftaran(
    onSubmitButtonClick: () -> Unit,
    onToHomeBtnClick:()-> Unit,
    modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var posisi by remember { mutableStateOf(TextFieldValue("")) }
    var jenisKelamin by remember { mutableStateOf("") }
    var section by remember { mutableStateOf("") }

    val paddingSmall = dimensionResource(id = R.dimen.padding_smallform)
    val paddingMedium = dimensionResource(id = R.dimen.padding_mediumform)
    val paddingLarge = dimensionResource(id = R.dimen.padding_largeform)
    val buttonHeight = dimensionResource(id = R.dimen.button_heightform)

    Surface(
        color = Color(0xFFF6ECFF),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color(0xFFB56BFF)) // warna ungu full tepi layar
                    .padding(vertical = paddingLarge)
            ) {
                Text(
                    text = stringResource(R.string.FormulirPendaftaran),
                    fontSize = dimensionResource(R.dimen.font_titleform).value.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingMedium)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ){
                Column(modifier = Modifier
                    .padding(paddingMedium)
                    .fillMaxWidth()
                ){
                    Text("NAMA LENGKAP", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        placeholder = { Text("Isian nama lengkap") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = paddingSmall)
                    )
                    Spacer(modifier = Modifier.height(paddingMedium))

                    Text("JENIS KELAMIN", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(paddingSmall))
                    Column(verticalArrangement = Arrangement.spacedBy(paddingSmall)) {
                        listOf("Laki-laki", "Perempuan").forEach { opsi ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = jenisKelamin == opsi,
                                    onClick = { jenisKelamin = opsi }
                                )
                                Text(opsi)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(paddingMedium))

                    Text("Section", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(paddingSmall))
                    Column(verticalArrangement = Arrangement.spacedBy(paddingSmall)) {
                        listOf("Barat", "Selatan", "Utara").forEach { opsi ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected =  section== opsi,
                                    onClick = { section = opsi }
                                )
                                Text(opsi)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(paddingMedium))

                    Text("Posisi", fontWeight = FontWeight.Bold)
                    Column(verticalArrangement = Arrangement.spacedBy(paddingSmall)) {
                        listOf("Depan", "Belakang").forEach { opsi ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected =  section== opsi,
                                    onClick = { section = opsi }
                                )
                                Text(opsi)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(height = 10.dp))


                    Button(
                        onClick = onSubmitButtonClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A2BE2)),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(buttonHeight)
                    ) {
                        Text(stringResource(R.string.submit2), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onToHomeBtnClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A2BE2)),
                        shape = RoundedCornerShape(50)
                        ){
                        Text(text = stringResource(id=R.string.submit1),color = Color.White, fontWeight = FontWeight.Bold)
                    }


                }

            }

        }
    }

}