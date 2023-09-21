package com.testsite.board.repository;

import com.testsite.board.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserAccountRepository extends JpaRepository<UserAccount,String> {
}
