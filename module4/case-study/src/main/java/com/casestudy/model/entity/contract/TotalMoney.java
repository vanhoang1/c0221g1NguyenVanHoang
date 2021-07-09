package com.casestudy.model.entity.contract;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@UtilityClass
public class TotalMoney {
    public static Double getTotalMoney(Contract contract){
        return ChronoUnit.DAYS.between(contract.getStartDate(),contract.getEndDate()) * contract.getService().getRentalCosts() - contract.getDeposit();
    }
}
