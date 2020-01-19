package com.marshalldbrain.ion.collections

interface Queue<E> : Collection<E> {
	
	fun peek(): E?
	fun poll(): E?

}