package com.rfds.restspringboot;

import com.rfds.restspringboot.utils.MathOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.rfds.restspringboot.utils.NumberUtils.executeOperationOnNumbers;
import static com.rfds.restspringboot.utils.NumberUtils.validateNumber;

@RestController
public class MathController {

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
}
