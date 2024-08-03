package com.example.retrofitlearning

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitlearning.dataproduct.ProductApi
import com.example.retrofitlearning.datauser.DataPostUser
import com.example.retrofitlearning.datauser.UserSingleTon
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    var login by
        mutableStateOf("")

    var password by
        mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        val productApi = retrofit.create(ProductApi::class.java)

        setContent {
            val corScope = rememberCoroutineScope()

            Text(text = "Войти", modifier = Modifier.fillMaxWidth().padding(0.dp,50.dp), textAlign = TextAlign.Center, fontSize = 40.sp)
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Column{
                    TextFieldsForUsers()
                    Button(onClick = {
                        corScope.launch {
                            try {
                                val user = productApi.auth(DataPostUser(30, password, login))
                                Log.i("INFOUSER", user.email)
                                val intent = Intent(this@MainActivity, UserActivity::class.java)
                                UserSingleTon.userLogin = login
                                UserSingleTon.userEmail = user.email
                                UserSingleTon.userImage = user.image
                                UserSingleTon.userGender = user.gender
                                startActivity(intent)
                                finish()
                            } catch (e: Exception) {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Ошибка, попробуйте еще раз!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    },
                        modifier = Modifier
                            .padding(0.dp, 30.dp)
                            .align(Alignment.CenterHorizontally)) {
                        Text(text = "Войти")
                    }
                }
            }
        }
    }


    @Composable
    fun TextFieldsForUsers() {
        Column {
            TextField(
                value = login,
                onValueChange = { login = it },
                placeholder = { Text(text = "Введите логин...") }
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Введите пароль...") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                , modifier = Modifier.padding(0.dp,30.dp)
            )
        }
    }
}

//val product1 = productApi.getProduct(8)
//                Log.i("INFOPRODUCT",product1.brand)
