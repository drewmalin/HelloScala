package com.helloscala

import scala.collection.immutable.List

/**
 * The use of 'object' instead of 'class' is Scala's way of defining a singleton. This definition will implicitly
 * instantiate the new, singleton object, of the class.
 *
 * Note: there are no static methods or fields in Scala (see 'main' below). Instead of defining static members,
 * singletons are used.
 *
 * Note: methods which do not return anything need not be declared as 'void.' Instead, the return type is omitted from
 * the method signature.
 *
 * Created by drewmalin on 12/2/14.
 */

object Hello {

  def main (args: Array[String]) {
    println("Hello, Scala!")

    // Variable type is inferred
    // 'val' declarations are immutable
    val p = new Point(1, 2)
    println(p.toString())

    // 'var' declarations are mutable
    var pMutable = new Point(2, 4)
    pMutable = new Point(6, 8)

    // Variable type can be explicitly provided
    val x: Double = 10.5
    val y: Double = 13.9
    val pVars = new Point(x, y)
  }

  /**
   * Functions may be passed as arguments
   *
   * Note: The return type is declared after the method name. As with variable declarations, the compiler can, for the
   * most part, determine the appropriate type at compile time.
   */
  def functionsAreArguments1(): Unit = {
    oncePerSecond(printCurrentTime)
  }

  /**
   * Use of an anonymous function
   */
  def functionsAreArguments2() {
    oncePerSecond(() =>
      println(System.currentTimeMillis()))
  }

  /**
   * @param callback A method which has no parms and returns nothing ('Unit' is like 'void')
   */
  def oncePerSecond(callback: () => Unit) {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def printCurrentTime() {
    println(System.currentTimeMillis())
  }

  def functionsAreVariables(): Int = {
    // Save an anonymous function to a variable
    val square = (x: Int) => x * x

    // The input of anonymous functions can also be inferred by the compiler
    // The following specifies a method which accepts an Int, returns an Int, and uses a local variable x to arrive at
    // x * x:
    val square2: Int => Int = x => x * x

    // Local variables in anonymous functions can also be inferred
    val mul: (Int, Int) => Int = _ * _

    // No return statement needed -- the last expression in a function is the return statement
    square(10) + square2(4) + mul(5, 5)
  }

  def forLoops(): Unit = {
    (100 to 1 by -2) foreach println
  }

  def whileLoops(): Unit = {
    var i = 0
    while (i < 10) {
      println("i = " + i)
      i += 1
    }
  }

  def recursion(from: Int, to:Int): Unit = {
    print (from)
    if (from < to) {
      recursion(from + 1, to)
    }
  }

  def functionalProgramming1(): List[Int] = {
    val adder = (x: Int) => x + 10
    return List(1, 2, 3).map(adder)
  }

  /**
   * Anonymous function infers return and input type
   */
  def functionalProgramming2(): List[Int] = {
    List(1, 2, 3).map(_ * 2)
  }

  def addSquaresOfEvenItems(list: List[Int]): Int = {
    return list.filter(_ % 2 == 0).map(x => x * x).reduce(_ + _)
  }
}
