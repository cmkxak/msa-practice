package me.project.bankingservice.adapter.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RegistBankAccountEntity {

    @Id
    @GeneratedValue
    private String registBankAccountId;
    private String memberId;
    private String bankName;
    private String bankAccountNumber;
    private boolean linkedStatus;


    public RegistBankAccountEntity(String memberId, String bankName, String bankAccountNumber, boolean linkedStatus) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatus = linkedStatus;
    }

    @Override
    public String toString() {
        return "RegistBankAccountEntity{" +
                "registBankAccountId='" + registBankAccountId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatus=" + linkedStatus +
                '}';
    }
}
