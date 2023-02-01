package pl.edu.uwr.pum.recall.language

import androidx.recyclerview.widget.DiffUtil
import pl.edu.uwr.pum.recall.model.LanguageModel

class LanguageComperator : DiffUtil.ItemCallback<LanguageModel>() {
    override fun areItemsTheSame(oldItem: LanguageModel, newItem: LanguageModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: LanguageModel, newItem: LanguageModel): Boolean {
        return oldItem.language == newItem.language
    }
}