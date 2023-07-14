package com.example.snoh.di

import android.content.Context
import androidx.room.Room
import com.example.snoh.data.database.TheProjectDatabase
import com.example.snoh.util.PROJECT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule
{
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context:Context) =
        Room.databaseBuilder(context, TheProjectDatabase::class.java, PROJECT_DATABASE).build()


    @Singleton
    @Provides
    fun provideYourDao(db:TheProjectDatabase) = db.getDao()
}