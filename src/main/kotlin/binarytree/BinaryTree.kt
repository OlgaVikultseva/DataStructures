package binarytree

interface BinaryTree {
    fun insert(value: Int)
    fun remove(value: Int)
    fun contains(value: Int): Boolean
    fun traverseInOrder()
}