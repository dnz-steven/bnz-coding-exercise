package nz.co.bnz.lapworkshop.service;

import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import nz.co.bnz.lapworkshop.persistence.repository.AccountRepository;
import nz.co.bnz.lapworkshop.rest.model.Account;
import nz.co.bnz.lapworkshop.rest.model.CustomerAccount;
import nz.co.bnz.lapworkshop.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerAccountService {

    private final MovieService movieService;
    private final CustomerAccountMovieMapper customerAccountMovieMapper;
    private final AccountRepository accountRepository;

    @Autowired
    public CustomerAccountService(@Qualifier("DummyMovieAdapter") MovieService movieService,
                                  CustomerAccountMovieMapper customerAccountMovieMapper, AccountRepository accountRepository) {
        this.movieService = movieService;
        this.customerAccountMovieMapper = customerAccountMovieMapper;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public CustomerAccount getCustomerAccount(String customerId) throws UpstreamApiException {
        if (customerId != null && customerId.endsWith("error")) {
            return null;
        } else {
            var accountEntities = accountRepository.findByType("T", PageRequest.of(0, 500));
            var accounts = accountEntities.stream().map(a -> {
                        var account = new Account();
                        account.setBalance(a.getBalance());
                        account.setAccountName("Dummy Account - $" + a.getBalance());
                        return account;
                    }).toList();

            var movies = movieService.getAllMovies(10);
            var customerMovies = movies.stream().map(customerAccountMovieMapper::toCustomerMovie).toList();
            var customerAccount = new CustomerAccount(customerId);
            customerAccount.setAccounts(accounts);
            customerAccount.setMovies(customerMovies);
            return customerAccount;
        }
    }
}
