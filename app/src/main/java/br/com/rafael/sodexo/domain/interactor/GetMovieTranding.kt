package br.com.rafael.sodexo.domain.interactor

import br.com.rafael.sodexo.data.DataContract
import br.com.rafael.sodexo.domain.model.Movie
import br.com.rafael.sodexo.utill.Either
import br.com.rafael.sodexo.utill.Failure
import br.com.rafael.sodexo.domain.Interactor

class GetMovieTranding(
    private val remote: DataContract.Remote
) : Interactor<List<Movie>, Interactor.None>() {


    override suspend fun run(params: None): Either<Failure, List<Movie>>{
        return remote.getMovieTrending()
    }
}