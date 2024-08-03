package com.example.retrofitlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.retrofitlearning.datauser.UserSingleTon

class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ){
                CardUser()
            }
        }
    }
    @Composable
    fun CardUser(){
        Card(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.55f)){
            Column {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f).padding(0.dp,20.dp),
                    contentAlignment = Center){
                AsyncImage(model = UserSingleTon.userImage, contentDescription = "", modifier = Modifier.fillMaxWidth(0.8f))
                    }
                Box(contentAlignment = Center) {
                    Column {
                        Text(
                            text = UserSingleTon.userLogin,
                            fontSize = 50.sp,
                            modifier = Modifier.padding(0.dp, 20.dp).fillMaxWidth(), textAlign = TextAlign.Center
                        )
                        Text(
                            text = UserSingleTon.userEmail, fontSize =17.sp, modifier = Modifier
                                .alpha(0.5f)
                                .padding(0.dp, 10.dp).fillMaxWidth(), textAlign = TextAlign.Center
                        )
                        Text(
                            text = UserSingleTon.userGender, fontSize = 18.sp, modifier = Modifier
                                .alpha(0.5f)
                                .padding(0.dp, 15.dp).fillMaxWidth(), textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}



