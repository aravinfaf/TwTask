package com.aravind.twmobileapp.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aravind.twmobileapp.data.model.ContentModel
import com.aravind.twmobileapp.data.model.Data
import com.aravind.twmobileapp.databinding.FragmentMovieListBinding
import com.aravind.twmobileapp.ui.view.adapter.MovieListAdapter
import com.aravind.twmobileapp.ui.viewmodel.MovieListViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private var binding : FragmentMovieListBinding? = null
    private val viewmodel : MovieListViewmodel by viewModels()
    lateinit var adapter : MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.mMovieList.observe(viewLifecycleOwner,onMovieListObserver)
        viewmodel.getMovieList()
    }

    private val onMovieListObserver = Observer<Data>{
        it.let {
            binding?.apply {
                moviesRecyclerview?.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
                adapter = MovieListAdapter(it.data.cardList,
                movieListClickListener = object : MovieListAdapter.MovieListClickListener{
                    override fun onMovieClicked(movieListModel: ContentModel?) {
                        findNavController().navigate(
                            MovieListFragmentDirections.movieDetailListFragment(
                                movieListModel?.title,
                                movieListModel?.movie_logo,
                                movieListModel?.description
                            )
                        )
                    }
                })
                moviesRecyclerview.adapter = adapter
            }
        }
    }
}