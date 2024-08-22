package co.nz.deloitte.customerfeedback.service;

import com.example.demo.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    CustomerFeedbackRepository customerFeedbackRepository

    public Feedback getCustomerFeedbackById(Long id) {
        return customerFeedbackRepository.getCustomerFeedbackById(id);
    }

    public Feedback addCustomerFeedback(CustomerFeedback customerFeedback) {
        return customerFeedbackRepository.addCustomerFeedback(customerFeedback)
    }
}