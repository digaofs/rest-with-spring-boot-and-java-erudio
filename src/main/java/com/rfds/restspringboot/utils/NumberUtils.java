package com.rfds.restspringboot.utils;

import com.rfds.restspringboot.exceptions.UnsupportedMathOperationException;

public class NumberUtils {
    public static void validateNumber(String numberString){
        if(!isNumeric(numberString)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null ) return 0D;
        String number = strNumber.replace(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null ) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double executeOperationOnNumbers(MathOperations operation, String numberOne, String numberTwo){
        Double numberOneDouble = convertToDouble(numberOne);
        Double numberTwoDouble = convertToDouble(numberTwo);

        switch (operation){
            case SUM -> {return numberOneDouble + numberTwoDouble;}
            case SUBTRACT -> {return numberOneDouble - numberTwoDouble;}
            case MULTIPLY -> {return numberOneDouble * numberTwoDouble;}
            case DIVIDE -> {return numberOneDouble / numberTwoDouble;}
            case AVERAGE -> {return (numberOneDouble + numberTwoDouble)/2;}
            case SQUARE_ROOT -> {return Math.sqrt(numberOneDouble);}
            default -> {return 0D;}
        }
    }
}
