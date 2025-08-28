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
fun ContactDetails(contact: Contact){
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
                SetImage(contact)
            }

            Column(
                modifier = Modifier
                    .weight(0.5F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SetName(contact)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75F),
        ) {
            SetInfoRow(
                title = stringResource(R.string.phone_title),
                info = contact.phone
            )
            SetInfoRow(
                title = stringResource(R.string.address_title),
                info = contact.address
            )
            SetInfoRow(
                title = stringResource(R.string.email_title),
                info = contact.email
            )
        }
    }
}

@Composable
fun SetName(contact: Contact) {
    Text(
        text = "${contact.name} ${contact.surname ?: ""}",
        style = MaterialTheme.typography.h6
    )
    Row (
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
fun SetImage(contact: Contact) {
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
fun SetInfoRow(title: String, info: String?) {
    if (info != null) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(end = 16.dp, top = 16.dp, start = 16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .weight(0.5F),
                text = title,
                style = MaterialTheme.typography.body1,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .weight(0.5F)
                    .padding(start = 16.dp),
                text = info,
                style = MaterialTheme.typography.body2
            )
        }
    }
}