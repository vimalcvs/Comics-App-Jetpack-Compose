package com.vimalcvs.comicsappcompose.repository


import com.vimalcvs.comicsappcompose.model.db.DbCharacter
import com.vimalcvs.comicsappcompose.model.db.DbNote
import kotlinx.coroutines.flow.Flow

interface CollectionDbRepo {
    suspend fun getCharactersFromRepo(): Flow<List<DbCharacter>>

    suspend fun getCharacterFromRepo(characterId: Int): Flow<DbCharacter>

    suspend fun addCharacterToRepo(character: DbCharacter)

    suspend fun updateCharacterInRepo(character: DbCharacter)

    suspend fun deleteCharacterFromRepo(character: DbCharacter)


    suspend fun getAllNotes(): Flow<List<DbNote>>

    suspend fun getNotesFromRepo(characterId: Int): Flow<List<DbNote>>

    suspend fun addNoteToRepo(note: DbNote)

    suspend fun updateNoteInRepo(note: DbNote)

    suspend fun deleteNoteFromRepo(note: DbNote)

    suspend fun deleteAllNotes(character: DbCharacter)
}