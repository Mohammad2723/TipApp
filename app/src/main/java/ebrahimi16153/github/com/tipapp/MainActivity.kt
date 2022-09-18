package ebrahimi16153.github.com.tipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ebrahimi16153.github.com.tipapp.components.InputFiled
import ebrahimi16153.github.com.tipapp.ui.theme.Shapes
import ebrahimi16153.github.com.tipapp.ui.theme.TipAppTheme
import ebrahimi16153.github.com.tipapp.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp() {

            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    TipAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
           Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Top) {
               TopHeader()
               MainContent()
           }

        }
    }

}

// top header
@Composable
fun TopHeader(totalPrePerson: Double = 134.00) {


    Card(
        modifier = Modifier
            .fillMaxWidth(0.80F)
            .height(150.dp)
            .padding(vertical = 20.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        backgroundColor = Color(0XFFE9D7F7),
        elevation = 2.dp,
        /** another way to rounded shape
        shape = CircleShape.copy(CornerSize(15.dp)) */
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Per Person",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$$totalPrePerson",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )


        }
    }

}


// main content
@Composable
fun MainContent() {
   val totalBillState = remember{
       mutableStateOf("")
   }
    Card(
        modifier = Modifier
            .fillMaxWidth(85f)
            .padding(15.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column() {
            InputFiled(valueState  = totalBillState, labelId = "Enter Bill", enabled =true , isSingleLine =true , modifier = Modifier.fillMaxWidth())

        }

    }


}


//PreViw Compose
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipAppTheme {
        MyApp {

        }
    }
}




