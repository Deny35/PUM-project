package pl.edu.uwr.pum.recall.wordHolder.word


import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.recall.databinding.FragmentWordHostBinding
import pl.edu.uwr.pum.recall.databinding.WordItemViewBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel
import pl.edu.uwr.pum.recall.wordHolder.WordHostDirections

class WordViewHolder (private val binding: WordItemViewBinding, private val viewModel: ViewModel) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WordModel) {
        binding.oryginalText.text = item.word
        binding.translateText.text = item.translateWord

        binding.itemView.setOnClickListener {
            binding.itemView.findNavController().navigate(
                WordHostDirections.actionWordHostToEditWordFragment(
                    item.id,
                    item.status,
                    item.language
                )
            )
        }
        }
}