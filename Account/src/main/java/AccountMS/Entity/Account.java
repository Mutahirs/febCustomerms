package AccountMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Account")
public class Account {
    @Id
    @Column(name="account_Id")
    int accountId;
    @Column(name = "customer_Id")
    int customerId;
    @Column(name = "account_Number")
    int accountNumber;
    @Column(name = "account_Type")
    String accountType;
    String status;



}
