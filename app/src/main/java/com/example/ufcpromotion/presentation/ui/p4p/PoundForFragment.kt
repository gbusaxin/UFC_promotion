package com.example.ufcpromotion.presentation.ui.p4p

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ufcpromotion.databinding.FragmentPoundForBinding
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.adapters.P4pAdapter
import com.example.ufcpromotion.presentation.adapters.ViewModelFactory
import javax.inject.Inject

class PoundForFragment : Fragment() {

    private var _binding: FragmentPoundForBinding? = null
    private val binding get() = _binding!!

    private val component by lazy {
        (requireActivity().application as UfcApp).component
    }

    private lateinit var viewModel: PoundForViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var p4pAdapter: P4pAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPoundForBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[PoundForViewModel::class.java]
        val rvPoundFor = binding.recyclerViewP4p
        viewModel.getP4pData.observe(viewLifecycleOwner) {
            p4pAdapter.submitList(it)
            rvPoundFor.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = p4pAdapter
                setHasFixedSize(true)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}