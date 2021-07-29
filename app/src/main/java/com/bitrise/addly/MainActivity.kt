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
            OperandInput(value = operands.first, onValueChange = { operands = Pair(it, operands.second) })
            Text("+")
            OperandInput(value = operands.second, onValueChange = { operands = Pair(operands.first, it) })
            Text("=")
            Text(((operands.first.toIntOrNull() ?: 0) + (operands.second.toIntOrNull() ?: 0)).toString())
        }
    }
}

    @Composable
    fun OperandInput(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value ,
        onValueChange = onValueChange,
        label = { Text("Operand 1") }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AddlyTheme {
        calculator()
    }
}


//
//struct ContentView: View {
//    @ObservedObject var operand1 = NumbersOnly()
//    @ObservedObject var operand2 = NumbersOnly()
//    var result: String {
//        guard let operand1Value = Int(operand1.value), let operand2Value = Int(operand2.value) else {
//        return "0"
//    }
//        let sum = operand1Value + operand2Value
//        let asStr = String(sum)
//        return asStr
//    }
//
//    var body: some View {
//        Color.init(red: (249/256), green: (242/256), blue: (214/256)).ignoresSafeArea().overlay(
//        VStack {
//            Text("☞ add.ly")
//                .font(Font.custom("Menlo-Bold", size: 32))
//            Spacer()
//            TextField("Operand 1", text: $operand1.value)
//            .keyboardType(.decimalPad)
//            .font(Font.custom("Menlo", size: 18))
//            Text("➕")
//            TextField("Operand 2", text: $operand2.value)
//            .keyboardType(.decimalPad)
//            .font(Font.custom("Menlo", size: 18))
//
//            Text("=").font(Font.custom("Menlo-Bold", size: 23)).padding()
//            Text(result).font(Font.custom("Menlo-Bold", size: 23))
//        }
//        )
//    }
//}
//
//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}
