package pl.edu.uwr.pum.recall.wordHolder.picture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.edu.uwr.pum.recall.databinding.PictureItemViewBinding
import pl.edu.uwr.pum.recall.databinding.WordItemViewBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

class PictureAdapter (Comperator: PictureComperator, private val viewModel: ViewModel) : ListAdapter<WordModel, PictureViewHolder>(Comperator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(
            PictureItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false), viewModel
        )
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }

    public fun getItemAt(position: Int): WordModel {
        return getItem(position)
    }
}