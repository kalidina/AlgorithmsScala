package datastructures.linkedlist

object LinkedListAdvanced {

  /*
  From K lists : choose 2 lists to merge, then use the result to merge with the next list and so forth
 */
  def mergeKLists(lists: Array[LinkedListNode]): LinkedListNode = {
    if ( lists.length == 0 )
      return null
    if ( lists.length == 1 )
      return lists(0)
    mergeKListsBetweenIndex(lists, 0, lists.length-1)
  }

  def mergeKListsBetweenIndex(lists: Array[LinkedListNode], startIdx: Int, endIdx: Int): LinkedListNode = {
    if ( endIdx <= startIdx )
      return lists(startIdx)
    var mid = (startIdx + endIdx)/2
    var ll1: LinkedListNode = mergeKListsBetweenIndex(lists, startIdx, mid)
    var ll2: LinkedListNode = mergeKListsBetweenIndex(lists, mid+1, endIdx)
    return mergeSortedLists(ll1, ll2)
  }

  def mergeSortedLists(ll1: LinkedListNode, ll2:LinkedListNode): LinkedListNode = {
    var traverse1 = ll1
    var traverse2 = ll2
    var resultHead:LinkedListNode = new LinkedListNode(-1)
    var resultNode = resultHead


    while ( traverse1 != null && traverse2 != null ) {
      if ( traverse1.value < traverse2.value ) {
        resultNode.nextNode = traverse1
        traverse1 = traverse1.nextNode
        resultNode = resultNode.nextNode
      } else if ( traverse1.value > traverse2.value) {
        resultNode.nextNode = traverse2
        traverse2 = traverse2.nextNode
        resultNode = resultNode.nextNode
      } else {
        resultNode.nextNode = traverse1
        traverse1 = traverse1.nextNode
        resultNode = resultNode.nextNode

        resultNode.nextNode = traverse2
        traverse2 = traverse2.nextNode
        resultNode = resultNode.nextNode
      }
    }

    while ( traverse1 != null ) {
      resultNode.nextNode = traverse1
      traverse1 = traverse1.nextNode
      resultNode = resultNode.nextNode
    }

    while ( traverse2 != null ) {
      resultNode.nextNode = traverse2
      traverse2 = traverse2.nextNode
      resultNode = resultNode.nextNode
    }

    return resultHead.nextNode

  }

  def main(args: Array[String]) = {
    var n1 = new LinkedListNode(70)
    var n2 = new LinkedListNode(60, n1)
    var n3 = new LinkedListNode(40, n2)
    var n4 = new LinkedListNode(20, n3)
    var n5 = new LinkedListNode(10, n4)

    var m1 = new LinkedListNode(90)
    var m2 = new LinkedListNode(80, m1)
    var m3 = new LinkedListNode(50, m2)
    var m4 = new LinkedListNode(30, m3)
    var m5 = new LinkedListNode(10, m4)

    var ll1 = new LinkedList(n5)

    var ll2 = new LinkedList(m5)
    /*
    print("Merge Two sorted linked lists")
    var mergedll = mergeSortedLists(ll1.head, ll2.head)
    LinkedListBasic.traverseLinkedList(mergedll)
    */

    var p1 = new LinkedListNode(100)
    var p2 = new LinkedListNode(90, p1)
    var p3 = new LinkedListNode(80, p2)
    var p4 = new LinkedListNode(70, p3)
    var p5 = new LinkedListNode(60, p4)
    var ll3 = new LinkedList(p5)
    var lists = Array(ll1.head, ll2.head, ll3.head)
    print("Merge K sorted linked lists")
    var mergedKll = mergeKLists(lists)
    LinkedListBasic.traverseLinkedList(mergedKll)
  }

}
