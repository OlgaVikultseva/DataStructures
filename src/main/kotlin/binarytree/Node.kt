package binarytree

data class Node<T>(
    var value: T,
    var leftNode: Node<T>? = null,
    var rightNode: Node<T>? = null
)
