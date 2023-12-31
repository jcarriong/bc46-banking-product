package com.nttdata.bc46bankingproduct.controller;

import com.nttdata.bc46bankingproduct.model.BankingProduct;
import com.nttdata.bc46bankingproduct.service.BankingProductService;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Ntt Data - Top Employer 2023.
 * Todos los derechos Reservados.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class BankingProductController {

  @Autowired
  private BankingProductService bankingProductService;

  /**
   * Consultar todos los tipos de productos bancarios del maestro.
   **/
  @GetMapping("/findAll")
  public Flux<BankingProduct> findAll() {
    log.info("All banking products were consulted");
    return bankingProductService.findAll()
        .doOnNext(bankingProduct -> bankingProduct.toString());
  }

  /**
   * Consultar por Id de producto.
   **/
  @GetMapping("/findById/{id}")
  public Mono<ResponseEntity<BankingProduct>> findById(@PathVariable("id") String id) {
    log.info("Banking product consulted by id " + id);
    return bankingProductService.findById(id)
        .map(ResponseEntity::ok)
        .switchIfEmpty(Mono.error(() -> new RuntimeException("Datos del producto no encontrado")));

  }

  /**
   * Crear un tipo de producto que ofrece el banco: Pasivos (cuentas bancarias) o activos (créditos)
   **/
  @PostMapping("/saveProduct")
  public Mono<ResponseEntity<BankingProduct>> save(@RequestBody BankingProduct bankingProduct) {
    log.info("A bank customer was created");
    bankingProduct.setCreationDatetime(LocalDateTime.now());
    return bankingProductService.save(bankingProduct)
        .map(bc -> new ResponseEntity<>(bc, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Actualizar un tipo de productos bancario del maestro.
   **/
  @PutMapping("/updateProduct/{idProduct}")
  public Mono<ResponseEntity<BankingProduct>> update(@RequestBody BankingProduct bankingProduct,
                                                     @PathVariable("idProduct") String idProduct) {
    log.info("A banking product was changed");
    return bankingProductService.updateProduct(bankingProduct, idProduct)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  /**
   * Eliminar un tipo de productos bancario del maestro.
   **/
  @DeleteMapping("/deleteProduct/{idProduct}")
  public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable("idProduct") String idProduct) {
    log.info("A banking product was deleted");
    return bankingProductService.deleteProduct(idProduct)
        .map(bankingProduct -> ResponseEntity.ok().<Void>build())
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
