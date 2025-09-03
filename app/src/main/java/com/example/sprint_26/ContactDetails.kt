package com.example.sprint_26

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .weight(0.5F),
                contentAlignment = Alignment.Center
            ) {
                ProfileImage(contact)
            }

            Column(
                modifier = Modifier
                    .weight(0.5F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NameContent(contact)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75F),
        ) {
            InfoRow(
                title = stringResource(R.string.phone_title),
                info = contact.phone
            )
            InfoRow(
                title = stringResource(R.string.address_title),
                info = contact.address
            )
            InfoRow(
                title = stringResource(R.string.email_title),
                info = contact.email
            )
        }
    }
}

@Composable
fun NameContent(contact: Contact) {
    Text(
        text = contact.name,
        style = MaterialTheme.typography.h6
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = contact.familyName,
            style = MaterialTheme.typography.h5
        )
        if (contact.isFavorite)
            Image(
                modifier = Modifier.padding(start = 8.dp),
                painter = painterResource(android.R.drawable.star_big_on),
                contentDescription = stringResource(R.string.is_favourite_desc),
            )
    }
}

@Composable
fun ProfileImage(contact: Contact) {
    if (contact.imageRes != null)
        Image(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxSize(),
            painter = painterResource(contact.imageRes),
            contentDescription = stringResource(R.string.image_description),
            contentScale = ContentScale.Fit
        )
    else {
        Box(
            modifier = Modifier.padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.circle),
                contentDescription = stringResource(R.string.image_description),
                tint = Color.LightGray

            )
            Text(
                text = getInitials(contact.name, contact.familyName),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

fun getInitials(name: String, familyName: String): String {
    return "${name.take(1)}${familyName.take(1)}"
}

@Composable
fun InfoRow(title: String, info: String?) {
    if (info != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, top = 16.dp, start = 16.dp),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5F),
                text = title,
                style = MaterialTheme.typography.body1,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5F)
                    .padding(start = 16.dp),
                text = info,
                style = MaterialTheme.typography.body2
            )
        }
    }
}