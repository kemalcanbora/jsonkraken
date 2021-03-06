package net.jemzart.jsonkraken.unit.json.`object`

import net.jemzart.jsonkraken.exceptions.CircularReferenceException
import net.jemzart.jsonkraken.exceptions.InvalidJsonTypeException
import net.jemzart.jsonkraken.values.JsonArray
import net.jemzart.jsonkraken.values.JsonObject
import net.jemzart.jsonkraken.values.JsonValue
import org.junit.Test

class JsonObjectSetOperator{
	private val insertion: JsonValue = JsonObject()

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

	@Test(expected = InvalidJsonTypeException::class)
	fun failsOnInvalidType(){
		val obj = JsonObject()
		obj["0"] = Exception()
	}

	@Test(expected = CircularReferenceException::class)
	fun circularReferenceNotAllowed(){
		val obj = JsonObject()
		val arr = JsonArray(obj)

		obj["0"] = arr
	}

	@Test(expected = CircularReferenceException::class)
	fun selfReferenceNotAllowed(){
		val obj = JsonObject()

		obj["0"] = obj
	}
}