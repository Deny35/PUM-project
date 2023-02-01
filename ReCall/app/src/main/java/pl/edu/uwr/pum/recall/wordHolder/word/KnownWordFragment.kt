package pl.edu.uwr.pum.recall.wordHolder.word

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.recall.databinding.FragmentKnownWordBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel


class KnownWordFragment (val language: String) : Fragment() {
    private lateinit var binding: FragmentKnownWordBinding

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKnownWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(language)
        val adapter = WordAdapter(WordComperator(), viewModel)
        binding.listRecyclerView.adapter = adapter
        binding.oryginalText.text = language
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getWard(language, 1).observe(viewLifecycleOwner, adapter::submitList)
        swipeToDelete(adapter)
        swipeToUpdate(adapter)
    }

    private fun swipeToDelete(adapter: WordAdapter) {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT //or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.delWord(adapter.getItemAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(binding.listRecyclerView)
    }

    private fun swipeToUpdate(adapter: WordAdapter) {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val word = WordModel(adapter.getItemAt(viewHolder.adapterPosition).id, adapter.getItemAt(viewHolder.adapterPosition).word,adapter.getItemAt(viewHolder.adapterPosition).translateWord,0, adapter.getItemAt(viewHolder.adapterPosition).language)
                viewModel.updateWord(word)
            }
        }).attachToRecyclerView(binding.listRecyclerView)
    }
}