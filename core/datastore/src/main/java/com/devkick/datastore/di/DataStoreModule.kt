package com.devkick.datastore.di

import android.content.Context
import androidx.room.Room
import com.devkick.datastore.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    private const val PREFERENCE_APP_KEY: String = "RESTAURANT_PREFERENCE"

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room
        .databaseBuilder(
            context,
            AppDatabase::class.java,
            PREFERENCE_APP_KEY
        )
        .build()
}
