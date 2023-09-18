package com.example.tutorfinder.Model.Service.Module

import com.example.tutorfinder.Model.Service.AccountService
import com.example.tutorfinder.Model.Service.Impl.AccountServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds abstract fun provideAccountService(Impl: AccountServiceImpl): AccountService
}