package com.example.retrofitlearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitlearning.dataproduct.ProductApi
import com.example.retrofitlearning.datauser.DataPostUser
import com.example.retrofitlearning.ui.theme.RetroFitLearningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Okio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val interceptor=HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        val client= OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit=Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        val productApi=retrofit.create(ProductApi::class.java)

        setContent {
            val corScope= rememberCoroutineScope()
            LaunchedEffect(key1 = "") {
            corScope.launch {
                    val user=productApi.auth(DataPostUser(30,"emilyspass","emilys"))
                    Log.i("INFOUSER",user.email)
                }
            }
        }
    }
}


//val product1 = productApi.getProduct(8)
//                Log.i("INFOPRODUCT",product1.brand)
