package  com.mimoza_app.notes.asynclearn.views.base.currentcolor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import  com.mimoza_app.notes.asynclearn.R
import  com.mimoza_app.notes.asynclearn.model.colors.ColorListener
import  com.mimoza_app.notes.asynclearn.model.colors.ColorsRepository
import  com.mimoza_app.notes.asynclearn.model.colors.NamedColor
import  com.mimoza_app.notes.asynclearn.views.Navigator
import  com.mimoza_app.notes.asynclearn.views.UiActions
import  com.mimoza_app.notes.asynclearn.views.base.BaseViewModel
import  com.mimoza_app.notes.asynclearn.views.changecolor.ChangeColorFragment

class CurrentColorViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
    private val colorsRepository: ColorsRepository
) : BaseViewModel() {

    private val _currentColor = MutableLiveData<NamedColor>()
    val currentColor: LiveData<NamedColor> = _currentColor

    private val colorListener: ColorListener = {
        _currentColor.postValue(it)
    }

    // --- example of listening results via model layer

    init {
        colorsRepository.addListener(colorListener)
    }

    override fun onCleared() {
        super.onCleared()
        colorsRepository.removeListener(colorListener)
    }

    // --- example of listening results directly from the screen

    override fun onResult(result: Any) {
        super.onResult(result)
        if (result is NamedColor) {
            val message = uiActions.getString(R.string.changed_color, result.name)
            uiActions.toast(message)
        }
    }

    // ---

    fun changeColor() {
        val currentColor = currentColor.value ?: return
        val screen = ChangeColorFragment.Screen(currentColor.id)
        navigator.launch(screen)
    }

}