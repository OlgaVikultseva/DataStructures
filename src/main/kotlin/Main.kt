import stack.StackImpl

fun main(args: Array<String>) {

    val stack = StackImpl<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.printElements()

    stack.pop()
    stack.printElements()

    stack.push(4)
    stack.printElements()

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}



