package im.vector.matrix.android.internal.database.model

import im.vector.matrix.android.internal.session.room.timeline.PaginationDirection
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects

internal open class ChunkEntity(var prevToken: String? = null,
                                var nextToken: String? = null,
                                var prevStateIndex: Int = -1,
                                var nextStateIndex: Int = 1,
                                var isLast: Boolean = false,
                                var events: RealmList<EventEntity> = RealmList()
) : RealmObject() {

    @LinkingObjects("chunks")
    val room: RealmResults<RoomEntity>? = null

    companion object

    fun stateIndex(direction: PaginationDirection): Int {
        return when (direction) {
            PaginationDirection.FORWARDS  -> nextStateIndex
            PaginationDirection.BACKWARDS -> prevStateIndex
        }
    }

    fun updateStateIndex(stateIndex: Int, direction: PaginationDirection){
        when (direction) {
            PaginationDirection.FORWARDS  -> nextStateIndex = stateIndex
            PaginationDirection.BACKWARDS -> prevStateIndex = stateIndex
        }
    }


}