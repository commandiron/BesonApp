package com.example.besonapp.presentation.common_components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import kotlin.math.max
import kotlin.math.roundToInt

@Composable
fun RowScope.CustomBottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
) {
    val styledLabel: @Composable (() -> Unit)? = label?.let {
        @Composable {
            val style = MaterialTheme.typography.caption.copy(textAlign = TextAlign.Center)
            ProvideTextStyle(style, content = label)
        }
    }
    // The color of the Ripple should always the selected color, as we want to show the color
    // before the item is considered selected, and hence before the new contentColor is
    // provided by BottomNavigationTransition.
    val ripple = rememberRipple(bounded = false, color = selectedContentColor)

    Box(
        modifier
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null //Changed line.
            )
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {

        BottomNavigationTransition(
            selectedContentColor,
            unselectedContentColor,
            selected
        ) { animationProgressFromTransition, iconBackGroundAnimationProgressFromTransition ->
            val animationProgress = if (alwaysShowLabel) 1f else animationProgressFromTransition

            val iconBackGroundAnimationProgress = if (alwaysShowLabel) 1f else iconBackGroundAnimationProgressFromTransition

            BottomNavigationItemBaselineLayout(
                selected = selected,
                icon = icon,
                label = styledLabel,
                iconPositionAnimationProgress = animationProgress,
                iconBackGroundAnimationProgress = iconBackGroundAnimationProgress
            )
        }


    }
}

private val BottomNavigationAnimationSpec = TweenSpec<Float>(
    durationMillis = 300,
    easing = FastOutSlowInEasing
)

private val IconBackGroundAnimationSpec = TweenSpec<Float>(
    durationMillis = 300,
    easing = FastOutSlowInEasing
)

@Composable
private fun BottomNavigationTransition(
    activeColor: Color,
    inactiveColor: Color,
    selected: Boolean,
    content: @Composable (animationProgress: Float, iconBackGroundAnimationSpec: Float) -> Unit
) {
    val animationProgress by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = BottomNavigationAnimationSpec
    )

    val iconBackGroundAnimationProgress by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = IconBackGroundAnimationSpec
    )

    val color = lerp(inactiveColor, activeColor, animationProgress)

    CompositionLocalProvider(
        LocalContentColor provides color.copy(alpha = 1f),
        LocalContentAlpha provides color.alpha,
    ) {
        content(animationProgress, iconBackGroundAnimationProgress)
    }
}

private val BottomNavigationItemHorizontalPadding = 12.dp

@Composable
private fun BottomNavigationItemBaselineLayout(
    selected: Boolean,
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)?,
    /*@FloatRange(from = 0.0, to = 1.0)*/
    iconPositionAnimationProgress: Float,
    iconBackGroundAnimationProgress: Float
) {
    Layout(
        {

            Box(
                modifier = Modifier
                    .layoutId("icon")
                    .padding(horizontal = BottomNavigationItemHorizontalPadding),
                contentAlignment = Alignment.Center
            ) {

//                if(selected){
//                    Surface(
//                        modifier = Modifier
//                            .alpha(iconBackGroundAnimationProgress)
//                            .size(30.dp),
//                        shape = CircleShape,
//                        color = primaryColorNoTheme
//                    ) {}
//                }

                icon()
            }
            if (label != null) {
                Box(
                    Modifier
                        .layoutId("label")
                        .alpha(iconPositionAnimationProgress)
                        .padding(horizontal = BottomNavigationItemHorizontalPadding)
                ) { label() }
            }




        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)

        val labelPlaceable = label?.let {
            measurables.first { it.layoutId == "label" }.measure(
                // Measure with loose constraints for height as we don't want the label to take up more
                // space than it needs
                constraints.copy(minHeight = 0)
            )
        }

        // If there is no label, just place the icon.
        if (label == null) {
            placeIcon(
                iconPlaceable,
                constraints,
                iconPositionAnimationProgress
            )
        } else {
            placeLabelAndIcon(
                labelPlaceable!!,
                iconPlaceable,
                constraints,
                iconPositionAnimationProgress
            )
        }
    }
}

private fun MeasureScope.placeIcon(
    iconPlaceable: Placeable,
    constraints: Constraints,
    iconPositionAnimationProgress: Float
): MeasureResult {
    val height = constraints.maxHeight
    val iconY = (height - iconPlaceable.height) / 4

    val baselineOffset = CombinedItemTextBaseline.roundToPx()
    val unselectedIconY = (height - iconPlaceable.height) / 2
    val selectedIconY = height - (baselineOffset * 2) - iconPlaceable.height
    val iconDistance = unselectedIconY - selectedIconY
    val offset = (iconDistance * (1 - iconPositionAnimationProgress)).roundToInt()

    return layout(iconPlaceable.width, height) {
        iconPlaceable.placeRelative(0, iconY + offset)
    }
}

private val CombinedItemTextBaseline = 12.dp

private fun MeasureScope.placeLabelAndIcon(
    labelPlaceable: Placeable,
    iconPlaceable: Placeable,
    constraints: Constraints,
    /*@FloatRange(from = 0.0, to = 1.0)*/
    iconPositionAnimationProgress: Float
): MeasureResult {
    val height = constraints.maxHeight

    // have a better strategy than overlapping the icon and label
    val baseline = labelPlaceable[LastBaseline]

    val baselineOffset = CombinedItemTextBaseline.roundToPx()

    // Label should be [baselineOffset] from the bottom
    val labelY = height - baseline - baselineOffset

    val unselectedIconY = (height - iconPlaceable.height) / 2

    // Icon should be [baselineOffset] from the text baseline, which is itself
    // [baselineOffset] from the bottom
    val selectedIconY = height - (baselineOffset * 2) - iconPlaceable.height

    val containerWidth = max(labelPlaceable.width, iconPlaceable.width)

    val labelX = (containerWidth - labelPlaceable.width) / 2
    val iconX = (containerWidth - iconPlaceable.width) / 2

    // How far the icon needs to move between unselected and selected states
    val iconDistance = unselectedIconY - selectedIconY

    // When selected the icon is above the unselected position, so we will animate moving
    // downwards from the selected state, so when progress is 1, the total distance is 0, and we
    // are at the selected state.
    val offset = (iconDistance * (1 - iconPositionAnimationProgress)).roundToInt()

    return layout(containerWidth, height) {
        if (iconPositionAnimationProgress != 0f) {
            labelPlaceable.placeRelative(labelX, labelY + offset)
        }
        iconPlaceable.placeRelative(iconX, selectedIconY + offset)
    }
}
