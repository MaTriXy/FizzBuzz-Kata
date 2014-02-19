package com.pedro.fizzbuzz;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * FizzBuzzMachine it's a little piece of software created to return a String value if some of the next conditions
 * occurs.
 *
 * If the integer passed as argument it's equals to 3 or multiple of 3 FizzBuzzMachine returns Fizz.
 * If the integer passed as argument it's equals to 5 or multiple of 5 FizzBuzzMachine returns Buzz.
 * If the integer passed as argument it's multiple of 3 and 5 FizzBuzzMachine returns FizzBuzz.
 * If the integer passed as argument isn't multiple of 3 or 5 returns the number.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FizzBuzzMachine {

    /*
     * Attributes
     */
    private List<Matcher> matchers;

    /*
     * Constructor
     */

    public FizzBuzzMachine(){
        matchers = new LinkedList<Matcher>();
        matchers.add(new FizzMatcher());
        matchers.add(new BuzzMatcher());
    }

    /*
     * Public methods
     */

    /**
     * Main FizzBuzzMachine method. This method will check if the number passed as parameter is fulfilling the condition
     * and will return the Fizz, Buzz or FizzBuzz value.
     *
     * @param value to analyze.
     * @return
     *      Fizz if the value is multiple of 3
     *      Buzz if the value is multiple of 5
     *      FizzBuzz if the value is multiple of 3 and 5
     *      the value if the parameter isn't multiple of 3 or 5
     */
    public String execute(Integer value) {
        String result = "";
        result = executeMatchers(value, result);
        result = result.isEmpty() ? value.toString() : result;
        return result;
    }

    private String executeMatchers(Integer value, String result) {
        for(Matcher matcher : matchers){
            result += matcher.evaluate(value);
        }
        return result;
    }
}
