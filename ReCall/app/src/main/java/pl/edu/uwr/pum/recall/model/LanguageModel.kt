package pl.edu.uwr.pum.recall.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["language"], unique = true)])
data class LanguageModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val language: String
)

