package datastructures.linkedlist

object LinkedListIntermediate {

  /*
     Have a pointer p1 traverse from start
     Have a pointer p2 start traversing from head when p1 crosses (n+1)th index
     if p2 is first element of list, then make p2's next element as new head
     else p2's next element should be removed
     */
  def removeNthNodeFromLast(node : LinkedListNode, n: Int): LinkedListNode = {
    var p1 = node
    var p2 = node
    var count = 0
    if ( node == null || n <= 0 )
      return node

    while ( p1 != null ) {
      count += 1
      if ( count > (n+1) )
        p2 = p2.nextNode
      p1 = p1.nextNode
    }

    if ( count == n ) {
      var temp1 = p2.nextNode
      p2.nextNode = null
      return temp1
    }
    p2.nextNode = p2.nextNode.nextNode
    return node
  }


  def swapPairs(head: LinkedListNode): LinkedListNode = {
    return null
  }

  def main(args : Array[String]) : Unit = {

    var node1 = new LinkedListNode(10)
    var node2 = new LinkedListNode(20, node1)
    var node3 = new LinkedListNode(30, node2)
    var node4 = new LinkedListNode(40, node3)
    var node5 = new LinkedListNode(50, node4)

    var ll = new LinkedList(node5)

    print("Remove nth node from the last")
    var node = removeNthNodeFromLast(ll.head, 5)
    LinkedListBasic.traverseLinkedList(node)


  }

}
