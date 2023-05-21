package com.vimalcvs.comicsappcompose.di

import android.content.Context
import androidx.room.Room
import com.vimalcvsvsvsvs.comicsappcompose.model.api.ApiService
import com.vimalcvs.comicsappcompose.model.connectivity.ConnectivityMonitor
import com.vimalcvs.comicsappcompose.model.db.CharacterDao
import com.vimalcvs.comicsappcompose.model.db.CollectionDb
import com.vimalcvs.comicsappcompose.model.db.CollectionDbRepoImpl
import com.vimalcvs.comicsappcompose.model.db.Constants.DB
import com.vimalcvs.comicsappcompose.model.db.NoteDao
import com.vimalcvs.comicsappcompose.repository.CollectionDbRepo
import com.vimalcvs.comicsappcompose.repository.MarvelApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object HiltModule {
    @Provides
    fun provideMarvelApiRepository() = MarvelApiRepository(ApiService.api)

    @Provides
    fun provideCollectionDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CollectionDb::class.java, DB).build()

    @Provides
    fun provideCharacterDao(collectionDb: CollectionDb) = collectionDb.characterDao()

    @Provides
    fun provideNoteDao(collectionDb: CollectionDb) = collectionDb.noteDao()

    @Provides
    fun provideDbRepoImpl(characterDao: CharacterDao, noteDao: NoteDao): CollectionDbRepo =
        CollectionDbRepoImpl(characterDao, noteDao)

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context) =
        ConnectivityMonitor.getInstance(context)
}