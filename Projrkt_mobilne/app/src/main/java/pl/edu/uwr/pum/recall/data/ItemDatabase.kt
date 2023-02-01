package pl.edu.uwr.pum.recall.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.model.WordModel

    @Database(
        entities = [
            LanguageModel::class,
            WordModel::class
        ],
        version = 1,
        exportSchema = false
    )
    abstract class ItemDatabase : RoomDatabase() {

        abstract fun ItemDuo(): ItemDuo

        companion object{
            @Volatile private var INSTANCE: ItemDatabase? = null

            fun getDatabase(context: Context): ItemDatabase{
                synchronized(this){
                    return  INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
                        "d4"
                    ).build().also {
                        INSTANCE = it
                    }
                }
            }
        }
    }
