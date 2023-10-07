package com.nttdata.bc46bankingproduct.model;

import lombok.*;
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
  private String productType; //"pasivo" para cuentas bancarias, "activo" para créditos
  @NonNull
  private String productCategory; //cuentas bancarias / créditos
  private String productName; //Ahorro, Cuenta corriente, Plazo Fijo / Personal, Empresarial
  private Boolean hasMaintenanceFee; //¿Posee comisión de mantenimiento? True|False
  private Boolean hasUnlimitedMovements; //¿Tiene limite de movimientos mensuales? True|False
  //solo se permite un crédito por persona y más de un crédito por empresa.
  private Integer maxCreditsByType;
  private String description;
  /*private Integer maintenance; //comisión de mantenimiento
  private Integer movementLimit; //límite de movimientos
  private Float transactionFee; //comisión x transacción*/

}
