package br.com.rafael.sodexo.domain.interactor

import br.com.rafael.sodexo.data.Repository
import br.com.rafael.sodexo.domain.Interactor
import br.com.rafael.sodexo.utill.Either
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


class GetMovieTrandingTest {


    private lateinit var getMovieTranding: GetMovieTranding

    private lateinit var repository: Repository.Remote

    @Before
    fun setUp() {
        repository = mock {  }
        getMovieTranding = GetMovieTranding(repository)
        given { repository.getMovieTrending() }.willReturn(Either.Right(listOf()))
    }

    @Test
    fun load_movies_should_update() {
        runBlocking { getMovieTranding.run(Interactor.None()) }
        verify(repository).getMovieTrending()
        verifyNoMoreInteractions(repository)
    }
}