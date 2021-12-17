package stack

import linkedlist.LinkedListImpl

class StackImpl<T> : Stack<T> {

    private val linkedList = LinkedListImpl<T>()

    override fun push(value: T) {
        linkedList.insertFirst(value)
    }

    override fun pop(): T? = linkedList.removeFirst()

    fun printElements() {
        linkedList.printElements()
    }
}






