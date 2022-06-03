package com.aravind.twmobileapp.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.aravind.twmobileapp.databinding.FragmentMovieDetailInfoBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailInforFragment : Fragment() {

    private val navArgs : MovieDetailInforFragmentArgs by navArgs()
    private var binding : FragmentMovieDetailInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailInfoBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            titleTextView.text = navArgs.title
            Glide.with(requireActivity()).load(
                navArgs.imageUrl
            ).into(movieImagView)
            descriptiontextview.text = navArgs.description
        }
    }
}