package structural.adapterPattern.practice;

import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private Integer id;
    private double balance;
    private String accName;
    private String accNumber;
    private Date cratedDate;
}
