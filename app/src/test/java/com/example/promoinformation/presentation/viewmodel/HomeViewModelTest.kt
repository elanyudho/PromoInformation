package com.example.promoinformation.presentation.viewmodel

import com.example.core.abstraction.UseCase
import com.example.core.dispatcher.DispatcherProvider
import com.example.core.model.model.Promo
import com.example.core.model.usecase.GetPromosUseCase
import com.example.core.util.exception.Failure
import com.example.core.util.vo.Either
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    // The TestCoroutineDispatcher will be used to control the execution of coroutines in the test
    private val testDispatcher = TestCoroutineDispatcher()

    // The class under test
    private lateinit var homeViewModel: HomeViewModel

    // Mocked dependencies
    @Mock
    private lateinit var dispatcherProvider: DispatcherProvider

    @Mock
    private lateinit var getPromosUseCase: GetPromosUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        // Set up the mocked dispatcherProvider to return the testDispatcher
        Mockito.`when`(dispatcherProvider.io).thenReturn(testDispatcher)
        Mockito.`when`(dispatcherProvider.main).thenReturn(testDispatcher)

        // Create the HomeViewModel with the mocked dependencies
        homeViewModel = HomeViewModel(dispatcherProvider, getPromosUseCase)
    }

    @Test
    fun `getPromos should emit Loading and then Success state when use case returns data`() = runTest(){
        // Given
        val dummyData = listOf(Promo("BNI", "Ayo Pakai Promo","Pejompongan","https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/bni_credit_card_apply_kk_via_mobile_small_e1e8aaf172.jpg", "2021-04-13"), Promo("BNI", "Ayo Pakai Promo","Pejompongan","https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/bni_credit_card_apply_kk_via_mobile_small_e1e8aaf172.jpg", "2021-04-13"))
        val successEither: Either<Failure, List<Promo>> = Either.Success(dummyData)

        Mockito.`when`(getPromosUseCase.run(UseCase.None)).thenReturn(successEither)

        // The first state should be Loading
        assert(homeViewModel.uiState.value is HomeViewModel.MainUiState.Loading)

        // When
        homeViewModel.getPromos()

        // Advance the TestCoroutineDispatcher to execute coroutines
        testDispatcher.scheduler.advanceUntilIdle()

        // The next state should be Success with the mockPromos data
        val successState = homeViewModel.uiState.value as HomeViewModel.MainUiState.Success

        assert(successState.data == dummyData)
    }
}
