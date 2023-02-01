package pl.edu.uwr.pum.recall.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.edu.uwr.pum.recall.data.ItemDatabase
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.model.WordModel
import pl.edu.uwr.pum.recall.repository.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {
    val getAllLanguage: LiveData<List<LanguageModel>>
    protected lateinit var repository: Repository

    init {
        val itemDuo = ItemDatabase.getDatabase(application).ItemDuo()
        repository = Repository(itemDuo)
        getAllLanguage = repository.getAllLanguage
    }

    fun addLanguage(item: LanguageModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addLanguage(item)
        }
    }

    fun addWord(item: WordModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addWord(item)
        }
    }

    fun getWard(item: String, status: Int) : LiveData<List<WordModel>> {
        return repository.getWard(item, status)
    }


    fun delLangage(item: LanguageModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delLangage(item)
        }
    }

    fun delWord(item: WordModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delWord(item)
        }
    }

    fun updateWord(item: WordModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.uppdateWord(item)
        }
    }

    fun getUpdateWord(item: Int) : LiveData<WordModel> {
        return repository.getUpdateWord(item)
    }

}