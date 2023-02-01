 package pl.edu.uwr.pum.recall.wordHolder.addWord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.edu.uwr.pum.recall.databinding.FragmentAddWordBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel

 class AddWordFragment : Fragment() {
    private lateinit var binding: FragmentAddWordBinding
    private val viewModel: ViewModel by viewModels()
     val itemLang: String by lazy { requireArguments().getString("lang", "") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddWordBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView3.text =  itemLang.toString() + " :"
        binding.textView4.text =  "polski :"

        binding.saveButton.setOnClickListener {
            println("Click")
            insertToDatabase()
        }
    }

    private fun insertToDatabase() {
        val new = binding.newWord.text.toString()
        val newTranslate = binding.newTranslateWord.text.toString()
        if (new.isNotEmpty() && newTranslate.isNotEmpty()){
            val item = WordModel(0, new, newTranslate, 0, itemLang)
            viewModel.addWord(item)
            findNavController().navigate(AddWordFragmentDirections.actionAddWordFragmentToWordHost(itemLang))
        } else{
            if (new.isEmpty()){
                binding.newWord.error = "Pole nie może puste!"
            }
            if ( newTranslate.isEmpty()){
                binding.newTranslateWord.error = "Pole nie może puste!"
            }
            if (new.isEmpty() && newTranslate.isEmpty()){
                binding.newWord.error = "Pole nie może puste!"
                binding.newTranslateWord.error = "Pole nie może puste!"
            }

        }
    }
}