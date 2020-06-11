/*
 * Copyright 2020 Realm Inc.
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

package io.realm.entities

import io.realm.MutableRealmInteger
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.TestHelper
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import io.realm.annotations.Required
import org.bson.types.Decimal128
import org.bson.types.ObjectId
import java.math.BigDecimal
import java.util.*

open class SyncSupportedTypes : RealmObject() {

    companion object {
        const val CLASS_NAME = "AllTypes"
        const val FIELD_STRING = "columnString"
        const val FIELD_LONG = "columnLong"
        const val FIELD_FLOAT = "columnFloat"
        const val FIELD_DOUBLE = "columnDouble"
        const val FIELD_BOOLEAN = "columnBoolean"
        const val FIELD_DATE = "columnDate"
        const val FIELD_BINARY = "columnBinary"
        const val FIELD_MUTABLEREALMINTEGER = "columnMutableRealmInteger"
        const val FIELD_DECIMAL128 = "columnDecimal128"
        const val FIELD_OBJECT_ID = "columnObjectId"
        const val FIELD_REALMOBJECT = "columnRealmObject"
        const val FIELD_REALMLIST = "columnRealmList"
        const val FIELD_STRING_LIST = "columnStringList"
        const val FIELD_BINARY_LIST = "columnBinaryList"
        const val FIELD_BOOLEAN_LIST = "columnBooleanList"
        const val FIELD_LONG_LIST = "columnLongList"
        const val FIELD_DOUBLE_LIST = "columnDoubleList"
        const val FIELD_FLOAT_LIST = "columnFloatList"
        const val FIELD_DATE_LIST = "columnDateList"
        val INVALID_TYPES_FIELDS_FOR_DISTINCT = arrayOf(FIELD_REALMOBJECT, FIELD_REALMLIST, FIELD_DOUBLE, FIELD_FLOAT,
                FIELD_STRING_LIST, FIELD_BINARY_LIST, FIELD_BOOLEAN_LIST, FIELD_LONG_LIST,
                FIELD_DOUBLE_LIST, FIELD_FLOAT_LIST, FIELD_DATE_LIST)
    }

    @PrimaryKey
    @RealmField(name = "_id")
    var id = ObjectId()

    @Required
    var columnString = ""
    var columnLong: Long = 0
    var columnFloat = 0f
    var isColumnBoolean = false

    @Required
    var columnDate = Date(0)

    @Required
    var columnBinary = ByteArray(0)

    @Required
    var columnDecimal128 = Decimal128(BigDecimal.ZERO)

    @Required
    var columnObjectId = ObjectId(TestHelper.randomObjectIdHexString())
    val columnRealmInteger = MutableRealmInteger.ofNull()
    var columnRealmObject: SyncDog? = null
    var columnRealmList: RealmList<SyncDog>? = null

    // FIXME These are the fields needed to be removed from SyncAllTypes for sync to work when
    //  updating the partitionValue
//    var columnDouble = 0.0
//    var columnStringList: RealmList<String>? = null
//    var columnBinaryList: RealmList<ByteArray>? = null
//    var columnBooleanList: RealmList<Boolean>? = null
//    var columnLongList: RealmList<Long>? = null
//    var columnDoubleList: RealmList<Double>? = null
//    var columnFloatList: RealmList<Float> = RealmList()
//    var columnDateList: RealmList<Date>? = null
//    var columnDecimal128List: RealmList<Decimal128>? = null

//    var columnObjectIdList: RealmList<ObjectId>? = null

    fun setColumnMutableRealmInteger(value: Int) {
        columnRealmInteger.set(value.toLong())
    }

}
