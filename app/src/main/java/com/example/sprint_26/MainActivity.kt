package com.example.sprint_26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDetails(contactExample1())
        }
    }

    @Composable
    private fun contactExample1() : Contact {
        return Contact(
            name = stringResource(R.string.name_example_1),
            surname = stringResource(R.string.surname_example_1),
            familyName = stringResource(R.string.family_name_example_1),
            imageRes = null,
            isFavorite = true,
            phone = stringResource(R.string.phone_example_1),
            address = stringResource(R.string.address_example_1),
            email = stringResource(R.string.email_example_1)
        )
    }

    @Composable
    private fun contactExample2() : Contact {
        return Contact(
            name = stringResource(R.string.name_example_2),
            surname = null,
            familyName = stringResource(R.string.family_name_example_2),
            imageRes = R.drawable.seagull,
            isFavorite = false,
            phone = stringResource(R.string.phone_example_2),
            address = stringResource(R.string.address_example_2),
            email = null
        )
    }

    @Preview( name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview1() {
        ContactDetails(contactExample1())
    }

    @Preview( name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview2() {
        ContactDetails(contactExample2())
    }
}