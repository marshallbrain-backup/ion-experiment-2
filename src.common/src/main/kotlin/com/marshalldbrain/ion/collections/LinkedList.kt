package com.marshalldbrain.ion.collections

internal class LinkedList<E>() : AbstractMutableCollection<E>(), Queue<E> {
	
	private var head: Node<E> = Terminal()
	private var tail: Node<E> = Terminal()
	private var count: Int = 0
	
	override val size: Int
		get() = count
	
	override fun add(element: E): Boolean {
		val old = tail
		if (old is Link<E>) {
			val new = Link(element)
			old.next = new
			new.prev = old
			tail = new
		} else {
			head = Link(element)
			tail = head
		}
		count++
		return true
	}
	
	override fun iterator(): MutableIterator<E> {
		return IteratorImpl()
	}
	
	override fun peek(): E? {
		val node = head
		if (node is Link) {
			return node.value
		}
		return null
	}
	
	override fun poll(): E? {
		val node = head
		if (node is Link) {
			head = node.next
			if (head is Terminal) {
				tail = Terminal()
			}
			count--
			return node.value
		}
		return null
	}
	
	private open inner class IteratorImpl : MutableIterator<E> {
		protected var node = head
		protected var lastNode: Node<E> = Terminal()
		
		override fun hasNext(): Boolean = node is Link
		
		override fun remove() {
			throw UnsupportedOperationException()
		}
		
		override fun next(): E {
			val last = node as Link
			lastNode = last
			node = last.next
			return last.value
		}
		
	}
	
}

internal sealed class Node<T>

internal class Link<T>(var value: T): Node<T>() {
	var prev: Node<T> = Terminal()
	var next: Node<T> = Terminal()
}

internal class Terminal<T> : Node<T>() {
}