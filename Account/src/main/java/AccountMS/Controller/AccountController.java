package AccountMS.Controller;


import AccountMS.Entity.Account;
import AccountMS.Exception.BusinessException;
import AccountMS.Exception.ControllerException;
import AccountMS.MicroserviceApplication;
import AccountMS.Repository.AccountRepository;
import AccountMS.Service.AccountService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AccountController {
    static Logger logger= LogManager.getLogger(MicroserviceApplication.class);
    @Autowired
    AccountService accountService;

    AccountRepository accountRepository;
    //Create Operation-adding account
    @PostMapping("/addAccount")
    public ResponseEntity<?> addAccounts(@RequestBody Account account) {
        try {
            logger.info("Adding account to database");
            Account accSaved=accountService.addAccount(account);
            return new ResponseEntity<Account>(accSaved, HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    // Read operation-getting all accounts
    @GetMapping("/getAccountDetails")
    public List<Account> getAccountList()
    {
        try{
            logger.info("Displaying all accounts");
            return (List<Account>) accountService.fetchAccountsList();
        }catch (BusinessException e){
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
            throw new ControllerException(e.getErrorCode(),e.getErrorMessage());
        }
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<?> getAccount(@PathVariable ("id") int accountId) {
        try {
            logger.info("Displaying account details by account number");
            Account getAcc = accountService.getAccount(accountId);
            return new ResponseEntity<Account>(getAcc, HttpStatus.CREATED);

        }
        catch (BusinessException e){
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e) {
            ControllerException ce=new ControllerException("611","Something went wrong in controller");
            throw new ControllerException(e.getMessage(),e.getMessage());
        }

    }

    //get account details by account number
    @GetMapping("/getByAccount/{accountNumber}")
    public List<Account> getByAccount(@PathVariable ("accountNumber") int accountNumber){
        return accountService.findByAccountNumber(accountNumber);
    }

    //Update Operation
    @PutMapping("/updateAccount/{accountId}")
    public Account updateAccount(@RequestBody Account account,
                                 @PathVariable("accountId") int accountId)
    {
        logger.info("updating the account details");
        return (Account) accountService.updateAccount(
                (AccountMS.Entity.Account) account, accountId);
    }

    // Delete operation
    @DeleteMapping("deleteAccount/{accountId}")
    public String deleteAccount(@PathVariable("accountId")
                                int accountId) {
        try {
            logger.info("Deleting the account");
            accountService.deleteAccount(accountId);
            return "Deleted Successfully";
        } catch (BusinessException e) {
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return "Account is not deleted";
        } catch (Exception e) {
            ControllerException ce=new ControllerException("612","Something went wrong in controller");
            return "Account is not deleted";
        }
    }

    }
