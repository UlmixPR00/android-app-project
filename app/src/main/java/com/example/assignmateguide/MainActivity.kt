package com.example.assignmateguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Bullet
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmateguide.ui.theme.AssignMateGuideTheme  //***change this to your theme name if different


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AssignMateGuideTheme(){  //***change this to your theme name if different
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf("home") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        when (currentScreen) {
            "home" -> HomeScreen(
                innerPadding = innerPadding,
                onNavigateToSecondScreen = { currentScreen = "second" }
            )

            "second" -> TaskCreation(
                innerPadding = innerPadding,
                onBackToHome = { currentScreen = "home" },
            )
        }
    }
}

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    onNavigateToSecondScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().background(Color(0xFFD1E1FF)).border(1.dp, Color.Black)
        ){
            Box(
                modifier =Modifier.size(100.dp).background(Color(0xFF89AFFA)),
                contentAlignment = Alignment.Center
            ){
            Image(
                painter = painterResource(id = R.drawable.home_symbol),
                contentDescription = "homesymbol",
                modifier = Modifier.size(100.dp)
            ) }
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Diego Lozano",
                    style = MaterialTheme.typography.headlineMedium,
                )


                Text(
                    text = "NLU",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
/* break ///////////////////////////////////////////// */
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color(0xFFD1E1FF)).
            border(1.5.dp, Color.Black).
            padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            Text(
                text = "Urgent Tasks.",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
                Spacer(modifier = Modifier.width(8.dp))
            Image(
                    painter = painterResource(id = R.drawable.warning_icon),
                    contentDescription = "urgent",
                    modifier = Modifier.size(24.dp)
                )

        }
        Column{
            val bullet1 = Bullet.Default.copy(shape = CircleShape)

            Text(
                style = MaterialTheme.typography.headlineSmall,
                text =  buildAnnotatedString {
                    withBulletList(bullet = bullet1) {
                        withBulletListItem { append("Complete Quiz 5")}
                        withBulletListItem { append("Milestone 2") }
                        withBulletListItem { append("Discussion 4") }
                    }
                }
            )



        }



        Spacer(modifier = Modifier.height(24.dp))
/* break //////////////////////////////////////////////// */

        Button(onClick = onNavigateToSecondScreen,
            colors = ButtonDefaults.buttonColors(Color(0xFF89AFFA)),
            border= BorderStroke(2.dp,Color.Black))

        {

            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "add",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("add/edit task",
                style = MaterialTheme.typography.headlineSmall)

        }
    }
}
/*break ////////////////////////////////////// */

@Composable
fun TaskCreation(
    innerPadding: PaddingValues,
    onBackToHome: () -> Unit
) {
    var titleText by remember {mutableStateOf("")}
    var contentText by remember {mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
            .background(Color(0xFFADC6FF))
            .border(1.dp, Color.Black)
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                if (titleText.isEmpty()) {
                    Text(
                        text = "Title: |",
                        style = MaterialTheme.typography.displaySmall,
                        color = Color.DarkGray
                    )
                }
                BasicTextField(
                    value = titleText,
                    onValueChange = { titleText = it},
                    textStyle = MaterialTheme.typography.displaySmall.copy(color = Color.Black),
                    modifier = Modifier.fillMaxWidth().testTag("title_input")
                )
            }
            IconButton(onClick = onBackToHome) {
                Icon(
                    painter = painterResource(id = R.drawable.checkmark),
                    contentDescription = "Save",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF0D1B2A)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ){
            if (contentText.isEmpty()) {
                Text(
                    text = "Content: |",
                    style = MaterialTheme.typography.displayMedium,
                    color =Color.LightGray
                )
            }
            BasicTextField(
                value = contentText,
                onValueChange = {contentText = it},
                textStyle = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
                modifier = Modifier.fillMaxSize()
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD1E1FF))
                .border(1.dp, Color.Black)
        ){
            TaskCustom(
                label = "Set deadline",
                value = "03/25/2026",
                iconId = R.drawable.calendar_date
            )
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Black))

            TaskCustom(
                label = "Set Identifier",
                value ="Add Icon",
                iconId = R.drawable.arrow
            )
        }
    }
}

@Composable
fun TaskCustom(label: String, value: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF89AFFA))
                    .border(1.dp, Color.Black)
                    .padding(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = "icons",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    AssignMateGuideTheme() {   //***Change this to your theme name if different
        HomeScreen(
            innerPadding = PaddingValues(0.dp),
            onNavigateToSecondScreen = {}
        )
    }
}

//This one previews the SecondScreen

@Preview(showBackground = true)
@Composable
fun PreviewSecondScreen() {
    AssignMateGuideTheme {   //***Change this to your theme name if different
        TaskCreation(
            innerPadding = PaddingValues(0.dp),
            onBackToHome = {}
        )
    }
}
