package com.marshalldbrain.ion.collections

fun <K, V> Map<K, V>.getOrDefault(key: K, defaultValue: V): V {
	return this[key] ?: defaultValue
}