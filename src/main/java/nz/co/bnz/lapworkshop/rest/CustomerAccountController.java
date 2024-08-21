package nz.co.bnz.lapworkshop.rest;

import jakarta.validation.constraints.NotNull;
import nz.co.bnz.lapworkshop.exception.UnprivilegedDataAccessException;
import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import nz.co.bnz.lapworkshop.rest.model.CustomerAccount;
import nz.co.bnz.lapworkshop.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static nz.co.bnz.lapworkshop.rest.common.RestConstants.*;

@RestController
@Validated
@RequestMapping(CUSTOMER_ACCOUNT_CONTROLLER_BASE_PATH)
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @Autowired
    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @GetMapping(path = "/{customerId}", produces = CONTENT_TYPE_APPLICATION_JSON)
    public ResponseEntity<CustomerAccount> getClientAccount(
            @NotNull @PathVariable("customerId") final String customerId
    ) throws UnprivilegedDataAccessException, UpstreamApiException {
        /** see JwtAuthenticationFilter how customerId is extracted from jwt **/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String callerIdentity = (String) authentication.getPrincipal();

        if (callerIdentity == null || !callerIdentity.equalsIgnoreCase(customerId)) {
            // 403
            throw new UnprivilegedDataAccessException();
        } else {
            var customerAccount = customerAccountService.getCustomerAccount(customerId);
            return ResponseEntity.ok(customerAccount);
        }

    }

}