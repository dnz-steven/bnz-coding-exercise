package co.nz.deloitte.customerfeedback.repository;

import com.example.demo.model.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {

    CustomerFeedback addCustomerFeedback(CustomerFeedback customerFeedback);

    CustomerFeedback getCustomerFeedbackById(Long customerFeedbackId);
}