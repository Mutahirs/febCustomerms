package CustomerMS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "Customerms")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @Column(name = "phone_Number")
    long phoneNumber;
    String address1;
    String address2;
    @Column(name = "email_Id")
    String emailId;
    @Column(name = "customer_Id")
    int customerId;
    @Column(name = "pan_Card")
    String panCard;
    String dob;
    String gender;
    String adhaar;
    String voter_id;
    String driving_license;
    String passport;
    String college_id;
    String passbook;
    String tom_hardy;
    String tom_cruise;
}



