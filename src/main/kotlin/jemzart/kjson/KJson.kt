package jemzart.kjson

import jemzart.kjson.enums.JsonObjectPosition
import jemzart.kjson.operations.JsonObjectInsertion
import jemzart.kjson.parsers.ObjectToStringParser
import jemzart.kjson.parsers.StringToObjectParser
import jemzart.kjson.values.JsonArray
import jemzart.kjson.values.JsonNonCollection
import jemzart.kjson.values.JsonObject
import jemzart.kjson.values.JsonValue

val STRING: String = ""
val INTEGER: Int = 0
val BOOLEAN: Boolean = false
val DOUBLE: Double = 0.0
val JSON_VALUE: JsonValue = JsonNonCollection(null)
val JSON_OBJECT: JsonObject = JsonObject()
val JSON_ARRAY: JsonArray = JsonArray()
val JSON_NON_COLLECTION: JsonNonCollection = JsonNonCollection(null)
val NULLABLE_STRING: String? = null
val NULLABLE_INTEGER: Int? = null
val NULLABLE_BOOLEAN: Boolean? = null
val NULLABLE_DOUBLE: Double? = null
val NULLABLE_JSON_VALUE: JsonValue? = null
val NULLABLE_JSON_OBJECT: JsonObject? = null
val NULLABLE_JSON_ARRAY: JsonArray? = null
val NULLABLE_JSON_NON_COLLECTION: JsonNonCollection? = null
fun <T>jsonEntry(value: T) = Pair("", value)

fun String.toJson(): JsonValue {
	val obj = StringToObjectParser(this).create()
	return if (obj is JsonValue) obj else JsonNonCollection(obj)
}

fun JsonValue.toJsonString(): String = ObjectToStringParser(this).create()

infix fun <T> Pair<String, T>.after(that: String) = JsonObjectInsertion(this, JsonObjectPosition.After, that)
infix fun <T> Pair<String, T>.before(that: String) = JsonObjectInsertion(this, JsonObjectPosition.After, that)