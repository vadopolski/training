package leetcode.design

case class User(userId: Int, followers: List[User] = Nil, followed: List[User] = Nil, postedNews: List[Int])

class Twitter (var userList: List[User] = Nil) {

  /** Initialize your data structure here. */
  /** Compose a new tweet. */
  def postTweet(userId: Int, tweetId: Int) = userList match {
    case Nil => List()
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  def getNewsFeed(userId: Int): List[Int] = ???

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  def follow(followerId: Int, followeeId: Int) {}

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  def unfollow(followerId: Int, followeeId: Int) {}

}

object Twitter {
  def apply(): Twitter = new Twitter()

  def main(args: Array[String]): Unit = {
    val twitter = Twitter()
    // User 1 posts a new tweet (id = 5).// User 1 posts a new tweet (id = 5).
    twitter.postTweet (1, 5)

    // User 1's news feed should return a list with 1 tweet id -> [5].
    println(twitter.getNewsFeed (1))
    // User 1 follows user 2.
    twitter.follow (1, 2)
    // User 2 posts a new tweet (id = 6).
    twitter.postTweet (2, 6)

    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    println(twitter.getNewsFeed (1))

    // User 1 unfollows user 2.
    twitter.unfollow (1, 2)
    // User 1's news feed should return a list with 1 tweet id -> [5],
    // since user 1 is no longer following user 2.
  }
}