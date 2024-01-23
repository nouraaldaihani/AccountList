package com.joincoded.accountstatements.ui.composebals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.accountstatements.model.DataTransaction

@Composable
fun AccountStatmentCard(accountStatement: DataTransaction) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {

            Text(
                text = accountStatement.transactionType,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,

                )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "${accountStatement.amount} USD",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))


            Text(
                text = accountStatement.date,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))


            Text(
                text = accountStatement.currency,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Balance: ${accountStatement.balence} KWD",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun AccountStatmentList(accountStatement: List<DataTransaction>) {
    LazyColumn {
        items(accountStatement) { statement ->
            AccountStatmentCard(accountStatement = statement)
        }
    }
}
@Composable
fun AccountStatementsListPage() {
    val dummyData = generateDummyData()
    AccountStatmentList(accountStatement= dummyData)
}
fun generateDummyData(): List<DataTransaction> {
    return listOf(
        DataTransaction("Deposit", 100.0, "2024-01-23", "KWD", 1500.0),
        DataTransaction("Withdraw", 50.0, "2024-01-22", "KWD", 1450.0),
        DataTransaction("Withdraw", 50.0, "2024-01-22", "KWD", 14.0),
    )
}