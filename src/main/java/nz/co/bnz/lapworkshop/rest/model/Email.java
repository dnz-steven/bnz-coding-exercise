package nz.co.bnz.lapworkshop.rest.model;

import nz.co.bnz.lapworkshop.service.movie.model.Movie;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public class Email {

    private String address;

    public Email() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}