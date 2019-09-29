package br.com.rafael.sodexo.presentation

import br.com.rafael.sodexo.presentation.movies.view.MoviesFragment
import br.com.rafael.sodexo.utill.Injector

class MainActivity : CoreActivity() {

    override fun fragment(): CoreFragment {
        return MoviesFragment.newInstance(Injector.getMoviesPresenterInstance())
    }


}
