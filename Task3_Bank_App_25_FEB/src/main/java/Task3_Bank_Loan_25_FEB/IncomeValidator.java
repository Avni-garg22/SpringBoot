package Task3_Bank_Loan_25_FEB;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator {

    @Override
    public boolean validateLoan(double amount) {
        System.out.println("Validating using Income...");
        return amount <= 1000000;
    }
}