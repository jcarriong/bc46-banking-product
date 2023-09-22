package com.nttdata.bc46bankingproduct.repository;

import com.nttdata.bc46bankingproduct.model.BankingProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Ntt Data - Top Employer 2023.
 * Todos los derechos Reservados.
 */
@Repository
public interface BankingProductRepository extends ReactiveMongoRepository<BankingProduct, String> {
}
