package com.p54_g1.account_ms.repositories;

import com.p54_g1.account_ms.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
