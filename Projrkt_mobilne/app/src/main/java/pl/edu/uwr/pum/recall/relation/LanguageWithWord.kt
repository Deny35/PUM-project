package pl.edu.uwr.pum.recall.relation

import androidx.room.Embedded
import androidx.room.Relation
import pl.edu.uwr.pum.recall.model.LanguageModel
import pl.edu.uwr.pum.recall.model.WordModel

class LanguageWithWord (
    @Embedded val faculty: LanguageModel,

    @Relation(
        parentColumn = "language",
        entityColumn = "language"
    )

    val students: List<WordModel>
)