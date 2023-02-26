package AccountMS.Service;


import AccountMS.Entity.Account;
import AccountMS.Exception.BusinessException;
import AccountMS.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceimpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {

        if (account.getAccountType().isEmpty()) {
            throw new BusinessException("601", "Give proper account holder name, its blank ");
        }
        try{
            return accountRepository.save(account);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("602", "Given account Holder name is null " + e.getMessage());
        }
        catch (Exception e) {


            throw new BusinessException("603", "Something went Wrong " + e.getMessage());
        }
    }



    @Override
    public List<Account> fetchAccountsList() {
        List<Account> accList= null;
        try {
            accList=accountRepository.findAll();
        }
        catch (Exception e) {
            throw new BusinessException("604", "Something went wrong while fetching all accounts" + e.getMessage());
        }
        if (accList.isEmpty())
            throw new BusinessException("604", "Its completely empty");
        return accList;
    }


    @Override
    public Account updateAccount(Account account, int accountNumber) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(int accountNumber) {
        try {
            return accountRepository.findById(accountNumber).get();
        } catch (IllegalArgumentException e) {
            throw new BusinessException("606", "Given account number is null, pls provide valid acc number" + e.getMessage());
        } catch (java.util.NoSuchElementException e) {
            throw new BusinessException("607", "Given Account number doesn't exist in DB");
        }
    }

    @Override
    public void deleteAccount(int accountNumber) {
        try {
            accountRepository.deleteById(accountNumber);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("608", "Given account number is null,provide valid acc no." + e.getMessage());
        }
    }


}