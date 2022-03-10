package com.example.ufcpromotion.presentation.ui.fights

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ufcpromotion.databinding.FragmentFixturesBinding
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.adapters.FixturesAdapter
import com.example.ufcpromotion.presentation.adapters.ViewModelFactory
import javax.inject.Inject


class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null
    private val binding
        get() = _binding
            ?: throw RuntimeException("${FixturesFragment::class.qualifiedName} _binding is null")

    private val component by lazy {
        (requireActivity().application as UfcApp).component
    }

    private lateinit var viewModel: FightsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var fixturesAdapter: FixturesAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FightsViewModel::class.java]
        val rvFixtures = binding.recyclerViewFixtures

        viewModel.getFixturesData.observe(viewLifecycleOwner) {
            fixturesAdapter.submitList(it)
            rvFixtures.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = fixturesAdapter
                setHasFixedSize(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}