package com.diyishuai.algorithm.scala


case class BinaryTreeNode(leftChild: Option[BinaryTreeNode], value: Long, rightChild: Option[BinaryTreeNode]) {

}

object BinaryTreeNode {

  def preOrder(treeNode: Option[BinaryTreeNode]): Unit = {
    treeNode match {
      case Some(node) => {
        println(node.value)
        preOrder(node.leftChild)
        preOrder(node.rightChild)
      }
      case None => {}
    }
  }

  def inOrder(treeNode: Option[BinaryTreeNode]): Unit = {
    treeNode match {
      case Some(node) => {
        inOrder(node.leftChild)
        println(node.value)
        inOrder(node.rightChild)
      }
      case None => {}
    }
  }


  def postOrder(treeNode: Option[BinaryTreeNode]): Unit = {
    treeNode match {
      case Some(node) => {
        postOrder(node.leftChild)
        postOrder(node.rightChild)
        println(node.value)
      }
      case None => {}
    }
  }

  def main(args: Array[String]): Unit = {
    /**
      *    1
      *  2   3
      * 4   5 6
      */
    val root = new BinaryTreeNode(
      Some(new BinaryTreeNode(
        Some(new BinaryTreeNode(
          None,
          4l,
          None
        )),
        2l,
        None
      )),
      1l,
      Some(new BinaryTreeNode(
        Some(new BinaryTreeNode(
          None,
          5l,
          None
        )),
        3l,
        Some(new BinaryTreeNode(
          None,
          6l,
          None
        ))
      ))
    )

    preOrder(Some(root))
    println("====")
    inOrder(Some(root))
    println("====")
    postOrder(Some(root))
  }

}
