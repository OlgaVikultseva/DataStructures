package linkedlist

interface LinkedList<T> {
    var head: Node<T>?
    var count: Int

    fun insertFirst(value: T)
    fun insertLast(value: T)
    fun removeFirst(): T?
    fun remove(value: T): Boolean
    fun contains(value: T): Boolean
}




