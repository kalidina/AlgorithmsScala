package datastructures.linkedlist

class LinkedListNode(var value:Int, var nextNode:LinkedListNode = null)

// Learnings : using var in class constructor(for class members), makes the members private but mutable.
// using val in class constructor(for class members), makes the members private and immutable.