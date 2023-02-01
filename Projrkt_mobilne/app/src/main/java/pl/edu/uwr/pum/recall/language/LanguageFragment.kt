package pl.edu.uwr.pum.recall.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.uwr.pum.recall.R
import pl.edu.uwr.pum.recall.databinding.FragmentLanguageBinding
import pl.edu.uwr.pum.recall.viewModel.ViewModel


class LanguageFragment : Fragment() {

    private lateinit var binding: FragmentLanguageBinding

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LanguageAdapter(LanguageComperator(), viewModel)
        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getAllLanguage.observe(viewLifecycleOwner, adapter::submitList)

        binding.addLanguageButton.setOnClickListener {
            findNavController().navigate(LanguageFragmentDirections.toAddLanguageFragment())
        }

    }
}