package com.example.e_commerceapp.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginText(textContent:String,textSize:Int,bold:Boolean,modifier: Modifier? = null,color: Color? = null){

    Text(
        text = textContent,
        fontSize = textSize.sp,
        fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
        color = color ?: Color.White,
        modifier = if (modifier==null) Modifier.padding(start = 12.dp) else modifier
    )
}