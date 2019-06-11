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

object Film {
  def apply(name: String,
            yearOfRelease: Int,
            imdbRating: Double,
            director: Director): Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(film1: Film, film2: Film): Film = {
    if (film1.imdbRating > film2.imdbRating) film1 else film2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if(film1.director.yearOfBirth < film2.director.yearOfBirth) film1.director else film2.director
  }
}
