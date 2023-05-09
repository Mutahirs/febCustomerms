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
    int hgt;
    String country;
    double pin;
    String age;
    String weight;
    String contact_no;
    String Shahrukh;
    String salman;

}



