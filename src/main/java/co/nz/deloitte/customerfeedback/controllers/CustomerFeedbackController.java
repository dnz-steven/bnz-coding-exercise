package co.nz.deloitte.customerfeedback.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class CustomerFeedbackController {

    @Autowired
    private CustomerFeedbackService customerFeedbackService;

    @PostMapping("/")
    public ResponseEntity<CustomerFeedback> addFeedback(@RequestBody CustomerFeedback feedback) {
        CustomerFeedback savedFeedback = customerFeedbackService.addCustomerFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerFeedback> getFeedbackById(@PathVariable Long id) {
        Optional<CustomerFeedback> feedback = customerFeedbackService.findById(id);
        return feedback.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}