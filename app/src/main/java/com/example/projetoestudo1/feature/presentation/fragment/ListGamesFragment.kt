package com.example.projetoestudo1.feature.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoestudo1.databinding.FragmentGamesBinding
import com.example.projetoestudo1.feature.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListGamesFragment : BaseFragment() {

    private var _binding: FragmentGamesBinding? = null
    private val binding: FragmentGamesBinding get() = _binding!!

    private val viewModel by viewModel<GamesViewModel>()

    private val adapter by lazy {
        context?.let {
            GamesAdapter(context = it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        binding.recyclerGames.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ListGamesFragment.adapter
        }
    }

    private fun initObserver() {
        viewModel.getListGames()
        viewModel.getGameList.observe(viewLifecycleOwner, {response ->
            response.let { games ->
                adapter?.append(games)
            }
        })
    }
}
