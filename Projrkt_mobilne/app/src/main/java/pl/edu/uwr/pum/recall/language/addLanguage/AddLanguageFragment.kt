package pl.edu.uwr.pum.recall.language.addLanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.edu.uwr.pum.recall.R
import pl.edu.uwr.pum.recall.databinding.FragmentAddLanguageBinding
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

class AddLanguageFragment : Fragment() {
    private lateinit var binding: FragmentAddLanguageBinding
    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            insertToDatabase()
        }
    }

    private fun insertToDatabase() {
        val name = binding.nameEditText.text.toString()
        if (name.isNotEmpty()){
            val item = LanguageModel(0, name)
            viewModel.addLanguage(item)
            findNavController().navigate(AddLanguageFragmentDirections.toLanguageFragmentFromAddLanguage())
        } else{
            binding.nameEditText.error = "Podaj język"

        }
    }
}