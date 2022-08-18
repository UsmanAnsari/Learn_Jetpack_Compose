package uansari.test.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uansari.test.learncompose.ui.theme.GradientEnd
import uansari.test.learncompose.ui.theme.GradientMid
import uansari.test.learncompose.ui.theme.GradientStart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLogInScreen()
        }
    }

    @Preview
    @Composable
    fun MainLogInScreen() {
        val gradientForBackground =
            Brush.linearGradient(
                0f to GradientStart,
                0.4f to GradientMid,
                0.9f to GradientEnd,
                tileMode = TileMode.Mirror
            )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientForBackground)
                .padding(20.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ic_logo_ubl_digital),
                contentDescription = "UBL Logo", Modifier.padding(top = 88.dp)
            )
            Image(
                painterResource(id = R.drawable.ic_icon_navigation_bar_back_button),
                contentDescription = "UBL Logo",
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 15.dp)
            )
            Text(
                modifier = Modifier.padding(top = 240.dp),
                text = "Hi there!",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
            )
            Column(modifier = Modifier.align(Alignment.Center)) {
                InputText("Username")
                Spacer(modifier = Modifier.height(10.dp))
                InputText("Password")
            }
            HelperText(
                text = "Sign Up",
                Modifier
                    .padding(top = 470.dp)
                    .align(Alignment.TopStart)
            )
            HelperText(
                text = "Forgot your credentials?",
                Modifier
                    .padding(top = 470.dp)
                    .align(Alignment.TopEnd)
            )
            BottomButton(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }

    @Composable
    fun InputText(labelText: String) {
        var userInput by remember {
            mutableStateOf("")
        }
        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            label = {
                Text(labelText, color = Color.Black)
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(20)
        )
    }

    @Composable
    fun HelperText(text: String, modifier: Modifier) {
        Text(
            text = text,
            modifier = modifier,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }

    @Composable
    fun BottomButton(
        modifier: Modifier = Modifier,
        buttonText: String = "Sign in"
    ) {
        Button(
            onClick = {},

            modifier = modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        )
        {
            Text(text = buttonText, color = Color.White)
        }
    }
}
