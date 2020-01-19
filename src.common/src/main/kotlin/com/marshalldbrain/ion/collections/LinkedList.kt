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
			count--
			return node.value
		}
		return null
	}
	
	private open inner class IteratorImpl : MutableIterator<E> {
		protected var node = head
		
		override fun hasNext(): Boolean = node is Link && (node as Link).next is Link
		
		override fun remove() {
			val last = (node as Link).prev as Link
			(last.prev as Link).next = last.next
			(last.next as Link).prev = last.prev
			count--
		}
		
		override fun next(): E {
			if (!hasNext()) throw NoSuchElementException()
			val n = node as Link
			node = n.next
			return n.value
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