package com.marshalldbrain.ion.collections

interface Queue<E> : MutableCollection<E> {
	
	fun peek(): E?
	fun poll(): E?

}