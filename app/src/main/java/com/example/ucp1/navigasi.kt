package com.example.ucp1


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.view.FormulirPendaftaran
import com.example.ucp1.view.TampilData
import com.example.ucp1.view.home

enum class Navigasi{
    Formulirku,
    Detail,
    Home
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,
            modifier = Modifier.padding(isiRuang))
        {

            composable(route = Navigasi.Home.name){
                home(
                    OnToFormBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Formulirku.name){
                FormulirPendaftaran(
                    onSubmitButtonClick = {
                        navController.navigate(Navigasi.Detail.name)
                    },
                    onToHomeBtnClick = {
                        navController.navigate(Navigasi.Detail.name) {
                            popUpTo(Navigasi.Detail.name) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onToFormBtnClick = {
                        navController.popBackStack()
                    },
                    onToHomeBtnClick = {
                        navController.navigate(Navigasi.Formulirku.name) {
                            popUpTo(Navigasi.Formulirku.name) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }

        }
    }
}
