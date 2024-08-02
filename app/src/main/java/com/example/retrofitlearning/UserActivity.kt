package com.example.retrofitlearning

import android.content.Intent
import android.os.Bundle
import android.text.Layout.Alignment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.retrofitlearning.datauser.UserSingleTon
import com.example.retrofitlearning.ui.theme.RetroFitLearningTheme

class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardUser()

        }
    }
    @Composable
    fun CardUser(){
        Card(){
            Column {
                AsyncImage(model = UserSingleTon.userImage, contentDescription = "")
                Text(text = UserSingleTon.userLogin, fontSize = 30.sp, modifier = Modifier.padding(0.dp,20.dp))
                Text(text = UserSingleTon.userPassword, fontSize = 20.sp, modifier = Modifier.alpha(0.5f).padding(0.dp,20.dp))
            }
        }
    }
}



