package com.keithblaha.euler.problem

class Problem54 extends EulerProblem {
  object Ranks extends Enumeration {
    val Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace = Value
    def getRank(c: Char) = c match {
      case '2' => Two
      case '3' => Three
      case '4' => Four
      case '5' => Five
      case '6' => Six
      case '7' => Seven
      case '8' => Eight
      case '9' => Nine
      case 'T' => Ten
      case 'J' => Jack
      case 'Q' => Queen
      case 'K' => King
      case 'A' => Ace
    }
  }

  object Suits extends Enumeration {
    val Clubs, Diamonds, Hearts, Spades = Value
    def getSuit(c: Char) = c match {
      case 'C' => Clubs
      case 'D' => Diamonds
      case 'H' => Hearts
      case 'S' => Spades
    }
  }

  case class Card(s: String) {
    val rank = Ranks.getRank(s(0))
    val suit = Suits.getSuit(s(1))
  }

  case class Hand(cards: Seq[Card]) extends Ordered[Hand] {
    object Types extends Enumeration {
      val HighCard, OnePair, TwoPairs, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush = Value
    }
    import Types._

    val ranks = cards.groupBy(_.rank).mapValues(_.size)
    val suits = cards.groupBy(_.suit).mapValues(_.size)
    val handType = {
      val mostOfAKind = ranks.values.max
      val leastOfAKind = ranks.values.min
      val isFlush = suits.size == 1
      val isStraight = ranks.size == 5 && (ranks.max._1.id - ranks.min._1.id == 4) // aces high only
      val numPairs = ranks.values.filter(_ == 2).size

      if(isStraight && isFlush) StraightFlush
      else if(mostOfAKind == 4) FourOfAKind
      else if(mostOfAKind == 3) {
        if(leastOfAKind == 2) FullHouse
        else ThreeOfAKind
      }
      else if(isFlush) Flush
      else if(isStraight) Straight
      else if(numPairs == 2) TwoPairs
      else if(numPairs == 1) OnePair
      else HighCard
    }

    def compare(other: Hand) = {
      val d = handType.id - other.handType.id
      if(d == 0) {
        handType match {
          case StraightFlush | Flush | Straight => ranks.max._1.id - other.ranks.max._1.id
          case FourOfAKind | FullHouse | ThreeOfAKind => ranks.maxBy(_._2)._1.id - other.ranks.maxBy(_._2)._1.id
          case TwoPairs => {
            val p1 = ranks.filter(_._2 == 2).keys.toSeq.sortBy(-1*_.id)
            val p2 = other.ranks.filter(_._2 == 2).keys.toSeq.sortBy(-1*_.id)
            if(p1(0).id == p2(0).id && p1(1).id == p2(1).id) ranks.minBy(_._2)._1.id - other.ranks.minBy(_._2)._1.id
            else if(p1(0).id == p2(0).id) p1(1).id - p2(1).id
            else p1(0).id - p2(0).id
          }
          case OnePair => {
            val p1 = ranks.filter(_._2 == 2).head._1
            val p2 = other.ranks.filter(_._2 == 2).head._1
            if(p1.id == p2.id) {
              val h1 = ranks.filter(_._2 == 1).keys.toSeq.sortBy(-1*_.id)
              val h2 = other.ranks.filter(_._2 == 1).keys.toSeq.sortBy(-1*_.id)
              if(h1(0).id == h2(0).id && h1(1).id == h2(1).id) h1(2).id - h2(2).id
              else if(h1(0).id == h2(0).id) h1(1).id - h2(1).id
              else h1(0).id - h2(0).id
            }
            else p1.id - p2.id
          }
          case HighCard => {
            val h1 = ranks.keys.toSeq.sortBy(-1*_.id)
            val h2 = other.ranks.keys.toSeq.sortBy(-1*_.id)
            if(h1(0).id == h2(0).id && h1(1).id == h2(1).id && h1(2).id == h2(2).id && h1(3).id == h2(3).id) h1(4).id - h2(4).id
            else if(h1(0).id == h2(0).id && h1(1).id == h2(1).id && h1(2).id == h2(2).id) h1(3).id - h2(3).id
            else if(h1(0).id == h2(0).id && h1(1).id == h2(1).id) h1(2).id - h2(2).id
            else if(h1(0).id == h2(0).id) h1(1).id - h2(1).id
            else h1(0).id - h2(0).id
          }
        }
      }
      else d
    }
  }

  override def solution = (for {
    l <- resource.getLines
    c = l.split(' ').map(Card(_))
    if Hand(c.take(5)) > Hand(c.takeRight(5))
  } yield true).size
}

