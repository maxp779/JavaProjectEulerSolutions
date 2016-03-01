/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author max
 */
public class HelperMethods
{

    public static Boolean isPalindrome(Integer aNumber)
    {
        String aNumberString = aNumber.toString();
        StringBuilder aNumberStringBuilderReversed = new StringBuilder(aNumber.toString());

        aNumberStringBuilderReversed.reverse();
        String aNumberStringReversed = aNumberStringBuilderReversed.toString();

        return aNumberString.equals(aNumberStringReversed);
    }

    public static List<MarkedNumber> findPrimeNumbers(Long input)
    {
        List<MarkedNumber> primeList = new LinkedList<>();

        Long count = 2L;
        while (count < input)
        {
            primeList.add(new MarkedNumber(count, false));
            count++;
        }

        for (MarkedNumber aNumber : primeList)
        {
            Long currentNumber = aNumber.getNumber();

            //if not prime mark the number
            if (isPrime(currentNumber))
            {
                aNumber.setMarked(true);
            }
        }

        //iterate through list and remove marked numbers
        Iterator primeListIterator = primeList.listIterator();
        while (primeListIterator.hasNext())
        {
            MarkedNumber currentNumber = (MarkedNumber) primeListIterator.next();
            if (currentNumber.getMarked())
            {
                primeListIterator.remove();
            }
        }
        return primeList;
    }

    public static boolean isPrime(String inputString)
    {
        long inputNumber = Long.parseLong(inputString);
        long currentDivisor = 2;
        double squareRoot = Math.sqrt(inputNumber);
        while (currentDivisor <= squareRoot)
        {
            if (inputNumber % currentDivisor == 0)
            {
                return false;

            } else
            {
                currentDivisor++;
            }
        }
        return true;
    }
    
    public static boolean isPrime(long inputNumber)
    {
        long currentDivisor = 2;
        double squareRoot = Math.sqrt(inputNumber);
        while (currentDivisor <= squareRoot)
        {
            if (inputNumber % currentDivisor == 0)
            {
                return false;

            } else
            {
                currentDivisor++;
            }
        }
        return true;
    }

    public static Boolean duplicateDigits(int aNumber)
    {
        String aNumberString;
        aNumberString = Integer.toString(aNumber);
        Set<Character> aSet = new HashSet<>();

        int count = 0;
        while (count < aNumberString.length())
        {
            aSet.add(aNumberString.charAt(count));
            count++;
        }

        if (aSet.size() != aNumberString.length())
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static Long sumOfSquares(List<Long> aList)
    {
        Long returnValue = 0L;

        Iterator listIterator = aList.listIterator();

        while (listIterator.hasNext())
        {
            Long currentNumber = (Long) listIterator.next();

            returnValue = returnValue + (currentNumber * currentNumber);
        }
        return returnValue;
    }

    public static Long squareOfSums(List<Long> aList)
    {
        Long returnValue = 0L;

        Iterator listIterator = aList.listIterator();

        while (listIterator.hasNext())
        {
            Long currentNumber = (Long) listIterator.next();

            returnValue = returnValue + currentNumber;
        }

        returnValue = returnValue * returnValue;
        return returnValue;
    }

    public static void tornNumber()
    {
        int startNumber = 1000;

        String aNumberString;

        int leftSide;
        int rightSide;
        int sumOfSides;
        int squareOfSum;
        List<Integer> resultsList = new ArrayList<>();

        while (startNumber < 10000)
        {

            aNumberString = Integer.toString(startNumber);
            leftSide = Integer.valueOf(aNumberString.substring(0, 2));
            rightSide = Integer.valueOf(aNumberString.substring(2));
            sumOfSides = leftSide + rightSide;
            squareOfSum = sumOfSides * sumOfSides;

            if (startNumber == squareOfSum && (HelperMethods.duplicateDigits(startNumber) == false))
            {
                resultsList.add(startNumber);
            }

            startNumber++;
        }
        System.out.println(resultsList);

    }
    
       public static String units(char[] currentNumberCharArray)
    {
        String output = "";

        switch (Integer.parseInt(String.valueOf(currentNumberCharArray[currentNumberCharArray.length - 1])))
        {
            case 1:
                output = output + "one";
                break;
            case 2:
                output = output + "two";
                break;
            case 3:
                output = output + "three";
                break;
            case 4:
                output = output + "four";
                break;
            case 5:
                output = output + "five";
                break;
            case 6:
                output = output + "six";
                break;
            case 7:
                output = output + "seven";
                break;
            case 8:
                output = output + "eight";
                break;
            case 9:
                output = output + "nine";
                break;
            default:
                break;
        }
        return output;
    }

    public static String teens(char[] currentNumberCharArray)
    {
        String output = "";

        switch (Integer.parseInt(String.valueOf(currentNumberCharArray[currentNumberCharArray.length - 1])))
        {
            case 0:
                output = output + "ten";
                break;
            case 1:
                output = output + "eleven";
                break;
            case 2:
                output = output + "twelve";
                break;
            case 3:
                output = output + "thirteen";
                break;
            case 4:
                output = output + "fourten";
                break;
            case 5:
                output = output + "fifteen";
                break;
            case 6:
                output = output + "sixteen";
                break;
            case 7:
                output = output + "seventeen";
                break;
            case 8:
                output = output + "eighteen";
                break;
            case 9:
                output = output + "nineteen";
                break;
            default:
                break;
        }
        return output;
    }

    public static String tens(char[] currentNumberCharArray)
    {
        String output = "";

        switch (Integer.parseInt(String.valueOf(currentNumberCharArray[currentNumberCharArray.length - 2])))
        {
            case 2:
                output = output + "twenty";
                break;
            case 3:
                output = output + "thirty";
                break;
            case 4:
                output = output + "forty";
                break;
            case 5:
                output = output + "fifty";
                break;
            case 6:
                output = output + "sixty";
                break;
            case 7:
                output = output + "seventy";
                break;
            case 8:
                output = output + "eighty";
                break;
            case 9:
                output = output + "ninety";
                break;
            default:
                break;
        }
        return output;
    }

    public static String hundreds(char[] currentNumberCharArray)
    {
        String output = "";

        switch (Integer.parseInt(String.valueOf(currentNumberCharArray[currentNumberCharArray.length - 3])))
        {
            case 1:
                output = output + "one";
                break;
            case 2:
                output = output + "two";
                break;
            case 3:
                output = output + "three";
                break;
            case 4:
                output = output + "four";
                break;
            case 5:
                output = output + "five";
                break;
            case 6:
                output = output + "six";
                break;
            case 7:
                output = output + "seven";
                break;
            case 8:
                output = output + "eight";
                break;
            case 9:
                output = output + "nine";
                break;
            default:
                break;
        }

        output = output + "hundred";

        if (currentNumberCharArray[currentNumberCharArray.length - 2] == '1')
        {
            output = output + "and" + teens(currentNumberCharArray);
        } else if (currentNumberCharArray[currentNumberCharArray.length - 2] > '1')
        {
            output = output + "and" + tens(currentNumberCharArray);
            output = output + units(currentNumberCharArray);
        } else if (currentNumberCharArray[currentNumberCharArray.length - 1] != '0')
        {
            output = output + "and" + units(currentNumberCharArray);
        }
        return output;
    }

    public static String thousands(char[] currentNumberCharArray)
    {
        String output = "";

        switch (Integer.parseInt(String.valueOf(currentNumberCharArray[currentNumberCharArray.length - 4])))
        {
            case 1:
                output = output + "one";
                break;
            case 2:
                output = output + "two";
                break;
            case 3:
                output = output + "three";
                break;
            case 4:
                output = output + "four";
                break;
            case 5:
                output = output + "five";
                break;
            case 6:
                output = output + "six";
                break;
            case 7:
                output = output + "seven";
                break;
            case 8:
                output = output + "eight";
                break;
            case 9:
                output = output + "nine";
                break;
            default:
                break;
        }

        output = output + "thousand";
        if (currentNumberCharArray[currentNumberCharArray.length - 3] != '0')
        {
            output = output + hundreds(currentNumberCharArray);
        } else if (currentNumberCharArray[currentNumberCharArray.length - 2] == '1')
        {
            output = output + "and" + teens(currentNumberCharArray);
        } else if (currentNumberCharArray[currentNumberCharArray.length - 2] > '1')
        {
            output = output + "and" + tens(currentNumberCharArray);
            output = output + units(currentNumberCharArray);
        } else if (currentNumberCharArray[currentNumberCharArray.length - 1] != '0')
        {
            output = output + "and" + units(currentNumberCharArray);
        }
        return output;
    }
    
        //uses sieve of eratosthenes
    public static List<Long> findPrimesEfficient(Long inputNumber)
    {
        List<MarkedNumber> numberList = new ArrayList<>();

        //populate list
        Long count = 2L;
        while (count <= inputNumber)
        {
            numberList.add(new MarkedNumber(count, true));
            count++;
        }

        Long currentPrime = 2L;
        MarkedNumber currentMarkedNumber;
        MarkedNumber potentialNewPrime;
        Integer currentIndex = 0;
        Integer currentPrimesIndex = 0;
        Integer possibleNextPrimeIndex;
        Boolean findNextPrime;
        Boolean firstLooping = true;
        Boolean continueLoop = true;
        while (continueLoop)
        {
            findNextPrime = true;

            //if all multiples of the currentPrime have been marked
            if (currentIndex > numberList.size() - 1)
            {
                possibleNextPrimeIndex = currentPrimesIndex;

                while (findNextPrime)
                {
                    potentialNewPrime = numberList.get(possibleNextPrimeIndex);
                    if (potentialNewPrime.getMarked() && potentialNewPrime.getNumber() > currentPrime)
                    {
                        currentPrime = potentialNewPrime.getNumber();
                        currentPrimesIndex = possibleNextPrimeIndex;
                        currentIndex = possibleNextPrimeIndex;
                        firstLooping = true;
                        findNextPrime = false;
                    } else
                    {
                        possibleNextPrimeIndex++;
                    }

                    //if there are no more primes in the numberList exit both loops
                    if (possibleNextPrimeIndex > numberList.size() - 1)
                    {
                        findNextPrime = false;
                        continueLoop = false;
                    }
                }
            } else
            {
                currentMarkedNumber = numberList.get(currentIndex);

                //prime numbers are the start of each looping
                //we must avoid marking them by checking to see if this is the first looping
                if (!firstLooping)
                {
                    currentMarkedNumber.setMarked(false);
                }

                currentIndex = currentIndex + currentPrime.intValue();
                firstLooping = false;
            }

        }

        //format results
        List<Long> outputList = new LinkedList<>();
        for (MarkedNumber aNumber : numberList)
        {
            if (aNumber.getMarked())
            {
                outputList.add(aNumber.getNumber());
            }
        }
        return outputList;
    }
}
