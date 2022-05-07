package com.example.besonapp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import com.example.besonapp.util.AnimationConstants.APP_EXPLAINING_TAPE_OFFSET_DELAY
import com.example.besonapp.util.AnimationConstants.APP_EXPLAINING_TAPE_OFFSET_DURATION
import com.example.besonapp.util.AppStaticTexts
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun FloatingAppExplainingStripComponent(
    isAnimated: Boolean = false
){

    val bottomNavigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars).calculateBottomPadding()

    val offsetAnimInitialValue = if(isAnimated) -400f else 0f
    val offsetAnim = remember { Animatable(offsetAnimInitialValue) }

    LaunchedEffect(key1 = Unit){
        if(isAnimated){
            offsetAnim.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(
                        delayMillis = APP_EXPLAINING_TAPE_OFFSET_DELAY,
                        durationMillis = APP_EXPLAINING_TAPE_OFFSET_DURATION
                    )
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = bottomNavigationBarPaddingValues + 28.dp).offset(x = Dp(offsetAnim.value)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = primaryColorNoTheme
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Default.DocumentScanner,
                    contentDescription = null,
                    tint = onPrimaryColorNoTheme
                )
                Text(
                    text = AppStaticTexts.APP_STATEMENT,
                    color = onPrimaryColorNoTheme,
                    style = MaterialTheme.typography.body2)
            }
        }
    }
}

