package datastructures.linkedlist

object LinkedListBasic {

  def isExistsInLinkedList(node: LinkedListNode, targetValue: Int): Boolean = {
    var tempNode = node
    while (tempNode != null) {
      if (tempNode.value == targetValue) return true
      tempNode = tempNode.nextNode
    }
    return false
  }

  def traverseLinkedList(node: LinkedListNode): Unit = {
    var tempNode = node
    while (tempNode != null) {
      println(tempNode.value)
      tempNode = tempNode.nextNode
    }
  }

  def lengthOfLinkedList(node: LinkedListNode): Int = {
    var count = 0
    var tempNode = node
    while (tempNode != null) {
      tempNode = tempNode.nextNode
      count += 1
    }
    return count
  }

  def printAlternates(node: LinkedListNode): Unit = {
    var tempNode = node
    while (tempNode != null) {
      println(tempNode.value)
      tempNode = if (tempNode.nextNode != null) tempNode.nextNode.nextNode else tempNode.nextNode
    }
  }

  def getKthElementFromTheLast(node: LinkedListNode, k: Int): Int = {
    if (node == null) // Illegal argument
      return -1
    var tempNode1 = node
    var tempNode2 = node
    var count = 0
    if (k <= 0) // Illegal argument
      return -1
    while (tempNode1 != null) {
      count += 1;
      if (count > k)
        tempNode2 = tempNode2.nextNode
      tempNode1 = tempNode1.nextNode
    }
    if (k > count) // Illegal argument
      return -1
    return tempNode2.value
  }

  def createLinkedListOddEven(node: LinkedListNode): LinkedListNode = {
    if (node == null)
      return null
    var oddList = new LinkedList(new LinkedListNode(node.value))
    var evenList = new LinkedList(new LinkedListNode(node.nextNode.value))
    var oddListHead = oddList.head
    var evenListHead = evenList.head
    var oddTraverse = node
    var evenTraverse = node.nextNode
    while (oddTraverse != null && (oddTraverse.nextNode != null)) {
      oddTraverse = oddTraverse.nextNode.nextNode
      if (oddTraverse != null) {
        oddListHead.nextNode = new LinkedListNode(oddTraverse.value)
        oddListHead = oddListHead.nextNode
      }
    }
    while (evenTraverse != null && (evenTraverse.nextNode != null)) {
      evenTraverse = evenTraverse.nextNode.nextNode
      if (evenTraverse != null) {
        evenListHead.nextNode = new LinkedListNode(evenTraverse.value)
        evenListHead = evenListHead.nextNode
      }
    }
    oddListHead.nextNode = evenList.head
    return oddList.head
  }

  def reverseLinkedList(node: LinkedListNode): LinkedListNode = {
    var currNode = node
    var prevNode: LinkedListNode = null
    var nextNode: LinkedListNode = null
    while (currNode != null) {
      nextNode = currNode.nextNode
      currNode.nextNode = prevNode
      prevNode = currNode
      currNode = nextNode
    }
    return prevNode
  }


  def rotateListByKPlacesFromRight(node: LinkedListNode, k: Int): LinkedListNode = {
    var k1 = k
    var traverse1 = node
    var traverse2 = node
    var count = 0
    if (node == null || k1 < 1)
      return node
    while (traverse1.nextNode != null) {
      count += 1
      if (count > k1)
        traverse2 = traverse2.nextNode
      traverse1 = traverse1.nextNode
    }

    if (count + 1 == k1)
      return node
    if (count < k1) {
      k1 = k1 % (count + 1)
      return rotateListByKPlacesFromRight(node, k1)
    }
    var newHead = traverse2.nextNode
    traverse2.nextNode = null
    traverse1.nextNode = node
    return newHead
  }


  def main(args: Array[String]) = {
    var node1 = new LinkedListNode(10)
    var node2 = new LinkedListNode(20, node1)
    var node3 = new LinkedListNode(30, node2)
    var node4 = new LinkedListNode(40, node3)
    var node5 = new LinkedListNode(50, node4)

    var myLinkedList = new LinkedList(node5)
    var myLinkedListHeadReference = myLinkedList.head


    println("Traverse the linked list")
    traverseLinkedList(myLinkedListHeadReference)

    println("Find if element exists in linked list")
    println("Check is exists: " + isExistsInLinkedList(node5, 30))

    println("Print alternative items from linked list")
    printAlternates(myLinkedListHeadReference)

    println("Length of a linked list")
    println(lengthOfLinkedList(myLinkedListHeadReference))

    println("Get Kth element from the last")
    println(getKthElementFromTheLast(myLinkedListHeadReference, 0))

    println("Modify the linked list to have all odd index elements first and all even index elements second")
    println("Eg: [1, 2, 3, 4, 5] to [1, 3, 5, 2, 4]")
    var oddEvenHead = createLinkedListOddEven(myLinkedListHeadReference)
    traverseLinkedList(oddEvenHead)

    println("Reverse a linked last inplace")
    var newHead = reverseLinkedList(myLinkedListHeadReference)
    myLinkedListHeadReference = newHead
    traverseLinkedList(myLinkedListHeadReference)


    println("rotate list to the right by k places")
    var node: LinkedListNode = rotateListByKPlacesFromRight(myLinkedListHeadReference, 6)
    while (node != null) {
      println(node.value)
      node = node.nextNode
    }

  }
}
