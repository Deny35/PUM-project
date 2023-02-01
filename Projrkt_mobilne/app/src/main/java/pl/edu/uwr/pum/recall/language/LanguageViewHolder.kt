package pl.edu.uwr.pum.recall.language

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.recall.databinding.LanguageRecycleviewBinding
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

class  LanguageViewHolder(private val binding: LanguageRecycleviewBinding, private val viewModel: ViewModel) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: LanguageModel) {
        binding.languageText.text = item.language

        binding.delateButton.setOnClickListener{
            viewModel.delLangage(item)
        }
    }
}