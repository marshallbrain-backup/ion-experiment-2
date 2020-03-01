package com.marshalldbrain.ion.collections

import io.kotlintest.TestCase
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.math.BigInteger
import kotlin.random.Random

class LinkedListTest : FunSpec({
	
	test("Get size") {
			
		val linkedList = LinkedList<String>()
		
		repeat(8) {
			linkedList.add("")
		}
		
		linkedList.size == 8
		
	}
	
	test("Add") {
		
		val linkedList = LinkedList<String>()
		
		linkedList.add("Test").shouldBeTrue()
		
	}
	
	test("Peek") {
		
		val linkedList = LinkedList<String>()
		
		linkedList.add("Test")
		
		linkedList.peek() shouldBe "Test"
		
	}
	
	test("Poll") {
		
		val linkedList = LinkedList<String>()
		
		linkedList.add("Test")
		
		linkedList.poll() shouldBe "Test"
		linkedList.size shouldBe 0
		
	}
	
	test("Adding to empty list") {
		
		val linkedList = LinkedList<String>()
		linkedList.add("Test")
		linkedList.poll()
		
		linkedList.shouldBeEmpty()
		
		linkedList.add("Test2")
		
		linkedList.peek() shouldBe "Test2"
		linkedList.size shouldBe 1
		
	}
	
	context("Iterator Test") {
		
		test("Has next") {
			
			val linkedList = LinkedList<String>()
			
			linkedList.add("Test")
			
			val iterator = linkedList.iterator()
			
			iterator.hasNext().shouldBeTrue()
			
		}
		
		test("Remove").config(enabled = false) {
			
			val linkedList = LinkedList<String>()
			
			linkedList.add("Test")
			
			val iterator = linkedList.iterator()
			
			iterator.next()
			iterator.remove()
			
			iterator.hasNext().shouldBeFalse()
			
		}
		
		test("Next") {
			
			val linkedList = LinkedList<String>()
			
			linkedList.add("Test")
			
			val iterator = linkedList.iterator()
			
			iterator.next() shouldBe "Test"
			iterator.hasNext().shouldBeFalse()
			
		}
		
	}
	
})