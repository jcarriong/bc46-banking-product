package com.nttdata.bc46bankingproduct.service;

import com.nttdata.bc46bankingproduct.model.BankingProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Ntt Data - Top Employer 2023.
 * Todos los derechos Reservados.
 */
public interface BankingProductService {
  Flux<BankingProduct> findAll();

  Mono<BankingProduct> findById(String id);

  Mono<BankingProduct> save(BankingProduct bankingProduct);

  Mono<BankingProduct> updateProduct(BankingProduct bankingProduct, String idProduct);

  Mono<BankingProduct> deleteProduct(String idProduct);
}
