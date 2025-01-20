package System_Design.LLD.BookMyShow;

public class Movie {
    int movieId;
    String movieName;
    int movieDurationInMinute;

    //other dtails like Genere Language etc.


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDurationInMinute() {
        return movieDurationInMinute;
    }

    public void setMovieDurationInMinute(int movieDurationInMinute) {
        this.movieDurationInMinute = movieDurationInMinute;
    }
}
