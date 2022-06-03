package com.aravind.twmobileapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aravind.twmobileapp.R
import com.aravind.twmobileapp.data.model.ContentModel
import com.aravind.twmobileapp.data.model.MoviesModel
import com.aravind.twmobileapp.databinding.AdapterMovieListBinding
import com.bumptech.glide.Glide

class MovieListAdapter(
    private val movielist: List<MoviesModel>,
    private val movieListClickListener: MovieListAdapter.MovieListClickListener
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

   inner class ViewHolder(private val binding: AdapterMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieListModel: MoviesModel) {
            binding.titleTextView.text = movieListModel.content?.title
            Glide.with(binding.movieImageview.context)
                .load(movieListModel.content?.movie_logo)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.movieImageview)

            binding.movieImageview.setOnClickListener {
                movieListClickListener.onMovieClicked(movieListModel.content)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {

        return ViewHolder(AdapterMovieListBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
        holder.bind(movielist[position])
    }

    override fun getItemCount(): Int = movielist.size

    interface MovieListClickListener {
        fun onMovieClicked(movieListModel: ContentModel?)
    }
}
