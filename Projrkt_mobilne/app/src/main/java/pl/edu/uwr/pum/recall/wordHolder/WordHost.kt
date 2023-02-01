package pl.edu.uwr.pum.recall.wordHolder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import pl.edu.uwr.pum.recall.MainActivity
import pl.edu.uwr.pum.recall.R
import pl.edu.uwr.pum.recall.databinding.ActivityMainBinding
import pl.edu.uwr.pum.recall.databinding.FragmentWordHostBinding
import pl.edu.uwr.pum.recall.language.LanguageFragmentDirections
import pl.edu.uwr.pum.recall.wordHolder.word.KnownWordFragment
import pl.edu.uwr.pum.recall.wordHolder.picture.PictureFragment
import pl.edu.uwr.pum.recall.wordHolder.word.UnknownWordFragment

class WordHost : Fragment() {
    //private lateinit var binding: FragmentWordHostBinding
    private lateinit var binding: FragmentWordHostBinding

     val itemLang: String by lazy { requireArguments().getString("lang", "") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordHostBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = FinanceAdapter(this@WordHost, itemLang)
        println(itemLang)
        tabLayoutSetup(requireContext(),  binding.tabLayout, binding.viewPager)

        binding.backToLanguage.setOnClickListener {
            findNavController().navigate(WordHostDirections.actionWordHostToLanguageFragment())
        }
    }
    class FinanceAdapter(fragmentActivity: Fragment, a: String) : FragmentStateAdapter(fragmentActivity) {

        private val fragments = listOf(UnknownWordFragment(a), KnownWordFragment(a), PictureFragment(a))
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}