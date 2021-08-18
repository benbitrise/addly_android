package com.bitrise.addly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bitrise.addly.ui.theme.AddlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddlyTheme {
                calculator()

            }
        }
    }
}

@Composable
fun calculator() {
    var operands by rememberSaveable { mutableStateOf(Pair("0", "0")) }
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Text("☞Add.ly", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(80.dp))
            OperandInput(value = operands.first, label = "Operand 1", onValueChange = { operands = Pair(it, operands.second) })
            Text("+")
            OperandInput(value = operands.second, label = "Operand 2", onValueChange = { operands = Pair(operands.first, it) })
            Text("=")
            Text(((operands.first.toIntOrNull() ?: 0) + (operands.second.toIntOrNull() ?: 0)).toString(), modifier = Modifier.testTag("sum"))
        }
    }
}

    @Composable
    fun OperandInput(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        modifier = Modifier.testTag(label),
        onValueChange = onValueChange,
        label = { Text(label ) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AddlyTheme {
        calculator()
    }
}
