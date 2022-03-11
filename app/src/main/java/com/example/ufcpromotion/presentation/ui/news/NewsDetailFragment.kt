package com.example.ufcpromotion.presentation.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.ufcpromotion.databinding.FragmentNewsDetailBinding
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.adapters.ViewModelFactory
import javax.inject.Inject


class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("NewsDetailFragment binding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: NewsViewModel

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
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
        val str = arguments?.getString("news")
        val news = str?.let { viewModel.getSelectedNews(it) }
        news?.observe(viewLifecycleOwner) {
            binding.textViewTitleNews.text = it.titleNews
            binding.textViewShortNews.text = it.shortNews
            binding.textViewBodyNews.text = it.bodyNews
            binding.imageViewImageNews.load(it.imageNews)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}