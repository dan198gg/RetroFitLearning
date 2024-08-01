package com.example.retrofitlearning

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.retrofitlearning.ui.theme.RetroFitLearningTheme

class UserActivity : ComponentActivity() {
    val intent = getIntent()
    val login=intent.getStringExtra("userlogin")
    val password=intent.getStringExtra("userpassword")
    val image=intent.getStringExtra("userimage")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardUser()
            Log.i("LOGIN",login.toString())
            Log.i("PASSWORD",password.toString())
        }
    }
    @Composable
    fun CardUser(){
        Card{
            AsyncImage(model = image, contentDescription = "")
        }
    }
}



