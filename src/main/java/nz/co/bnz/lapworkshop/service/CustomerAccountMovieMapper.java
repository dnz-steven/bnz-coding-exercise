package nz.co.bnz.lapworkshop.service;

import nz.co.bnz.lapworkshop.rest.model.Account;
import nz.co.bnz.lapworkshop.rest.model.CustomerAccount;
import nz.co.bnz.lapworkshop.rest.model.CustomerMovie;
import nz.co.bnz.lapworkshop.service.movie.MovieService;
import nz.co.bnz.lapworkshop.service.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomerAccountMovieMapper {

    public CustomerMovie toCustomerMovie(Movie movie) {
        var customerMovie = new CustomerMovie();
        customerMovie.setId(movie.getId());
        customerMovie.setName(movie.getMovie());
        customerMovie.setRating(movie.getRating());
        return customerMovie;
    }
}
