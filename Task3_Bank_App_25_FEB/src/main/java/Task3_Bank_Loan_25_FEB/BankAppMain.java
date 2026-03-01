package Task3_Bank_Loan_25_FEB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankAppMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BankAppConfig.class);

        LoanService loanService = context.getBean(LoanService.class);

        loanService.applyLoan(300000);

        context.close();
    }
}