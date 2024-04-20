package com.youcef_bounaas.cryptojam.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youcef_bounaas.cryptojam.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic
        )
    }
}