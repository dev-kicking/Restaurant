package com.devkick.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PageableLazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    shouldStartPaginate: () -> Unit,
    totalCount: Int = 0,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyListScope.() -> Unit,
) {
    fun isStartPaginate(): Boolean {
        return (state.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -9) >= (state.layoutInfo.totalItemsCount - 3) && totalCount > 3
    }

    val shouldPaginate = isStartPaginate()

    LaunchedEffect(shouldPaginate) {
        if (shouldPaginate) {
            shouldStartPaginate()
        }
    }

    LazyColumn(
        verticalArrangement = verticalArrangement,
        state = state,
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        content()
    }
}