package edu.uksw.fti.pam.pam_activityintent

import android.content.Intent
import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM_ActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Card(
                    modifier = Modifier
                        .background(coklatTua)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bgsatu),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                    LoginForm()
                }
            }
        }
    }
}

internal fun doAuth(
    username: String,
    password: String
):Boolean{
    return(username.equals("admin") && password.equals("admin"))
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current
    var usernameInput by remember { mutableStateOf("")}
    var passwordInput by remember { mutableStateOf("")}

    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 15.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "logonismo",
            modifier = Modifier
                .height(40.dp)

        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 230.dp)
            .width(600.dp)

    ) {
        Text(
            text = "Login",
            fontFamily = anekBold,
            fontSize = 40.sp
            )
        Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = usernameInput,
                onValueChange = {usernameInput = it},
                label = {
                    Text(text = "Username")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(cokz)

            )
            TextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(cokz)
            )
            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp)),
                onClick = {
                    val isAuthenticated = doAuth(usernameInput, passwordInput)
                    if (isAuthenticated)
                        lContext.startActivity(
                            Intent(lContext, HomeActivity::class.java)
                                .apply {
                                    putExtra("username", usernameInput)
                                }
                        )
                }
            ){
                Text(text = "Login", color = merahNismo,)
            }
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 48.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account ?", color = white, fontFamily = anekMedium)
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "SIGN UP", color = merahNismo, fontFamily = anekMedium)
                }
            }
        }

        }
}

@Preview(showBackground = true)
@Composable
fun DefaultsPreview() {
    PAM_ActivityIntentTheme {
        LoginForm()
    }
}
