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

    @GetMapping("/getAccount/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable ("accountNumber") int accountNumber) {
        try {
            Account getAcc = accountService.getAccount(accountNumber);
            return new ResponseEntity<Account>(getAcc, HttpStatus.OK);
        } catch (BusinessException e) {
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce=new ControllerException("611","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

    }

    //Update Operation
    @PutMapping("/updateAccount/{accountNumber}")
    public Account updateAccount(@RequestBody Account account,
                                 @PathVariable("accountNumber") int accountNumber)
    {
        logger.info("updating the account details");
        return (Account) accountService.updateAccount(
                (AccountMS.Entity.Account) account, accountNumber);
    }

    // Delete operation
    @DeleteMapping("deleteAccount/{accountNumber}")
    public String deleteAccount(@PathVariable("accountNumber")
                                int accountNumber) {
        try {
            logger.info("Deleting the account");
            accountService.deleteAccount(accountNumber);
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
