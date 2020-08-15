package jp.ed.nnn.nightcoreplayer

import javafx.scene.media.Media

import scala.beans.BeanProperty

class Movie {

  @BeanProperty
  var id: Long = _

  @BeanProperty
  var fileName: String = _

  @BeanProperty
  var time : String = _

  @BeanProperty
  var filePath :String = _

  @BeanProperty
  var media : Media = _

  def canEqual(other: Any): Boolean = other.isInstanceOf[Movie]

  override def equals(other: Any): Boolean = other match {
    case that: Movie =>
      (that canEqual this) &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

  object Movie {
    def apply(id:Long, fileName:String, time:String, filePath: String, media: Media): Movie = {
      val movie = new Movie
      movie.setId(id)
      movie.setFileName(fileName)
      movie.setTime(time)
      movie.setFilePath(filePath)
      movie.setMedia(media)
      movie
    }
}
