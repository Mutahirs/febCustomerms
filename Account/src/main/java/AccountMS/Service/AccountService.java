package AccountMS.Service;


import AccountMS.Entity.Account;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface AccountService {

     //public Account save(Account account);

    List<Account> fetchAccountsList();

    public Account updateAccount(Account account, int accountNumber);
    public Account getAccount(int accountNumber);
    void deleteAccount(int accountNumber);

    Account addAccount(Account account);


}