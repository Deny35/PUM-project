package pl.edu.uwr.pum.recall.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["word"], unique = true)])
data class WordModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val translateWord: String,
    val status: Int,
    val language: String

)