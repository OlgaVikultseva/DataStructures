package binarytree

interface BinaryTree {
    fun insert(value: Int)
    fun remove(value: Int): Boolean
    fun contains(value: Int): Boolean
}