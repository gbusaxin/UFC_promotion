package com.example.ufcpromotion.presentation.ui.fights

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ufcpromotion.databinding.FragmentFightsBinding
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.adapters.MyViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class FightsFragment : Fragment() {

    private var _binding: FragmentFightsBinding? = null
    private val binding
        get() = _binding
            ?: throw RuntimeException("${FightsFragment::class.qualifiedName} _binding is null")

    lateinit var myViewPagerAdapter: MyViewPagerAdapter

    private val component by lazy {
        (requireActivity().application as UfcApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFightsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.fightsViewPager
        val tabLayout = binding.fightsTabLayout
        myViewPagerAdapter = MyViewPagerAdapter(childFragmentManager,lifecycle)

        val viewPagerList = listOf(
            ResultsFragment(),
            FixturesFragment()
        )

        myViewPagerAdapter.list = viewPagerList
        viewPager.adapter = myViewPagerAdapter

        setTabLayoutMediator(tabLayout, viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setTabLayoutMediator(tabLayout: TabLayout, viewPager: ViewPager2) {
        val namesOfTabs = listOf(
            "Результаты",
            "Скоро"
        )
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = namesOfTabs[position]
        }.attach()
    }
}