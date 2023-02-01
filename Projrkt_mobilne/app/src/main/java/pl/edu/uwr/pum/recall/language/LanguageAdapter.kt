package pl.edu.uwr.pum.recall.language


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import pl.edu.uwr.pum.recall.databinding.LanguageRecycleviewBinding
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

class LanguageAdapter(languageComparator: LanguageComperator,   private val viewModel: ViewModel) : ListAdapter<LanguageModel, LanguageViewHolder>(languageComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(LanguageRecycleviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false), viewModel
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                LanguageFragmentDirections.toWordHost(item.language)
            )
        }
    }

    public fun getItemAt(position: Int): LanguageModel{
        return getItem(position)
    }
}