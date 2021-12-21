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

    with(binaryTree) {
        test1()
        test2()
        test3()
    }
}

fun BinaryTreeImpl.test1() {
    println("case 1: binaryTree.remove(74)")
    this.remove(74)
    this.traverseInOrder()
}

fun BinaryTreeImpl.test2() {
    println("case 1: binaryTree.remove(90)")
    this.remove(90)
    this.traverseInOrder()
}

fun BinaryTreeImpl.test3() {
    println("case 1: binaryTree.remove(16)")
    this.remove(16)
    this.traverseInOrder()
}



