package binarytree

class BinaryTreeImpl : BinaryTree {

    private var root: Node<Int>? = null

    override fun insert(value: Int) {
        if (root == null) {
            root = Node(value)
        } else {
            addValue(root!!, value)
        }
    }

    private fun addValue(currentNode: Node<Int>, value: Int) {
        if (value <= currentNode.value) {
            val left = currentNode.leftNode                          // мы помогаем компилятору; мы должны избавиться от !! когда можно
            if (left == null) {                                      // если мы хотим избавиться от nullable, то мы можем создавать локальные переменные
                currentNode.leftNode = Node(value)
            } else {
                addValue(left, value)
            }
        } else {
            val right = currentNode.rightNode
            if (right == null) {
                currentNode.rightNode = Node(value)
            } else {
                addValue(right, value)
            }
        }
    }

    override fun remove(value: Int): Boolean {
        if (root == null) {
            return false
        }
        return if (root!!.value == value) {
            root = null
            true
        } else {
            checkChildNodes(root!!, value)
        }
    }

    private fun checkChildNodes(currentNode: Node<Int>, value: Int): Boolean {
        return if (value < currentNode.value) {
            if (currentNode.leftNode == null) {
                return false
            }
            if (currentNode.leftNode!!.value == value) {
                removeChildNode(currentNode, true)
            } else {
                checkChildNodes(currentNode.leftNode!!, value)
            }
        } else {
            if (currentNode.rightNode == null) {
                return false
            }
            if (currentNode.rightNode!!.value == value) {
                removeChildNode(currentNode, false)
            } else {
                checkChildNodes(currentNode.rightNode!!, value)
            }
        }
    }

    private fun removeChildNode(parentNode: Node<Int>, isLeftChildNode: Boolean): Boolean {
        val removedNode = if (isLeftChildNode) parentNode.leftNode!! else parentNode.rightNode!!
        if (isLeftChildNode) {
            when {
                // todo: a node has no children
                removedNode.leftNode == null && removedNode.rightNode == null -> {
                    parentNode.leftNode = null
                }
                // todo: a node has two children
                removedNode.leftNode != null && removedNode.rightNode != null -> {

                }
                // todo: a node has exactly one child
                else -> {
                    if (removedNode.leftNode != null) {
                        parentNode.leftNode = removedNode.leftNode
                    } else {
                        parentNode.leftNode = removedNode.rightNode
                    }
                }
            }
        } else {

        }
        return true
    }

    override fun contains(value: Int): Boolean =
        containsInternal(root, value)

    /**
     * Эта функция проверяет содержится ли значение в Node или в одном из children's.
     * @return true - значение найдено в Node или в его children's; false - не найдено.
     */
    private fun containsInternal(currentNode: Node<Int>?, value: Int): Boolean {
        if (currentNode == null) {
            return false
        }
        if (currentNode.value == value) {
            return true
        }
        return if (value < currentNode.value) {
            containsInternal(currentNode.leftNode, value)
        } else {
            containsInternal(currentNode.rightNode, value)
        }
    }
}