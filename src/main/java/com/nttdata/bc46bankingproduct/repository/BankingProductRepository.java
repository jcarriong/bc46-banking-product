package com.nttdata.bc46bankingproduct.repository;

import com.nttdata.bc46bankingproduct.model.BankingProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductRepository extends ReactiveMongoRepository<BankingProduct, String> {
}
