package com.mimoza_app.notes.asynclearn.model.colors

import com.mimoza_app.notes.asynclearn.model.Repository
typealias ColorListener = (NamedColor) -> Unit

interface ColorsRepository:Repository {
    var currentColor:NamedColor

    fun getAvailableColors():List<NamedColor>
    fun getById(id:Long):NamedColor
    fun addListener(listener:ColorListener)
    fun removeListener(listener:ColorListener)
}