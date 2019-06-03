package essential.classes

final case class Film(name: String,
                      yearOfRelease: Int,
                      imdbRating: Double,
                      director: Director) {

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film = {
    Film(name, yearOfRelease, imdbRating, director)
  }

  def directorsAge: String =
    s"Age of the director at the me of release $yearOfRelease - ${director.yearOfBirth}"

  def isDirectedBy(dir: Director): Boolean = dir == director
}
