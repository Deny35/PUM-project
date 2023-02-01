package pl.edu.uwr.pum.recall.wordHolder.picture


import android.net.Uri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.recall.databinding.PictureItemViewBinding
import pl.edu.uwr.pum.recall.databinding.WordItemViewBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel
import pl.edu.uwr.pum.recall.wordHolder.WordHostDirections

class PictureViewHolder (private val binding: PictureItemViewBinding, private val viewModel: ViewModel) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WordModel) {
        binding.rcImageView.setImageURI(Uri.parse(item.word))
        binding.textViewTitle.text = item.translateWord

        binding.itemView.setOnClickListener {
            binding.itemView.findNavController().navigate(
                WordHostDirections.actionWordHostToPictureDetailFragment(
                    item.id
                )
            )
        }
    }
}