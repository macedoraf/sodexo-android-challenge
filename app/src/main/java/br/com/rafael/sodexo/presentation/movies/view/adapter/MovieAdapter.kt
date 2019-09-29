package br.com.rafael.sodexo.presentation.movies.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rafael.sodexo.R

class MovieAdapter(private val list: ArrayList<String>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_movie_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateAll(movies: List<String>) {
        list.clear()
        list.addAll(movies)
    }

    class MovieHolder(
        view: View,
        private val lblTitle: TextView =
            view.findViewById(R.id.adapter_movie_lbl_title)
    ) : RecyclerView.ViewHolder(view) {

        fun bind(title: String) {
            this.lblTitle.text = title
        }
    }
}


