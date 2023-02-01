package pl.edu.uwr.pum.recall.wordHolder.word

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.edu.uwr.pum.recall.databinding.WordItemViewBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

class WordAdapter (Comperator: WordComperator, private val viewModel: ViewModel) : ListAdapter<WordModel, WordViewHolder>(Comperator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            WordItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false), viewModel
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }

    public fun getItemAt(position: Int): WordModel {
        return getItem(position)
    }
}