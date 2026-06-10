package com.example.assignmateguide


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmateguide.ui.theme.AssignMateGuideTheme
import com.example.assignmateguide.ui.theme.Darkblue
import com.example.assignmateguide.ui.theme.Lightblue
import com.example.assignmateguide.ui.theme.Navyblue
import com.example.assignmateguide.ui.theme.VeryLightblue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.AssignmentLate
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.assignmateguide.ui.theme.red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AssignMateGuideTheme(){
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
            modifier = Modifier.fillMaxWidth().background(VeryLightblue).border(1.dp, Color.Black)
        ){
            Box(
                modifier =Modifier.size(100.dp).background(Darkblue),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(100.dp),
                    tint = Navyblue
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
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
            modifier = Modifier.background(VeryLightblue).
            border(1.5.dp, Color.Black).
            padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            Text(
                text = "Urgent Tasks.",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Filled.AssignmentLate,
                contentDescription ="alert",
                modifier = Modifier.size(30.dp),
                tint = red
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "• Complete Quiz 5",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "• Milestone 2",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "• Discussion 4",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

/* break //////////////////////////////////////////////// */

        Button(
            onClick = onNavigateToSecondScreen,
            colors = ButtonDefaults.buttonColors(Darkblue),
            border= BorderStroke(2.dp,Color.Black)
        ){
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier.size(25.dp),
                tint = Navyblue
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "add/edit task",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Navyblue
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

/* break //////////////////////////////////////////////// */

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {

            Icon(
                imageVector = Icons.Filled.CalendarMonth,
                contentDescription = "Upcoming Assignments Calendar",
                modifier = Modifier.size(150.dp),
                tint = Navyblue
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(VeryLightblue)
                        .border(1.5.dp, Color.Black)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Upcoming Assignments",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = "• Lab 10 CSS 304",
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Black,
                        fontSize = 20.sp)
                    Text(text = "• Quiz 10 CSS 424",
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Black,
                        fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(90.dp))
/* break //////////////////////////////////////////////// */

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Lightblue)
                .border(1.5.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(70.dp), tint = Navyblue)
                Text(text = "Home", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Navyblue)
            }

            // Tasks
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = "tasks", modifier = Modifier.size(70.dp), tint = Navyblue)
                Text(text = "Tasks", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Navyblue)
            }

            // Calendar
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Filled.CalendarMonth, contentDescription = "Calendar", modifier = Modifier.size(70.dp), tint = Navyblue)
                Text(text = "Calendar", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Navyblue)
            }

            // Academics
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Filled.AssignmentInd, contentDescription = "Academic", modifier = Modifier.size(70.dp), tint = Navyblue)
                Text(text = "Academics", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Navyblue)
            }
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
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp).background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
            .background(Lightblue)
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
            IconButton(onClick = onBackToHome,
                modifier = Modifier.testTag("save_button")) {

                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Save",
                    modifier = Modifier.size(40.dp),
                    tint = Navyblue
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
                    .border(1.dp, Color.LightGray)
                    .padding(12.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(VeryLightblue)
                .border(1.dp, Color.Black)
        ){
            TaskCustom(
                label = "Set deadline",
                value = "03/25/2026",
                icon = Icons.Filled.DateRange
            )
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Black))
            TaskCustom(
                label = "Set Identifier",
                value ="Add Icon",
                icon = Icons.Filled.ArrowDropDown
            )
        }
    }
}

@Composable
fun TaskCustom(
    label: String,
    value: String,
    icon: ImageVector
) {
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
                    .background(Darkblue)
                    .border(1.dp, Color.Black)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = icon, // 2. Active property changed to imageVector
                    contentDescription = "icons",
                    modifier = Modifier.size(24.dp),
                    tint = Navyblue
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    AssignMateGuideTheme() {
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
    AssignMateGuideTheme {
        TaskCreation(
            innerPadding = PaddingValues(0.dp),
            onBackToHome = {}
        )
    }
}
