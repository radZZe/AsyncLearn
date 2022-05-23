package  com.mimoza_app.notes.asynclearn.views.base.currentcolor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  com.mimoza_app.notes.asynclearn.databinding.FragmentCurrentColorBinding
import  com.mimoza_app.notes.asynclearn.views.base.BaseFragment
import  com.mimoza_app.notes.asynclearn.views.base.BaseScreen
import  com.mimoza_app.notes.asynclearn.views.base.screenViewModel

class CurrentColorFragment : BaseFragment() {

    // no arguments for this screen
    class Screen : BaseScreen

    override val viewModel by screenViewModel<CurrentColorViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCurrentColorBinding.inflate(inflater, container, false)

        viewModel.currentColor.observe(viewLifecycleOwner) {
            binding.colorView.setBackgroundColor(it.value)
        }

        binding.changeColorButton.setOnClickListener {
            viewModel.changeColor()
        }

        return binding.root
    }


}