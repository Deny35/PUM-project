package pl.edu.uwr.pum.recall.wordHolder.picture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.recall.R
import pl.edu.uwr.pum.recall.databinding.FragmentPictureBinding
import pl.edu.uwr.pum.recall.databinding.FragmentUnknownWordBinding
import pl.edu.uwr.pum.recall.viewModel.ViewModel
import pl.edu.uwr.pum.recall.wordHolder.WordHostDirections
import pl.edu.uwr.pum.recall.wordHolder.word.WordAdapter
import pl.edu.uwr.pum.recall.wordHolder.word.WordComperator


class PictureFragment(val language: String) : Fragment() {
    private lateinit var binding: FragmentPictureBinding

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(language)
        val adapter =  PictureAdapter(PictureComperator(), viewModel)
        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getWard(language, 2).observe(viewLifecycleOwner, adapter::submitList)
        swipeToDelete(adapter)

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(WordHostDirections.actionWordHostToAddPictureFragment(language))
        }
    }

    private fun swipeToDelete(adapter: PictureAdapter) {
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


}