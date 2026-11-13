package ca.gbc.comp3074.morgan_ben.composemessages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val screenBackground = Color(0xFFF7F7F7)
private val listBackground = Color(0xFFFAF4FC)

private data class Message(val sender: String, val text: String)

private val sampleMessages = listOf(
    Message("Joe", "Hi!"),
    Message("Jim", "How are you?"),
    Message("Joe", "Test..1..2...3"),
    Message("Joe", "I hate coding!!!")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val systemBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), screenBackground.toArgb())
        enableEdgeToEdge(
            statusBarStyle = systemBarStyle,
            navigationBarStyle = systemBarStyle
        )
        setContent {
            MaterialTheme {
                MessageList(sampleMessages + sampleMessages + sampleMessages)
            }
        }
    }
}

@Composable
private fun MessageList(messages: List<Message>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackground)
            .safeDrawingPadding()
            .padding(horizontal = 20.dp)
            .background(listBackground)
    ) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Composable
private fun MessageCard(message: Message) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Image(
            painter = painterResource(R.drawable.android_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Red, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.sender,
                color = Color(0xFF625B71),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = listBackground,
                shadowElevation = 1.dp
            ) {
                Text(
                    text = message.text,
                    color = Color(0xFF1D1B20),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
