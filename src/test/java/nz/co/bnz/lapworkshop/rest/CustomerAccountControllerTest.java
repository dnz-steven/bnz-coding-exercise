package nz.co.bnz.lapworkshop.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nz.co.bnz.lapworkshop.exception.UnprivilegedDataAccessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class CustomerAccountControllerTest {

    @InjectMocks CustomerAccountController customerAccountController;

    @Test
    void shouldHandleGet() {
//        try {
//            var response = customerAccountController.getClientAccount("0");
//        } catch (Exception e) {
//            assertEquals(UnprivilegedDataAccessException.class, e.getClass());
//        }
    }
}
