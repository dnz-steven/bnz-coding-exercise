package nz.co.bnz.lapworkshop.service.movie;

import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import nz.co.bnz.lapworkshop.service.movie.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies(int sizeLimit) throws UpstreamApiException;

}
