package pl.edu.uwr.pum.recall.data

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.model.WordModel


@Dao
interface ItemDuo {

    @Transaction
    @Query("SELECT * FROM LanguageModel ORDER BY language ASC")
    fun getAllLanguages(): LiveData<List<LanguageModel>>

    @Transaction
    @Query("SELECT * FROM WordModel WHERE language = :language  AND status = :status ORDER BY word ASC")
    fun getWard(language: String, status: Int): LiveData<List<WordModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLanguage(language: LanguageModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addWord(language: WordModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateItem(item: WordModel)

    @Delete
    suspend fun delLangage(item: LanguageModel)

    @Delete
    suspend fun delWord(item: WordModel)

    @Query("SELECT * FROM WordModel WHERE id = :id")
    fun getUpdateWord(id: Int): LiveData<WordModel>

}