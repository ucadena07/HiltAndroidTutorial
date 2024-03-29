package com.example.hilttutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hilttutorial.database.DatabaseAdapter
import com.example.hilttutorial.database.DatabaseService
import com.example.hilttutorial.hilt.CallInterceptorQualifier
import com.example.hilttutorial.hilt.ResponseInterceptorQualifier
import com.example.hilttutorial.network.INetworkAdapter
import com.example.hilttutorial.network.NetworkService
import com.example.hilttutorial.stats.StatsViewModel
import com.example.hilttutorial.ui.theme.HiltTutorialTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var databaseAdapter: DatabaseAdapter
    //@Inject lateinit var networkAdapter: INetworkAdapter
    //@CallInterceptorQualifier
    @ResponseInterceptorQualifier
    @Inject lateinit var networkService: NetworkService
    private val statsViewmodel : StatsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContent {
                HiltTutorialTheme {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Greeting("Android")
                        databaseAdapter.log("Interface binding")
                        networkService.performNetworkCall()
                        statsViewmodel.statsLiveData.observe(this){
                            Log.d("DI", "New stats coming in: $it")
                        }
                        statsViewmodel.startStatsCollection()
                    }
                }
            }
        }catch(e: Exception){
            setContent {
                HiltTutorialTheme {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text(e.message.toString())

                    }
                }
            }
        }

    }

}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltTutorialTheme {
        Greeting("Android")
    }
}