package com.example.ufcpromotion.presentation.ui.fights

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ufcpromotion.databinding.FragmentResultsBinding
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.adapters.ResultAdapter
import com.example.ufcpromotion.presentation.adapters.ViewModelFactory
import javax.inject.Inject


class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding
        get() = _binding
            ?: throw RuntimeException("${ResultsFragment::class.qualifiedName} _binding is null")

    private lateinit var viewModel: FightsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var resultAdapter: ResultAdapter

    private val component by lazy {
        (requireActivity().application as UfcApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FightsViewModel::class.java]
        val rvResults = binding.recyclerViewResults

        viewModel.getResultsData.observe(viewLifecycleOwner) {
            resultAdapter.submitList(it)
            Log.d("CHECH_RES",it.toString())
            rvResults.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = resultAdapter
                setHasFixedSize(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}