package cc.unitmesh.untitled.demo.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private MemberEntityAccountService memberEntityAccountService;

    @Test
    public void testUpdatePaymentLimit() {
        // Given
        AccountPaymentLimitDto accountPaymentLimitDto = new AccountPaymentLimitDto();
        accountPaymentLimitDto.setAccountId(123);
        accountPaymentLimitDto.setPaymentLimit(1000);

        // When
        accountController.updatePaymentLimit(accountPaymentLimitDto);

        // Then
        verify(memberEntityAccountService).updateAccount(123, 1000);
    }
}