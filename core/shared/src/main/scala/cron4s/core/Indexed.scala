package cron4s.core

/**
  * Created by domingueza on 31/12/15.
  */
trait Indexed[T] {

  def apply(index: Int): Option[T]

  def indexOf(item: T): Option[Int]

}