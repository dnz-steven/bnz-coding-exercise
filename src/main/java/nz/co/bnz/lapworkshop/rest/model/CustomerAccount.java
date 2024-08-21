package nz.co.bnz.lapworkshop.rest.model;

import nz.co.bnz.lapworkshop.service.movie.model.Movie;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public class CustomerAccount {

    private String customerId;
    private List<Account> accounts;

    private List<CustomerMovie> movies;

    public CustomerAccount(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<CustomerMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<CustomerMovie> movies) {
        this.movies = movies;
    }
}