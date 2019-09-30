package br.com.rafael.sodexo.presentation.movies.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rafael.sodexo.R
import br.com.rafael.sodexo.presentation.CoreFragment
import br.com.rafael.sodexo.presentation.movies.MoviesContract
import br.com.rafael.sodexo.presentation.movies.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : CoreFragment(), MoviesContract.View {

    lateinit var presenter: MoviesContract.Presenter

    private val listMovie by lazy { ArrayList<String>() }
    private val adapterMovie by lazy { MovieAdapter(listMovie) }

    override fun updateMoviesList(movies: List<String>) {
        adapterMovie.updateAll(movies)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapterMovie

    }

    override fun onStart() {
        super.onStart()
        presenter.fetchMovies()
    }

    override fun layoutId(): Int = R.layout.movies_fragment

    companion object {
        fun newInstance(presenter: MoviesContract.Presenter): MoviesFragment {
            val fragment = MoviesFragment()
            presenter.attachView(fragment)
            fragment.presenter = presenter
            return fragment
        }
    }
}