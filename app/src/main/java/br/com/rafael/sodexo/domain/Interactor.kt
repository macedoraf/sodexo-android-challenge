package br.com.rafael.sodexo.domain

import br.com.rafael.sodexo.utill.Either
import br.com.rafael.sodexo.utill.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [Interactor] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class Interactor<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        runBlocking {
            val job = async(Dispatchers.IO) { run(params) }
                .await()
            onResult(job)


        }


    }


    class None
}