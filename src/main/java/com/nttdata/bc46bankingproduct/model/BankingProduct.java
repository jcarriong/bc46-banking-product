package com.nttdata.bc46bankingproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Ntt Data - Top Employer 2023.
 * Todos los derechos Reservados.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankingProduct")
public class BankingProduct extends BaseAuditDto {

  @Id
  private String idProduct;
  @NonNull
  private String productTypeCode; //PAS O ACT
  @NonNull
  private String productCategory; //Cuentas bancarias / Tarjetas de crédito
  private String productName; //Ahorro, Cuenta corriente, Plazo Fijo / Personal, Empresarial
  private Integer maintenance; //comisión de mantenimiento
  private Integer movementLimit; //límite de movimientos
  private Float transactionFee; //comisión x transacción

}
