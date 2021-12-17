package linkedlist

class LinkedListImpl<T> : LinkedList<T> {

    override var head: Node<T>? = null
    override var count: Int = 0

    override fun insertFirst(value: T) {
        head = if (head == null) {
            Node(value)
        } else {
            Node(value, head)
        }
    }

    override fun insertLast(value: T) {
        if (head == null) {
            head = Node(value)
        } else {
            var currentNode = head
            while (currentNode!!.next != null) {
                currentNode = currentNode.next
            }
            currentNode.next = Node(value)
        }
        count++
    }

    override fun removeFirst(): T? {
        return if (head == null) {
            null
        } else {
            if (head!!.next == null) {
                val value = head!!.value
                head = null
                value
            } else {
                val value = head!!.value
                head = head!!.next
                value
            }
        }
    }

    override fun remove(value: T): Boolean {
        if (head == null) {
            return false
        }
        if (head!!.value == value) {
            head = head!!.next
            return true
        }
        var currentElement = head
        while (currentElement!!.next != null) {
            if (currentElement.next!!.value == value) {
                currentElement.next = currentElement.next!!.next
                return true
            } else {
                currentElement = currentElement.next
            }
        }
        return false
    }

    override fun contains(value: T): Boolean {
        if (head == null) {
            return false
        } else {
            var currentElement = head
            while (currentElement != null) {
                if (currentElement.value == value) {
                    return true
                } else {
                    currentElement = currentElement.next
                }
            }
            return false
        }
    }

    fun printElements() {
        if (head == null) {
            println("Empty list")
        } else {
            var currentElement = head
            while (currentElement != null) {
                println(currentElement)
                currentElement = currentElement.next
            }
        }
    }
}