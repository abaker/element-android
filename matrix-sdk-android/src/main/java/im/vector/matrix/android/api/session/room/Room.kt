/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.api.session.room

import androidx.lifecycle.LiveData
import im.vector.matrix.android.api.session.room.model.MyMembership
import im.vector.matrix.android.api.session.room.model.RoomSummary
import im.vector.matrix.android.api.session.room.send.SendService
import im.vector.matrix.android.api.session.room.timeline.TimelineService
import im.vector.matrix.android.api.util.Cancelable

/**
 * This interface defines methods to interact within a room.
 */
interface Room : TimelineService, SendService {

    /**
     * The roomId of this room
     */
    val roomId: String

    /**
     * The membership of this room for the current user
     */
    val myMembership: MyMembership

    /**
     * A live [RoomSummary] associated with the room
     */
    val roomSummary: LiveData<RoomSummary>

    /**
     * This methods load all room members if it was done yet.
     * @return a [Cancelable]
     */
    fun loadRoomMembersIfNeeded(): Cancelable

}