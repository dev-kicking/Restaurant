package com.devkick.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devkick.main.MainTab
import com.devkick.resource.R
import kotlinx.collections.immutable.PersistentList

@Composable
internal fun MainBottomNavigation(
    modifier: Modifier = Modifier,
    tabs: PersistentList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(colorResource(R.color.white))
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tabs.forEach { destination ->
            val selected = currentTab == destination
            BottomNavigationItem(
                destination = destination,
                selected = selected,
                onTabSelected = onTabSelected
            )
        }
    }
}

@Composable
private fun RowScope.BottomNavigationItem(
    destination: MainTab,
    selected: Boolean,
    onTabSelected: (MainTab) -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                indication = null,
                role = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onTabSelected(destination) }
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(
                id = destination.icon
            ),
            contentDescription = destination.route.toString(),
            modifier = Modifier.size(24.dp),
            tint = if (selected) {
                colorResource(R.color.black)
            } else {
                colorResource(R.color.gray)
            }
        )
    }
}