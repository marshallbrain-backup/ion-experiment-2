package com.marshalldbrain.ion.collections

import io.kotlintest.TestCase
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.shouldBe
import io.kotlintest.specs.AbstractAnnotationSpec
import io.kotlintest.specs.FunSpec

class LinkedListTest : FunSpec() {
	
	private lateinit var linkedList: LinkedList<Any>
	
	override fun beforeTest(testCase: TestCase) {
		
		linkedList = LinkedList()
		
	}
	
	init {
		
		test("Get size") {
			
			linkedList.size shouldBe 0
			
		}
		
		test("Add") {
			
			linkedList.add("Test").shouldBeTrue()
			
		}
		
		test("Peek") {
			
			linkedList.add("Test")
			
			linkedList.peek() shouldBe "Test"
			
		}
		
		test("Poll") {
			
			linkedList.add("Test")
			
			linkedList.poll() shouldBe "Test"
			linkedList.size shouldBe 0
			
		}
		
		context("Iterator Test") {
			
			test("Has next") {
				
				linkedList.add("Test")
				
				val iterator = linkedList.iterator()
				
				iterator.hasNext().shouldBeTrue()
				
			}
			
			test("Remove").config(enabled = false) {

				linkedList.add("Test")

				val iterator = linkedList.iterator()

				iterator.next()
				iterator.remove()

				iterator.hasNext().shouldBeFalse()

			}
			
			test("Next") {
				
				linkedList.add("Test")
				
				val iterator = linkedList.iterator()
				
				iterator.next() shouldBe "Test"
				iterator.hasNext().shouldBeFalse()
				
			}
			
		}
		
	}
	
}