package co.nz.deloitte.customerfeedback.model;

public class CustomerFeedback {
    private Long id;
    private Rating rating;
    private String comments;
    private Email email;

    // Constructors, getters, setters


    // Default constructor
    public CustomerFeedback() {
    }

    // Parameterized constructor
    public CustomerFeedback(Long id, Rating rating, String comments, Email email) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.email = email;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for rating
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    // Getter and Setter for comments
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Getter and Setter for email
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation .*;

import java.util.Optional;

    @RestController
    @RequestMapping("/feedback")
    public class CustomerFeedbackController {

        @Autowired
        private CustomerFeedbackRepository customerFeedbackRepository;

        @PostMapping("/add")
        public ResponseEntity<CustomerFeedback> addFeedback(@RequestBody CustomerFeedback feedback) {
            CustomerFeedback savedFeedback = customerFeedbackRepository.save(feedback);
            return ResponseEntity.ok(savedFeedback);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CustomerFeedback> getFeedbackById(@PathVariable Long id) {
            Optional<CustomerFeedback> feedback = customerFeedbackRepository.findById(id);
            return feedback.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
    }