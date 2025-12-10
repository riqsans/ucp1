package com.example.ucp1.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home(
    modifier: Modifier = Modifier,
    OnToFormBtnClick : () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(text = stringResource(R.string.selamat_datang),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF000000)
            )

            val gambar = painterResource(R.drawable.logomercie1coba1)
            Image(
                painter = gambar,
                contentDescription = null,
                modifier = Modifier.size(500.dp)
            )
            Column(modifier= Modifier,horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = stringResource(R.string.nama_lengkap),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(text = stringResource(R.string.NIM),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = OnToFormBtnClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,  // warna background button
                    contentColor = Color.White     // warna teks di dalam button
                )
            ){
                Text(stringResource(id = R.string.submit))
            }

        }
    }
}