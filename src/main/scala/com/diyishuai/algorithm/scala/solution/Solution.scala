package com.diyishuai.algorithm.scala.solution

object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      val hashMap = nums.zipWithIndex.toMap
      nums.filter(i => {
        val complement = target - i
        hashMap.contains(complement) && hashMap.get(complement).get != nums.indexOf(i)
      }).map(hashMap).distinct
  }

  def main(args: Array[String]): Unit = {

    val nums = Array(3,2,4,4)
    println("======")
    val ints = twoSum(nums, 6)
    ints.map(println)
  }

}