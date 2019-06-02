package essential.classes

class Film(val name: String,
           val yearOfRelease: Int,
           val imdbRating: Double,
           val director: Director) {

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  def directorsAge: String =
    s"Age of the director at the me of release $yearOfRelease - ${director.yearOfBirth}"

  def isDirectedBy(dir: Director): Boolean = dir == director
}
