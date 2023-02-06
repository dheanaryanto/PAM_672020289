package edu.uksw.fti.pam.pam_activityintent

import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setContent {
            PAM_ActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .background(coklatmuda)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ){
                    HeaderProfileComponent()
                    jduduldanlogo()
                    berita()
                    jduduldanlogo2()
                    produk()
                    aksesoris()
                    Spacer(modifier = Modifier.weight(1f))
                    BottomComponent()
                }

            }
        }
    }
}


@Composable
fun HeaderProfileComponent(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(coklatTua)
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)

    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }

        Row() {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = { Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = coklatTua,
                ) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = coklatTua,
                    unfocusedBorderColor = coklatTua),
                modifier = Modifier
                    .padding(end = 10.dp, top = 1.dp)
                    .height(35.dp)
                    .width(220.dp)
                    .background(coklatmuda, RoundedCornerShape(40.dp))
            )
            BadgedBox(badge = { Badge(backgroundColor = merahNismo)}) {
                Image(painter = painterResource(id = R.drawable.akun), contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(30.dp)
                        .clip(CircleShape)
                )
            }
        }



    }
}

@Composable
fun jduduldanlogo(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
            ) {
        Text(text = "NEWS", fontSize = 20.sp, fontFamily = anekBold)
        Image(painter = painterResource(id = R.drawable.nismo), contentDescription = "logonismo",
            modifier = Modifier
                .width(110.dp)
                .height(30.dp)
                .padding(top = 1.dp)

        )
    }
}

@Composable
fun berita(){
    LazyRow(
        modifier = Modifier
            .height(180.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item { 
            beritaItem(imagePainter = painterResource(id = R.drawable.berita1),
                title = "2024 Nissan GT-R receives updated aerodynamics",
                subtitle = "... with GT-R Premium and T-spec® with 565.",
                backgroudColor = coklatmuda
                )
        }
        item {
            beritaItem(imagePainter = painterResource(id = R.drawable.berita2),
                title = "Here's a First Look at the 2024 Nissan GT-R",
                subtitle = "Nissan has officially revealed its 2024 GT-R lineup...",
                backgroudColor = coklatmuda
            )
        }
    }
}

@Composable
fun beritaItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroudColor: Color = coklatmuda,
    imagePainter: Painter
){
    Card(
        modifier = Modifier
            .width(300.dp),
        backgroundColor = backgroudColor,
        elevation = 0.dp

    ) {
        Column {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(5.dp)),

                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 2.dp)
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.Black, fontFamily = anekMedium)
                Text(text = subtitle, fontSize = 14.sp, color = Color.Black, fontFamily = anekLight)
            }

        }
    }
}

@Composable
fun jduduldanlogo2(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = "NISMO AUTHENTIC PARTS", fontSize = 20.sp, fontFamily = anekBold)
    }
}

@Composable
fun produk(){
    LazyRow(
        modifier = Modifier
            .height(230.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            produkItem(imagePainter = painterResource(id = R.drawable.pelkz),
                title = "LM GT4 Aluminum Road Wheel Machining Logo",
                subtitle = "IDR 90.000.000",
                backgroudColor = hitamkren
            )
        }
        item {
            produkItem(imagePainter = painterResource(id = R.drawable.kaliperz),
                title = "NISSAN GT-R (R35) Nissan Genuine Brake Kit",
                subtitle = "IDR 30.000.000",
                backgroudColor = hitamkren
            )
        }
        item {
            produkItem(imagePainter = painterResource(id = R.drawable.armz),
                title = "NISMO LightWeight Suspension Link Series",
                subtitle = "IDR 10.000.000",
                backgroudColor = hitamkren
            )
        }
    }
}

@Composable
fun produkItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroudColor: Color = hitamkren,
    imagePainter: Painter
){
    Card(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(5.dp)),
        backgroundColor = backgroudColor,
        elevation = 0.dp

    ) {
        Column {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(text = title, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium)
                Text(text = subtitle, fontSize = 11.sp, color = Color.White, fontFamily = anekLight)
            }

        }
    }
}

@Composable
fun aksesoris(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 0.dp,
        backgroundColor = hitamkren
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.nism_o),
                    contentDescription = "logokcil" ,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 2.dp, end = 2.dp, bottom = 2.dp)
                )
                Text(text = "NISMO APPAREL", fontFamily = anekBold, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.nism_o),
                    contentDescription = "logokcil" ,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 2.dp, end = 2.dp, bottom = 2.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.hoodie),
                    contentDescription = "hoodi" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.keychain),
                    contentDescription = "keych" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.shirt),
                    contentDescription = "shirt" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "umbr" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.pants),
                    contentDescription = "pants" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.stickers),
                    contentDescription = "sticker" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.headwear),
                    contentDescription = "headwer" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.tumbker),
                    contentDescription = "tumbler" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

        }

    }
}

@Composable
fun BottomComponent( ){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(coklatTua)
            .height(60.dp)
    ){

        Image(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = "cart",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(48.dp)
                .padding(top = 5.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "home" ,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 0.dp, end = 12.dp, top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.parts),
                contentDescription = "parts" ,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 12.dp, end = 39.dp, top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.apparelbna),
                contentDescription = "apparel" ,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 39.dp, end = 12.dp, top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.news),
                contentDescription = "news" ,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 12.dp, end = 0.dp, top = 5.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAM_ActivityIntentTheme {
        aksesoris()
    }
}

