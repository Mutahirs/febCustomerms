package AccountMS.Service;


import AccountMS.Entity.Account;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface AccountService {
    List<Account> fetchAccountsList();
    public Account updateAccount(Account account, int accountId);
    public Account getAccount(int accountId);
    void deleteAccount(int accountId);
    Account addAccount(Account account);
    List<Account> findByAccountNumber(int accountNumber);

}