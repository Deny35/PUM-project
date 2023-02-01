package pl.edu.uwr.pum.recall.wordHolder.editWord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.edu.uwr.pum.recall.databinding.FragmentEditWordBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel


class EditWordFragment : Fragment() {
    private lateinit var binding: FragmentEditWordBinding
    private val viewModel: ViewModel by viewModels()
    val itemId: Int by lazy { requireArguments().getInt("id") }
    val itemStatus: Int by lazy { requireArguments().getInt("status") }
    val itemLang: String by lazy { requireArguments().getString("lang", "") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditWordBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUpdateWord(itemId).observe(viewLifecycleOwner, this::displayItem)

        binding.saveButton.setOnClickListener {
            updateToDatabase()
        }
    }
    private fun displayItem(item: WordModel){
        binding.word.setText(item.word)
        binding.translateWord.setText(item.translateWord)
    }

    private fun updateToDatabase() {

        val new = binding.word.text.toString()
        val newTranslate = binding.translateWord.text.toString()
        println(new)
        println(newTranslate)
        if (new.isNotEmpty() && newTranslate.isNotEmpty()){
            val item = WordModel(itemId, new, newTranslate, itemStatus, itemLang)
            viewModel.updateWord(item)
            findNavController().navigate(EditWordFragmentDirections.actionEditWordFragmentToWordHost(itemLang))
        } else{
            if (new.isEmpty()){
                binding.word.error = "Pole nie może puste!"
            }
            if ( newTranslate.isEmpty()){
                binding.translateWord.error = "Pole nie może puste!"
            }
            if (new.isEmpty() && newTranslate.isEmpty()){
                binding.word.error = "Pole nie może puste!"
                binding.translateWord.error = "Pole nie może puste!"
            }

        }
    }
}
