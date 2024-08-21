package nz.co.bnz.lapworkshop.rest.model;

import nz.co.bnz.lapworkshop.service.movie.model.Movie;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public class CustomerMovie {

    private int id;
    private String name;
    private double rating;

    public CustomerMovie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}