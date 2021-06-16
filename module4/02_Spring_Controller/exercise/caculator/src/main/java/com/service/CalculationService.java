package com.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService implements ICalculatorService {

    @Override
    public String calculation(double firstNum, double secondNum, String calculation) {
        String result = "";
        try {

            switch (calculation) {
                case "add":
                    result += firstNum + secondNum;
                    break;
                case "sub":
                    result += firstNum - secondNum;
                    break;
                case "mul":
                    result += firstNum * secondNum;
                    break;
                case "div":
                    if(secondNum==0) throw new Exception("error /0");
                    result += firstNum / secondNum;
                    break;
            }
        }catch (Exception e){
            result=e.getMessage();
        }
        return result;
    }
}
