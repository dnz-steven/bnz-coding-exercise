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
public class CustomerFeedbackService {

    private final CustomerFeedbackRepository customerFeedbackRepository;

    @Autowired
    public CustomerFeedbackService(CustomerFeedbackRepository customerFeedbackRepository) {
        this.CustomerFeedbackRepository = customerFeedbackRepository;
    }

}
