package com.hms.accounts.request;

import com.hms.accounts.entity.DrugSale;
import com.hms.accounts.entity.DrugSaleReceipt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DrugSaleRequest {
List<DrugSale> drugSaleList;
}
