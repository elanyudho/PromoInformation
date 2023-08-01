package com.example.core.di

import com.example.core.model.repository.PromoRepository
import com.example.core.model.usecase.GetPromosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    @ActivityScoped
    fun providePromosUseCase(repository: PromoRepository) = GetPromosUseCase(repository)

}

