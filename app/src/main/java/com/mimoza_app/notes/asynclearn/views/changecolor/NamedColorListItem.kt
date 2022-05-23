package  com.mimoza_app.notes.asynclearn.views.changecolor

import  com.mimoza_app.notes.asynclearn.model.colors.NamedColor

/**
 * Represents list item for the color; it may be selected or not
 */
data class NamedColorListItem(
    val namedColor: NamedColor,
    val selected: Boolean
)