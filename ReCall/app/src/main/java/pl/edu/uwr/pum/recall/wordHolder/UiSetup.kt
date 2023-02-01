package pl.edu.uwr.pum.recall.wordHolder

import android.content.Context
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import pl.edu.uwr.pum.recall.R

private val tabTitles = listOf(R.string.do_nauczenia, R.string.nauczone, R.string.zdjecia)


fun tabLayoutSetup(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    setupTabLayoutMediator(context, tabLayout, viewPager2)
    val vg = tabLayout.getChildAt(0) as ViewGroup

}

private fun setupTabLayoutMediator(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.text = context.getString(tabTitles[position])

    }.attach()
}

