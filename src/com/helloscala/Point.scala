package com.helloscala

/**
 * Class constructors may be declared at same time as the class itself.
 *
 * Created by drewmalin on 12/2/14.
 */
class Point(x: Double, y: Double) {

  /**
   * Simple getter. The return type is inferred by the compiler.
   */
  def getX() = x

  /**
   * More common method declaration with return type.
   */
  def getY(): Double = {
    return y
  }

  /**
   * Methods which take no arguments may be declared without parenthesis. This allows the use of the method to also
   * omit parenthesis, e.g.:
   */
  def getYAlternate = y

  /**
   * All classes in Scala inherit from scala.AnyRef. It is mandatory to specify that a method is an override using the
   * 'override' keyword.
   */
  override def toString() =
    "(" + x + ", " + y + ")"

}
