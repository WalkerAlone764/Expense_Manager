package com.upsideDownDev.expensemanager

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.upsideDownDev.expensemanager.ui.theme.ExpenseManagerTheme
import org.koin.android.ext.android.get
import java.util.Currency
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }

        fun getEmojiFlag(country: String): String {
            val firstLetter = Character.codePointAt(country, 0) - 0x41 + 0x1F1E6
            val secondLetter = Character.codePointAt(country, 1) - 0x41 + 0x1F1E6
            return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
        }


        val list = mutableListOf<String>()


        val locale = Locale.getAvailableLocales()
        locale.forEach {
            Log.d("display: ", it.displayCountry)
            Log.d("country: ", it.country.toString())
                try {
                    var cu: String = ""
                    Log.d("emoji: ", getEmojiFlag(it.country).toString())
                    list.add(getEmojiFlag(it.country))

                    Currency.getInstance(it)?.let { curr ->
                        Log.d("curr: ", curr.currencyCode)
                        cu = curr.symbol
                    }
                    Log.d("it will not work", cu)
                } catch (e: Exception) {

                    Log.d("err: ",e.localizedMessage.toString())
                } finally {
                    Log.d("is worked", "yes")
                }


        }

        setContent {
            ExpenseManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        list = list
                    )


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,list: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        list.forEach {
            Text(text = it)
        }
    }
    

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseManagerTheme {
    }
}