package pl.edu.uwr.pum.recall.wordHolder.word

import androidx.recyclerview.widget.DiffUtil
import pl.edu.uwr.pum.recall.model.WordModel

class WordComperator : DiffUtil.ItemCallback<WordModel>() {
    override fun areItemsTheSame(oldItem: WordModel, newItem: WordModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: WordModel, newItem: WordModel): Boolean {
        return oldItem.language == newItem.language
    }
}