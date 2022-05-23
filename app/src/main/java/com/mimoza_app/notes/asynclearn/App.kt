package com.mimoza_app.notes.asynclearn


// Точка входа в наше приложение , не забудь занести в манифест , этот класс явдяется синглтон скоупом
// в этом классе мы создаем репозитории
import android.app.Application
import com.mimoza_app.notes.asynclearn.model.colors.InMemoryColorsRepository

class App:Application() {

    val models = listOf<Any>(
        InMemoryColorsRepository()
    )
}