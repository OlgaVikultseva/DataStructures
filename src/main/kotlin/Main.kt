import binarytree.BinaryTreeImpl

fun main(args: Array<String>) {

    val binaryTree = BinaryTreeImpl().apply {
        insert(80)
        insert(54)
        insert(90)
        insert(16)
        insert(74)
        insert(21)
        insert(38)
        insert(15)
        insert(110)
    }

    binaryTree.traverseInOrder()

    binaryTree.remove(74)
    println("remove(74)")
    binaryTree.traverseInOrder()

    binaryTree.remove(21)
    println("remove(21)")
    binaryTree.traverseInOrder()

}



