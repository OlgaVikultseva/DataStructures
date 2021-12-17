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
        TODO("Not yet implemented")
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