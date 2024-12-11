package me.project.bankingservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistBankAccountRepository extends JpaRepository<RegistBankAccountEntity, String> {
}
