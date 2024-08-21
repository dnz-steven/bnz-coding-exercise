package nz.co.bnz.lapworkshop.service.movie;

import nz.co.bnz.lapworkshop.common.BnzRestClient;
import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import nz.co.bnz.lapworkshop.service.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nz.co.bnz.lapworkshop.service.movie.common.Constants.*;

@Service("DummyMovieAdapter")
public class DummyMovieAdapter implements MovieService {

    private final BnzRestClient bnzRestClient;

    @Autowired
    public DummyMovieAdapter() {
        this.bnzRestClient = new BnzRestClient(DUMMY_MOVIE_API_BASE_URL);
    }

    @Override
    public List<Movie> getAllMovies(int sizeLimit) throws UpstreamApiException {
        List<Movie> movies = bnzRestClient.get(DUMMY_MOVIE_API_MOVIE_URL,
                new ParameterizedTypeReference<List<Movie>>() {});
        return movies.size() > sizeLimit ? movies.subList(0, sizeLimit) : movies;
    }

}
