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

    override fun remove(value: Int) {
        root = removeInternal(root, value)
    }

    private fun removeInternal(currentNode: Node<Int>?, value: Int): Node<Int>? {
        if (currentNode == null) {
            return null
        }
        if (value == currentNode.value) {
            when {
                // case 1: node has no children
                currentNode.leftNode == null && currentNode.rightNode == null -> {
                    return null
                }
                // case 2: node has exactly one child
                currentNode.rightNode == null -> {
                    return currentNode.leftNode
                }
                currentNode.leftNode == null -> {
                    return currentNode.rightNode
                }
                // case 3: node has two children
                else -> {
                    val smallestValue = findSmallestValue(currentNode.rightNode!!)
                    currentNode.value = smallestValue
                    currentNode.rightNode = removeInternal(currentNode.rightNode, smallestValue)
                    return currentNode
                }
            }
        }
        return if (value < currentNode.value) {
            currentNode.leftNode = removeInternal(currentNode.leftNode, value)
            currentNode
        } else {
            currentNode.rightNode = removeInternal(currentNode.rightNode, value)
            currentNode
        }
    }

    private fun findSmallestValue(currentNode: Node<Int>): Int =
        if (currentNode.leftNode == null) currentNode.value else findSmallestValue(currentNode.leftNode!!)

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

    override fun traverseInOrder() {
        if (root == null) {
            println("Empty tree")
        } else {
            traverseInOrderInternal(root!!)
        }
    }

    private fun traverseInOrderInternal(currentNode: Node<Int>) {
        if (currentNode.leftNode != null) {
            traverseInOrderInternal(currentNode.leftNode!!)
        }
        println(currentNode.value)
        if (currentNode.rightNode != null) {
            traverseInOrderInternal(currentNode.rightNode!!)
        }
    }
}