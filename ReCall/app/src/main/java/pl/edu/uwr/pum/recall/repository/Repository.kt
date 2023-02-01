package pl.edu.uwr.pum.recall.repository

import androidx.lifecycle.LiveData
import pl.edu.uwr.pum.recall.data.ItemDuo
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.model.WordModel

class Repository(private val itemDao: ItemDuo) {
    val getAllLanguage: LiveData<List<LanguageModel>> = itemDao.getAllLanguages()

    fun addLanguage(item: LanguageModel){
        itemDao.addLanguage(item)
    }

    fun addWord(item: WordModel){
        itemDao.addWord(item)
    }

    fun getWard(item: String, status: Int): LiveData<List<WordModel>>{
        return itemDao.getWard(item, status)
    }

    suspend fun uppdateWord(item: WordModel){
        itemDao.updateItem(item)
    }

    suspend fun delLangage(item: LanguageModel){
        itemDao.delLangage(item)
    }

    suspend fun delWord(item: WordModel){
        itemDao.delWord(item)
    }
    fun getUpdateWord(item: Int): LiveData<WordModel>{
        return itemDao.getUpdateWord(item)
    }

}