package com.diyishuai.algorithm.scala

case class LinkedNode(value: Long,next: Option[LinkedNode]) {
  override def toString = s"$value->${next match {
    case Some(x)=> x
    case None => None
  }}"


}

object LinkedNode{

  def main(args: Array[String]): Unit = {
    val n = new LinkedNode(
      1l,Some(new LinkedNode(
        2l,Some(new LinkedNode(
          3l,Some(new LinkedNode(
            4l,None)))))))

    println(n)
    println(reverse(n))
  }

  def reverse(current: LinkedNode,prev: Option[LinkedNode] = None): LinkedNode ={
    val reversed = current.copy(next = prev)
    current.next.map(reverse(_,Some(reversed))).getOrElse(reversed)
  }

}
