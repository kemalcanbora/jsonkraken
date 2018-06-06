package jemzart.jsonkraken.unit.json.`object`

import jemzart.jsonkraken.JSON_VALUE
import jemzart.jsonkraken.values.JsonObject
import jemzart.jsonkraken.values.JsonValue
import org.junit.Test

class JsonObjectSetOperator{
	private val insertion: JsonValue = JSON_VALUE

	@Test
	fun byString(){
		val obj = JsonObject()
		obj["0"] = insertion
		assert(obj["0"] == insertion)
	}

	@Test
	fun byInt(){
		val obj = JsonObject()
		obj[0] = insertion
		assert(obj["0"] == insertion)
	}
}