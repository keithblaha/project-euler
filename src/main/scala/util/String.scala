package com.keithblaha.euler.util

import scala.annotation.tailrec

object String {
  @tailrec def isPalindrome(s: String): Boolean =  {
    if(s.length <= 1) true
    else if(s.head == s.last) isPalindrome(s.slice(1, s.length-1))
    else false
  }
}

