package System_Design.LLD.BookMyShow;

import System_Design.LLD.BookMyShow.Enum.City;
import System_Design.LLD.BookMyShow.Enum.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShowDriverMain {
    MovieController movieController;
    TheatreController theatreController;


    BookMyShowDriverMain(){
        movieController = new MovieController();
        theatreController = new TheatreController();

    }

    public static void main(String[] args){
        BookMyShowDriverMain bookMyShowDriverMain = new BookMyShowDriverMain();
        bookMyShowDriverMain.initialize();

       // bookMyShowDriverMain.createBooking(City.PATNA,"MIRZAPUR");

        bookMyShowDriverMain.createBooking(City.GURGAON,"BAHUBALI");

    }

    private void createBooking(City city, String movieName) {

        //1. Search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(city);

        //2. select the movie which you want to see. i want to see MIRZAPUR
        Movie interestedMovie=null;
        for(Movie movie:movies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie=movie;
                break;
            }
        }

        //3. get all shoe of the movie in PATNA location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie,city);
       // System.out.println("showsTheatreWise: "+showsTheatreWise);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShow = entry.getValue();

        Show innterestedShow = runningShow.get(0);


        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = innterestedShow.getBookedSeatIds();

        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();

            for(Seat screenSeat:innterestedShow.getScreen().getSeatList()){
                if(screenSeat.getSeatId()==seatNumber){
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(innterestedShow);

        }else{
            //throw exception
            System.out.println("seat already booked, try again.");
            return;
        }

        System.out.println("Booking SUCCESSFUL");
    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        
        Movie movie1 = movieController.getMoviesByName("MIRZAPUR");
        Movie movie2 = movieController.getMoviesByName("BAHUBALI");
        
        Theatre inOxTheatre = new Theatre();
        inOxTheatre.setTheatreId(1);
        inOxTheatre.setScreen(createScreen());
        inOxTheatre.setCity(City.PATNA);
        List<Show> inoxShow = new ArrayList<>();

        Show inoxMoringShow = createShow(1,inOxTheatre.getScreen().get(0),movie1,13);
        Show inoxEveningShow = createShow(2,inOxTheatre.getScreen().get(0),movie2,20);

        inoxShow.add(inoxMoringShow);
        inoxShow.add(inoxEveningShow);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.PATNA);
        List<Show> pvrShows = new ArrayList<>();

        Show pvrMoringShow = createShow(1,pvrTheatre.getScreen().get(0),movie1,30);
        Show pvrEveningShow = createShow(2,pvrTheatre.getScreen().get(0),movie2,50);

        pvrShows.add(pvrEveningShow);
        pvrShows.add(pvrMoringShow);

        theatreController.addTheatre(inOxTheatre,City.PATNA);

        theatreController.addTheatre(pvrTheatre,City.GURGAON);


    }

    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setScreen(screen);
        show.setShowId(showId);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }


    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeatList(createSeats());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seatList = new ArrayList<>();
        //1 to 40 : SILVER
        for (int i=1;i<=40;i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seatList.add(seat);
        }

        //41 to 70 : GOLD
        for (int i=41;i<=70;i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seatList.add(seat);
        }

        //71 to 100 : GOLD
        for (int i=71;i<100;i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seatList.add(seat);
        }

        return seatList;

    }

    private void createMovies() {

        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("mirzapur");
        movie.setMovieDurationInMinute(180);

        Movie movie2 = new Movie();
        movie2.setMovieId(2);
        movie2.setMovieName("BAHUBALI");
        movie2.setMovieDurationInMinute(180);

        movieController.addMovie(movie,City.PATNA);
        movieController.addMovie(movie2,City.GURGAON);
    }
}
