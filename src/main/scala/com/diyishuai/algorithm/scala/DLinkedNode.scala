package com.diyishuai.algorithm.scala

case class DLinkedNode(pre: Option[DLinkedNode],value: Long, next: Option[DLinkedNode]){
  override def toString: String = s"${value}->${next match {
    case Some(x) => x
    case None => None
  }}"
}



object DLinkedNode{

//  def main(args: Array[String]): Unit = {
//    val list = new DLinkedNode(
//      None,1l,Some(new DLinkedNode(
//        list,2l,Some(new DLinkedNode(
//          None,3l,None)
//        )
//      ))
//    )
//
//  }

}
