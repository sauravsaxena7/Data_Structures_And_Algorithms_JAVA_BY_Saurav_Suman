package System_Design.LLD.BookMyShow;

import System_Design.LLD.BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre ;
    List<Theatre> allTheatre;

    TheatreController(){
        cityVsTheatre=new HashMap<>();
        allTheatre=new ArrayList<>();
    }

    void addTheatre(Theatre theatre,City city){
        //System.out.println("TheatreController addTheatre func theatre.getTheatreId: "+theatre.getTheatreId());
        allTheatre.add(theatre);
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city,theatres);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie,City city){
        //get all theatre of this city
        Map<Theatre,List<Show>> theatreVsShow =new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);

        System.out.println("TheatreController getAllShow func city: "+city);
        System.out.println("TheatreController getAllShow func movie: "+movie.getMovieName());



        //filter the theatres which run the movie

        for(Theatre theatre:theatres){
            List<Show> givenMoviesShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show: shows){
                if(show.movie.getMovieId()==movie.getMovieId()){
                    givenMoviesShows.add(show);
                }
            }

            if(!givenMoviesShows.isEmpty()){
                theatreVsShow.put(theatre,givenMoviesShows);
            }

        }
        System.out.println("TheatreController getAllShow func theatreVsShow: "+theatreVsShow);
       return theatreVsShow;
    }
}
