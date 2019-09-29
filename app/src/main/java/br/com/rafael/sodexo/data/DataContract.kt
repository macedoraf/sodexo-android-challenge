package br.com.rafael.sodexo.data

import br.com.rafael.sodexo.domain.model.Movie
import br.com.rafael.sodexo.utill.Either
import br.com.rafael.sodexo.utill.Failure

interface DataContract {

    interface Cache
    
    interface Remote {

        fun getMovieTrending(): Either<Failure, List<Movie>>


    }
}