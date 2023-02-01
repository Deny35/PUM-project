package pl.edu.uwr.pum.recall.wordHolder.picture_detail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.edu.uwr.pum.recall.R
import pl.edu.uwr.pum.recall.databinding.FragmentEditWordBinding
import pl.edu.uwr.pum.recall.databinding.FragmentPictureDetailBinding
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.viewModel.ViewModel


class PictureDetailFragment : Fragment() {
    private lateinit var binding: FragmentPictureDetailBinding
    private val viewModel: ViewModel by viewModels()
    val itemId: Int by lazy { requireArguments().getInt("id") }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUpdateWord(itemId).observe(viewLifecycleOwner, this::displayItem)

    }
    private fun displayItem(item: WordModel){
        binding.imageView.setImageURI(Uri.parse(item.word))
    }

}