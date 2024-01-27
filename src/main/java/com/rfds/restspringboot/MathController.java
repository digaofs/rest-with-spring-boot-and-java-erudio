package com.rfds.restspringboot;

import com.rfds.restspringboot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        validateNumber(numberOne);
        validateNumber(numberTwo);
        return executeOperationOnNumbers(MathOperations.SUM, numberOne, numberTwo);
    }

    @RequestMapping(value="/subtract/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        validateNumber(numberOne);
        validateNumber(numberTwo);
        return executeOperationOnNumbers(MathOperations.SUBTRACT, numberOne, numberTwo);
    }

    @RequestMapping(value="/multiply/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double multiply(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        validateNumber(numberOne);
        validateNumber(numberTwo);
        return executeOperationOnNumbers(MathOperations.MULTIPLY, numberOne, numberTwo);
    }

    @RequestMapping(value="/divide/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double divide(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        validateNumber(numberOne);
        validateNumber(numberTwo);
        return executeOperationOnNumbers(MathOperations.DIVIDE, numberOne, numberTwo);
    }

    @RequestMapping(value="/average/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                         @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        validateNumber(numberOne);
        validateNumber(numberTwo);
        return executeOperationOnNumbers(MathOperations.AVERAGE, numberOne, numberTwo);
    }

    @RequestMapping(value="/sqrt/{numberOne}", method= RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "numberOne") String numberOne) throws Exception{
        validateNumber(numberOne);
        return executeOperationOnNumbers(MathOperations.SQUARE_ROOT, numberOne, null);
    }

    private enum MathOperations{
        SUM,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        AVERAGE,
        SQUARE_ROOT
    }

    private Double executeOperationOnNumbers(MathOperations operation, String numberOne, String numberTwo){
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

    private void validateNumber(String numberString){
        if(!isNumeric(numberString)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null ) return 0D;
        String number = strNumber.replace(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null ) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
