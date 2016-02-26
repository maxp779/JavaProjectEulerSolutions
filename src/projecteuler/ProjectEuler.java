/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author max
 */
public class ProjectEuler
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        try {
//            problem3(600851475143L,4);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ProjectEuler.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ExecutionException ex) {
//            Logger.getLogger(ProjectEuler.class.getName()).log(Level.SEVERE, null, ex);
//        }

        problem3("600851475143");

        //System.out.println(isPrimeThreaded(2L,4));
        //problem11();
        //System.out.println(findPrimesEfficient(2000000L));
        //System.out.println(isPalindrome(997798));
        //System.out.println(isPrime(6008514701L));
    }

    //Find the sum of all the multiples of 3 or 5 below aNumber
    public static void problem1(int aNumber)
    {
        Set<Integer> multiplesSet;
        multiplesSet = new HashSet<Integer>();
        Integer result = 0;

        //multiples of 3
        Integer count = 3;
        while (count < aNumber)
        {
            multiplesSet.add(count);
            count = count + 3;
        }

        //multiples of 5
        count = 5;
        while (count < aNumber)
        {
            multiplesSet.add(count);
            count = count + 5;
        }

        for (Integer aMultiple : multiplesSet)
        {
            result = result + aMultiple;
        }
        System.out.println(result);

    }

    //By considering the terms in the Fibonacci sequence whose values do not 
    //exceed four million, find the sum of the even-valued terms.  
    public static void problem2()
    {
        List<Integer> fibonacciNumbersList = new ArrayList<>();
        fibonacciNumbersList.add(1);
        fibonacciNumbersList.add(2);
        Integer currentFibonacciNumber = 0;
        Integer currentIndex = 1;
        Integer sumOfEvens = 0;

        while (currentFibonacciNumber < 4000000)
        {
            currentFibonacciNumber = fibonacciNumbersList.get(currentIndex)
                    + fibonacciNumbersList.get(currentIndex - 1);
            if (currentFibonacciNumber < 4000000)
            {
                fibonacciNumbersList.add(currentFibonacciNumber);
            }
            currentIndex++;
        }

        for (Integer aNumber : fibonacciNumbersList)
        {
            if (aNumber % 2 == 0)
            {
                sumOfEvens = sumOfEvens + aNumber;
            }
        }
        System.out.println(sumOfEvens);

    }

    public static void problem3(String inputString)
    {
        long startTime = System.currentTimeMillis();
        BigInteger inputBigInteger = new BigInteger(inputString);
        List<BigInteger> primeNumbers = new ArrayList<>();

        //if number is even add the prime number 2
        if (inputBigInteger.mod(new BigInteger("2")) == BigInteger.ZERO)
        {
            primeNumbers.add(new BigInteger("2"));
        }

        System.out.println("getting prime numbers");
        boolean calculating = true;
        BigInteger currentBigInteger = new BigInteger("2");
        while (calculating)
        {
            //if (isPrime(currentBigInteger))
            //{
                primeNumbers.add(currentBigInteger);
            //}

            currentBigInteger = currentBigInteger.nextProbablePrime();
            
            if(currentBigInteger.compareTo(inputBigInteger) > 0)
            {
                calculating = false;
            }
        }

        System.out.println("getting prime factors");
        List<BigInteger> primeFactors = new ArrayList<>();
        for (BigInteger aPrimeNumber : primeNumbers)
        {
            if (inputBigInteger.mod(aPrimeNumber) == BigInteger.ZERO)
            {
                primeFactors.add(aPrimeNumber);
            }
        }

        BigInteger currentLargest = new BigInteger("2");
        for (BigInteger aPrimeFactor : primeFactors)
        {
            if (aPrimeFactor.compareTo(currentLargest) > 0)
            {
                currentLargest = aPrimeFactor;
            }
        }

        System.out.println("the largest prime factor is: " + currentLargest);
        System.out.println("time taken: " + (System.currentTimeMillis() - startTime));
    }

    public static int problem4()
    {
        int firstNumber = 999;
        int secondNumber = 999;
        int product = 0;
        int largestPalindrome = 0;
        boolean continueLoop = true;
        List<Integer> palindromeList = new ArrayList<>();

        while (firstNumber > 0 && continueLoop)
        {
            secondNumber = firstNumber;
            while (secondNumber > 0 && continueLoop)
            {
                product = firstNumber * secondNumber;
                //System.out.println(secondNumber);
                if (HelperMethods.isPalindrome(product))
                {
                    palindromeList.add(product);
                }
                secondNumber--;
            }
            firstNumber--;
        }

        for (Integer aPalindrome : palindromeList)
        {
            if (aPalindrome > largestPalindrome)
            {
                largestPalindrome = aPalindrome;
            }
        }

        return largestPalindrome;
    }

    public static Long problem5()
    {
        Long currentNumber = 20L;
        Long outputNumber = 0L;
        boolean foundNumber = false;
        int[] numArray = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}; 
        
        while (!foundNumber)
        {
            
            for(int arrayNumber : numArray)
            {
                if(currentNumber % arrayNumber ==0)
                {
                    foundNumber = true;
                    outputNumber = currentNumber;
                }
                else
                {                 
                    currentNumber = currentNumber + 20;
                }
            }
        }
        return outputNumber;
    }

    public static void problem6()
    {
        List<Long> numberList = new LinkedList<>();
        Long returnValue = 0L;
        Long sumOfSquares = 0L;
        Long sqaureOfSums = 0L;

        Long aNumber = 1L;
        for (int count = 0; count < 100; count++)
        {
            numberList.add(aNumber);
            aNumber++;
        }

        sumOfSquares = HelperMethods.sumOfSquares(numberList);
        sqaureOfSums = HelperMethods.squareOfSums(numberList);
        returnValue = sqaureOfSums - sumOfSquares;
        System.out.println(returnValue);
    }

    public static void problem7()
    {
        //10,001st would be index number 10,000
        List<Long> primeList = new ArrayList<>();

        Long currentNumber = 2L;
        while (primeList.size() < 10001)
        {
            if (HelperMethods.isPrime(currentNumber))
            {
                primeList.add(currentNumber);
            }
            currentNumber++;
        }
        System.out.println(primeList.get(10000));
    }

    public static void problem8()
    {
        String aNumberString = "73167176531330624919225119674426574742355349194934"
                + "96983520312774506326239578318016984801869478851843"
                + "85861560789112949495459501737958331952853208805511"
                + "12540698747158523863050715693290963295227443043557"
                + "66896648950445244523161731856403098711121722383113"
                + "62229893423380308135336276614282806444486645238749"
                + "30358907296290491560440772390713810515859307960866"
                + "70172427121883998797908792274921901699720888093776"
                + "65727333001053367881220235421809751254540594752243"
                + "52584907711670556013604839586446706324415722155397"
                + "53697817977846174064955149290862569321978468622482"
                + "83972241375657056057490261407972968652414535100474"
                + "82166370484403199890008895243450658541227588666881"
                + "16427171479924442928230863465674813919123162824586"
                + "17866458359124566529476545682848912883142607690042"
                + "24219022671055626321111109370544217506941658960408"
                + "07198403850962455444362981230987879927244284909188"
                + "84580156166097919133875499200524063689912560717606"
                + "05886116467109405077541002256983155200055935729725"
                + "71636269561882670428252483600823257530420752963450";

        List<Long> numberList = new LinkedList<>();
        char[] numberArray = aNumberString.toCharArray();
        for (int count = 0; count < numberArray.length; count++)
        {
            char currentChar = numberArray[count];
            String currentString = String.valueOf(currentChar);
            Long currentInteger = Long.parseLong(currentString);
            numberList.add(currentInteger);
        }
        // System.out.println(numberList);
        Integer currentIndex = 0;
        Integer currentStartIndex = 0;
        Long currentLargestProduct = 0L;
        Long currentProduct = 0L; //maybe 1 i dont know test it

        while (currentStartIndex < numberList.size() - 12)
        {
            //System.out.println(currentStartIndex);
            currentIndex = currentStartIndex;
            currentProduct = numberList.get(currentIndex);
            currentIndex++;
            //System.out.println(currentProduct);
            while (currentIndex < currentStartIndex + 13)
            {
                currentProduct = currentProduct * numberList.get(currentIndex);
                currentIndex++;
                //System.out.println(currentProduct);
            }

            if (currentProduct > currentLargestProduct)
            {
                currentLargestProduct = currentProduct;
            }

            currentStartIndex++;
        }
        System.out.println(currentLargestProduct);
    }

        public static void problem9()
    {
        Long a = 1L;
        Long b = 2L;
        Long c = 3L;
        Long aSquare;
        Long bSquare;
        Long cSquare;

        while (c <= 1000)
        {
            b = 1L;
            while (b <= 1000)
            {
                a = 1L;
                while (a <= 1000)
                {
                    aSquare = a * a;
                    bSquare = b * b;
                    cSquare = c * c;

                    if (aSquare + bSquare == cSquare)
                    {
                        if (a + b + c == 1000)
                        {
                            System.out.println("Triplet found!");
                            System.out.println(a + " " + b + " " + c);
                            System.out.println("Product is " + (a * b * c));
                        }
                    }
                    a++;
                }
                b++;
            }
            c++;
        }
    }
    
    public static void problem10()
    {
        List<MarkedNumber> aList = HelperMethods.findPrimeNumbers(2000000L);

        Long total = 0L;

        for (MarkedNumber aNumber : aList)
        {
            total = total + aNumber.getNumber();
        }
        System.out.println(total);
    }

    public static void problem11()
    {
        String numbersForList
                = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
                + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
                + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
                + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
                + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
                + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
                + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
                + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
                + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
                + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
                + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
                + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
                + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
                + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
                + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
                + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
                + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
                + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
                + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
                + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
        List<ArrayList> mainList = new ArrayList<>();
        List<Long> largestProductMultiples = new ArrayList<>();
        List<Long> currentProductMultiples = new ArrayList<>();
        List<Long> currentList;
        String currentNumber;
        Scanner numberStringScanner = new Scanner(numbersForList);
        numberStringScanner.useDelimiter(" ");
        Long currentLargestProduct = 0L;

        for (int count = 0; count < 20; count++)
        {
            mainList.add(new ArrayList<Long>());
            currentList = mainList.get(count);

            for (int count2 = 0; count2 < 20; count2++)
            {
                currentNumber = numberStringScanner.next();
                currentList.add(Long.parseLong(currentNumber));
            }
        }
        numberStringScanner.close();

        Integer count = 0;
        Integer lengthToCheck = 4;
        Integer mainListCount = 0;
        Integer innerListCount = 0;
        Integer currentIndex = 0;
        Long potientialLargestProduct = 0L;
        List<Long> testList = new ArrayList<>(); //used to test output

        /**
         * Check along numbers
         */
        //mainList array loop
        while (mainListCount < mainList.size())
        {
            currentList = mainList.get(mainListCount);
            innerListCount = 0;

            //mainList sub array loop
            while (innerListCount < mainList.size() - (lengthToCheck - 1))
            {
                testList.clear();
                currentIndex = innerListCount;

                //add current multiples to array
                currentProductMultiples.clear();
                for (count = 0; count < lengthToCheck; count++)
                {
                    currentProductMultiples.add(currentList.get(currentIndex + count));
                }

                //find product of current multiples
                potientialLargestProduct = 1L;
                for (Long aMultiple : currentProductMultiples)
                {
                    potientialLargestProduct = potientialLargestProduct * aMultiple;
                }

//                potientialLargestProduct = currentList.get(currentIndex)
//                        *currentList.get(currentIndex+1)
//                        *currentList.get(currentIndex+2)
//                        *currentList.get(currentIndex+3);
                if (potientialLargestProduct > currentLargestProduct)
                {
                    currentLargestProduct = potientialLargestProduct;
                    largestProductMultiples.clear();
                    largestProductMultiples = currentProductMultiples;
                }

                innerListCount++;
            }
            mainListCount++;
        }

        System.out.println("Largest after along check: " + currentLargestProduct + " " + largestProductMultiples);

        /**
         * Check down numbers
         */
        mainListCount = 0;
        innerListCount = 0;

        //mainList array loop
        while (mainListCount < mainList.size() - (lengthToCheck - 1))
        {
            innerListCount = 0;
            //mainList sub array loop
            while (innerListCount < mainList.size())
            {
                //add current multiples to array
                currentProductMultiples.clear();
                for (count = 0; count < lengthToCheck; count++)
                {
                    currentProductMultiples.add((Long) mainList.get(mainListCount + count).get(innerListCount));
                }

                //find product of current multiples
                potientialLargestProduct = 1L;
                for (Long aMultiple : currentProductMultiples)
                {
                    potientialLargestProduct = potientialLargestProduct * aMultiple;
                }

//                potientialLargestProduct = (Long) mainList.get(mainListCount).get(innerListCount) 
//                * (Long) mainList.get(mainListCount+1).get(innerListCount)
//                * (Long) mainList.get(mainListCount+2).get(innerListCount)
//                * (Long) mainList.get(mainListCount+3).get(innerListCount);
                if (potientialLargestProduct > currentLargestProduct)
                {
                    currentLargestProduct = potientialLargestProduct;
                    largestProductMultiples.clear();
                    largestProductMultiples = currentProductMultiples;
                }

                innerListCount++;
            }

            mainListCount++;
        }

        System.out.println("Largest after down check: " + currentLargestProduct + " " + largestProductMultiples);

        /**
         * Check diagonal numbers
         */
        //indexs 3 to 16 for 20x20 grid
        mainListCount = 0;
        innerListCount = 0;

        //mainList array loop
        while (mainListCount < mainList.size() - (lengthToCheck - 1))
        {
            innerListCount = lengthToCheck - 1;
            //mainList sub array loop
            while (innerListCount < mainList.size() - (lengthToCheck - 1))
            {

                //**DIAGONAL LEFT**
                //add current multiples to array
                currentProductMultiples.clear();
                for (count = 0; count < lengthToCheck; count++)
                {
                    currentProductMultiples.add((Long) mainList.get(mainListCount + count).get(innerListCount - count));
                }

                //find product of current multiples
                potientialLargestProduct = 1L;
                for (Long aMultiple : currentProductMultiples)
                {
                    potientialLargestProduct = potientialLargestProduct * aMultiple;
                }

//                potientialLargestProduct = (Long) mainList.get(mainListCount).get(innerListCount) 
//                * (Long) mainList.get(mainListCount+1).get(innerListCount-1)
//                * (Long) mainList.get(mainListCount+2).get(innerListCount-2)
//                * (Long) mainList.get(mainListCount+3).get(innerListCount-3);
                if (potientialLargestProduct > currentLargestProduct)
                {
                    currentLargestProduct = potientialLargestProduct;
                    largestProductMultiples.clear();
                    largestProductMultiples = currentProductMultiples;
                }

                //**DIAGONAL RIGHT**
                //add current multiples to array
                currentProductMultiples.clear();
                for (count = 0; count < lengthToCheck; count++)
                {
                    currentProductMultiples.add((Long) mainList.get(mainListCount + count).get(innerListCount + count));
                }

                //find product of current multiples
                potientialLargestProduct = 1L;
                for (Long aMultiple : currentProductMultiples)
                {
                    potientialLargestProduct = potientialLargestProduct * aMultiple;
                }

//                potientialLargestProduct = (Long) mainList.get(mainListCount).get(innerListCount) 
//                * (Long) mainList.get(mainListCount+1).get(innerListCount+1)
//                * (Long) mainList.get(mainListCount+2).get(innerListCount+2)
//                * (Long) mainList.get(mainListCount+3).get(innerListCount+3);
                if (potientialLargestProduct > currentLargestProduct)
                {
                    currentLargestProduct = potientialLargestProduct;
                    largestProductMultiples.clear();
                    largestProductMultiples = currentProductMultiples;
                }
                innerListCount++;
            }
            mainListCount++;
        }

        System.out.println("Largest after diagonal check: " + currentLargestProduct + " " + largestProductMultiples);

    }

    public static void problem12()
    {
        Long currentTriangleNumber = 0L;
        Long currentLength = 1L;
        Long numberOfDivisors = 0L;
        Boolean foundNumber = false;
        Boolean isOddNumber = false;
        Long currentLargestDivisor = 0L;

        while (numberOfDivisors <= 500)
        {
            currentTriangleNumber = 0L;

            numberOfDivisors = 2L;
            for (Long count = 0L; count <= currentLength; count++)
            {
                currentTriangleNumber = currentTriangleNumber + count;
            }

            for (Long count = currentTriangleNumber / 2 + 1; count > 1L; count--)
            {
                if (currentTriangleNumber % count == 0)
                {
                    numberOfDivisors++;
                }
            }
            if (numberOfDivisors > currentLargestDivisor)
            {
                currentLargestDivisor = numberOfDivisors;
                System.out.println(currentLargestDivisor);
            }
            currentLength++;
//                System.out.println("Current Triangle Number: " 
//                        + currentTriangleNumber + " Number of Divisors: "
//                        + numberOfDivisors);
        }
        System.out.println(currentTriangleNumber);
    }

    public static void problem13()
    {
        String numberString = "37107287533902102798797998220837590246510135740250\n"
                + "46376937677490009712648124896970078050417018260538\n"
                + "74324986199524741059474233309513058123726617309629\n"
                + "91942213363574161572522430563301811072406154908250\n"
                + "23067588207539346171171980310421047513778063246676\n"
                + "89261670696623633820136378418383684178734361726757\n"
                + "28112879812849979408065481931592621691275889832738\n"
                + "44274228917432520321923589422876796487670272189318\n"
                + "47451445736001306439091167216856844588711603153276\n"
                + "70386486105843025439939619828917593665686757934951\n"
                + "62176457141856560629502157223196586755079324193331\n"
                + "64906352462741904929101432445813822663347944758178\n"
                + "92575867718337217661963751590579239728245598838407\n"
                + "58203565325359399008402633568948830189458628227828\n"
                + "80181199384826282014278194139940567587151170094390\n"
                + "35398664372827112653829987240784473053190104293586\n"
                + "86515506006295864861532075273371959191420517255829\n"
                + "71693888707715466499115593487603532921714970056938\n"
                + "54370070576826684624621495650076471787294438377604\n"
                + "53282654108756828443191190634694037855217779295145\n"
                + "36123272525000296071075082563815656710885258350721\n"
                + "45876576172410976447339110607218265236877223636045\n"
                + "17423706905851860660448207621209813287860733969412\n"
                + "81142660418086830619328460811191061556940512689692\n"
                + "51934325451728388641918047049293215058642563049483\n"
                + "62467221648435076201727918039944693004732956340691\n"
                + "15732444386908125794514089057706229429197107928209\n"
                + "55037687525678773091862540744969844508330393682126\n"
                + "18336384825330154686196124348767681297534375946515\n"
                + "80386287592878490201521685554828717201219257766954\n"
                + "78182833757993103614740356856449095527097864797581\n"
                + "16726320100436897842553539920931837441497806860984\n"
                + "48403098129077791799088218795327364475675590848030\n"
                + "87086987551392711854517078544161852424320693150332\n"
                + "59959406895756536782107074926966537676326235447210\n"
                + "69793950679652694742597709739166693763042633987085\n"
                + "41052684708299085211399427365734116182760315001271\n"
                + "65378607361501080857009149939512557028198746004375\n"
                + "35829035317434717326932123578154982629742552737307\n"
                + "94953759765105305946966067683156574377167401875275\n"
                + "88902802571733229619176668713819931811048770190271\n"
                + "25267680276078003013678680992525463401061632866526\n"
                + "36270218540497705585629946580636237993140746255962\n"
                + "24074486908231174977792365466257246923322810917141\n"
                + "91430288197103288597806669760892938638285025333403\n"
                + "34413065578016127815921815005561868836468420090470\n"
                + "23053081172816430487623791969842487255036638784583\n"
                + "11487696932154902810424020138335124462181441773470\n"
                + "63783299490636259666498587618221225225512486764533\n"
                + "67720186971698544312419572409913959008952310058822\n"
                + "95548255300263520781532296796249481641953868218774\n"
                + "76085327132285723110424803456124867697064507995236\n"
                + "37774242535411291684276865538926205024910326572967\n"
                + "23701913275725675285653248258265463092207058596522\n"
                + "29798860272258331913126375147341994889534765745501\n"
                + "18495701454879288984856827726077713721403798879715\n"
                + "38298203783031473527721580348144513491373226651381\n"
                + "34829543829199918180278916522431027392251122869539\n"
                + "40957953066405232632538044100059654939159879593635\n"
                + "29746152185502371307642255121183693803580388584903\n"
                + "41698116222072977186158236678424689157993532961922\n"
                + "62467957194401269043877107275048102390895523597457\n"
                + "23189706772547915061505504953922979530901129967519\n"
                + "86188088225875314529584099251203829009407770775672\n"
                + "11306739708304724483816533873502340845647058077308\n"
                + "82959174767140363198008187129011875491310547126581\n"
                + "97623331044818386269515456334926366572897563400500\n"
                + "42846280183517070527831839425882145521227251250327\n"
                + "55121603546981200581762165212827652751691296897789\n"
                + "32238195734329339946437501907836945765883352399886\n"
                + "75506164965184775180738168837861091527357929701337\n"
                + "62177842752192623401942399639168044983993173312731\n"
                + "32924185707147349566916674687634660915035914677504\n"
                + "99518671430235219628894890102423325116913619626622\n"
                + "73267460800591547471830798392868535206946944540724\n"
                + "76841822524674417161514036427982273348055556214818\n"
                + "97142617910342598647204516893989422179826088076852\n"
                + "87783646182799346313767754307809363333018982642090\n"
                + "10848802521674670883215120185883543223812876952786\n"
                + "71329612474782464538636993009049310363619763878039\n"
                + "62184073572399794223406235393808339651327408011116\n"
                + "66627891981488087797941876876144230030984490851411\n"
                + "60661826293682836764744779239180335110989069790714\n"
                + "85786944089552990653640447425576083659976645795096\n"
                + "66024396409905389607120198219976047599490197230297\n"
                + "64913982680032973156037120041377903785566085089252\n"
                + "16730939319872750275468906903707539413042652315011\n"
                + "94809377245048795150954100921645863754710598436791\n"
                + "78639167021187492431995700641917969777599028300699\n"
                + "15368713711936614952811305876380278410754449733078\n"
                + "40789923115535562561142322423255033685442488917353\n"
                + "44889911501440648020369068063960672322193204149535\n"
                + "41503128880339536053299340368006977710650566631954\n"
                + "81234880673210146739058568557934581403627822703280\n"
                + "82616570773948327592232845941706525094512325230608\n"
                + "22918802058777319719839450180888072429661980811197\n"
                + "77158542502016545090413245809786882778948721859617\n"
                + "72107838435069186155435662884062257473692284509516\n"
                + "20849603980134001723930671666823555245252804609722\n"
                + "53503534226472524250874054075591789781264330331690";

        StringBuilder currentNumberString = new StringBuilder();
        BigInteger currentNumber;
        BigInteger outputNumber = new BigInteger("0");
        char currentChar;

        for (int count = 0; count < numberString.length(); count++)
        {
            currentChar = numberString.charAt(count);
            if (Character.isDigit(currentChar))
            {
                currentNumberString.append(numberString.charAt(count));
            }

            if (currentNumberString.length() == 50)
            {
                currentNumber = new BigInteger(currentNumberString.toString());
                outputNumber = outputNumber.add(currentNumber);
                currentNumberString = new StringBuilder();
            }
        }

        System.out.println(outputNumber);
    }

    public static void problem14(int startNumber)
    {
        long currentStartingNumber = startNumber;
        long currentChainNumber;
        long currentChainLength = 0L;
        long longestChainLength = 0L;
        long longestChainNumber = 0L;

        while (currentStartingNumber != 0)
        {
            currentChainNumber = currentStartingNumber;
            currentChainLength = 0;
            System.out.println(currentChainNumber);
            while (currentChainNumber != 1)
            {
                //System.out.println(currentChainNumber);
                //if even
                if (currentChainNumber % 2 == 0)
                {
                    currentChainNumber = currentChainNumber / 2;
                } //else odd
                else
                {
                    currentChainNumber = (currentChainNumber * 3) + 1;
                }
                currentChainLength++;
            }

            if (currentChainLength > longestChainLength)
            {
                longestChainLength = currentChainLength;
                longestChainNumber = currentStartingNumber;
            }

            currentStartingNumber--;
        }

        System.out.println("Longest chain length was " + longestChainLength);
        System.out.println("Longest chain number was " + longestChainNumber);
    }

    //Dont fully understand why this works, fuck it
    public static void problem15(Long size)
    {
        List<ArrayList> mainList = new ArrayList<>();

        //adding +1 to size makes it work correctly, i dont know why
        for (int count = 0; count < size + 1; count++)
        {
            mainList.add(new ArrayList<Long>());
        }

        List<Long> startList = mainList.get(0);
        for (int count = 0; count < size + 1; count++)
        {
            startList.add(1L);
        }

        int currentList = 0;
        ArrayList<Long> currentArrayList;
        ArrayList<Long> lowerArrayList;
        long upperNumber = 0L;
        long lowerNumber = 0L;
        while (currentList + 1 < mainList.size())
        {
            currentArrayList = mainList.get(currentList);
            //System.out.println(mainList);
            //get second element in currentList
            upperNumber = currentArrayList.get(1);

            //multiply it by 2
            upperNumber = upperNumber * 2;
            //System.out.println(upperNumber);
            //get list underneath and add number to it
            lowerArrayList = mainList.get(currentList + 1);
            lowerArrayList.add(upperNumber);

            lowerNumber = upperNumber;
            for (int count = 2; count < currentArrayList.size(); count++)
            {
                lowerNumber = lowerNumber + currentArrayList.get(count);
                lowerArrayList.add(lowerNumber);
                //System.out.println(lowerNumber);
            }
            currentList++;
            lowerNumber = 0L;
        }

        System.out.println(mainList.get(mainList.size() - 1));
        //20x20 grid paths = 137846528820
    }

    public static void problem16()
    {
        BigInteger aNumber = new BigInteger("2");
        aNumber = aNumber.pow(1000);

        String aNumberString = aNumber.toString();
        int outputNumber = 0;
        for (int count = 0; count < aNumberString.length(); count++)
        {
            outputNumber = outputNumber + Character.getNumericValue(aNumberString.charAt(count));
        }

        System.out.println(outputNumber);
    }

    public static void problem17(int maxNumber)
    {
        String outputString = "";
        int currentNumber = 1;
        int numberOfChars = 0;
        char[] currentNumberCharArray;
        String currentNumberString = String.valueOf(currentNumber);

        while (currentNumber <= maxNumber)
        {
            currentNumberString = String.valueOf(currentNumber);
            currentNumberCharArray = currentNumberString.toCharArray();

            //units
            if (currentNumberCharArray.length == 1)
            {
                outputString = HelperMethods.units(currentNumberCharArray);
            }

            //teens
            if (currentNumberCharArray.length == 2 && currentNumberCharArray[0] == '1')
            {
                outputString = HelperMethods.teens(currentNumberCharArray);
            } else //twenty and up
             if (currentNumberCharArray.length == 2)
                {
                    outputString = HelperMethods.tens(currentNumberCharArray);
                    outputString = outputString + HelperMethods.units(currentNumberCharArray);
                }

            //hundreds
            if (currentNumberCharArray.length == 3)
            {
                outputString = HelperMethods.hundreds(currentNumberCharArray);
            }

            //thousands
            if (currentNumberCharArray.length == 4)
            {
                outputString = HelperMethods.thousands(currentNumberCharArray);
            }

            currentNumber++;
            numberOfChars = numberOfChars + outputString.length();
            System.out.println(outputString);
        }
        System.out.println(numberOfChars);
    }


    //WRONG!
    public static void problem18()
    {
        List<ArrayList> mainList = new ArrayList<>();
        int pyramidRows = 15;
        int numberOfNumbers = 1;

        for (int count = 0; count < 15; count++)
        {
            mainList.add(new ArrayList<Integer>());
        }
        String numbers = "75"
                + " 95 64"
                + " 17 47 82"
                + " 18 35 87 10"
                + " 20 04 82 47 65"
                + " 19 01 23 75 03 34"
                + " 88 02 77 73 07 63 67"
                + " 99 65 04 28 06 16 70 92"
                + " 41 41 26 56 83 40 80 70 33"
                + " 41 48 72 33 47 32 37 16 94 29"
                + " 53 71 44 65 25 43 91 52 97 51 14"
                + " 70 11 33 28 77 73 17 78 39 68 17 57"
                + " 91 71 52 38 17 14 91 43 58 50 27 29 48"
                + " 63 66 04 68 89 53 67 30 73 16 69 87 40 31"
                + " 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        char[] numbersCharArray = numbers.toCharArray();
        int currentArrayIndex = 0;

        Scanner aScanner = new Scanner(numbers);
        aScanner.useDelimiter(" ");
        int numberToGoInArray = 1;

        while (aScanner.hasNext())
        {
            for (int count = 0; count < numberToGoInArray; count++)
            {
                mainList.get(currentArrayIndex).add(aScanner.nextInt());
            }
            numberToGoInArray++;
            currentArrayIndex++;
        }

        int currentIndex = 0;
        List<Integer> totalNumbersList = new ArrayList<>();
        List<Integer> currentArray;
        List<Integer> nextArray;
        int nextArrayCandidate1;
        int nextArrayCandidate2;
        for (int count = 0; count < mainList.size(); count++)
        {
            currentArray = mainList.get(count);
            totalNumbersList.add(currentArray.get(currentIndex));

            //calculate next index
            if (count + 1 < mainList.size())
            {
                nextArray = mainList.get(count + 1);
                nextArrayCandidate1 = nextArray.get(currentIndex);
                nextArrayCandidate2 = nextArray.get(currentIndex + 1);

                if (nextArrayCandidate1 > nextArrayCandidate2)
                {
                    //do nothing
                }
                if (nextArrayCandidate1 < nextArrayCandidate2)
                {
                    currentIndex++;
                }
            }
        }

        System.out.println(totalNumbersList);
        int total = 0;
        for (Integer aNumber : totalNumbersList)
        {
            total = total + aNumber;
        }
        System.out.println(total);
    }

    public static void problem20(String aNumber)
    {
        BigInteger currentMultiplier = new BigInteger(aNumber);
        currentMultiplier = currentMultiplier.subtract(BigInteger.ONE);
        BigInteger currentAnswer = new BigInteger(aNumber);

        while (!currentMultiplier.equals(BigInteger.ONE))
        {
            currentAnswer = currentAnswer.multiply(currentMultiplier);
            currentMultiplier = currentMultiplier.subtract(BigInteger.ONE);
            System.out.println(currentMultiplier);
        }

        System.out.println(currentAnswer);
        String currentAnswerString = currentAnswer.toString();
        char[] answerChars = currentAnswerString.toCharArray();
        long total = 0L;
        for (char aChar : answerChars)
        {
            total = total + Character.getNumericValue(aChar);
        }
        System.out.println(total);
    }

    public static void problem19()
    {
        LocalDate currentDate = LocalDate.of(1901, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 12, 31);
        long sundayCount = 0L;

        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate))
        {
            if (currentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                    && currentDate.getDayOfMonth() == 1)
            {
                sundayCount++;
            }

            currentDate = currentDate.plusDays(1);
        }

        System.out.println(sundayCount);
    }

    public static void problem21()
    {
        Set<Long> amicableNumbersSet = new HashSet<>();
        List<Long> mainNumberDivisorsList = new LinkedList<>();
        List<Long> secondNumberDivisorsList = new LinkedList<>();

        Long mainNumber = 220L;
        Long mainNumberDivisorSum = 0L;

        Long secondNumber = 0L;
        Long secondNumberSum = 0L;

        Long mainNumberDivisor = 0L;
        Long secondNumberDivisor = 0L;

        while (mainNumber < 10000)
        {
            //System.out.println(currentNumber);
            mainNumberDivisorsList.clear();
            secondNumberDivisorsList.clear();

            mainNumberDivisorSum = 0L;
            secondNumberSum = 0L;
            mainNumberDivisor = mainNumber / 2; //should be okay?

            //get main number proper divisors
            while (mainNumberDivisor != 0)
            {
                if (mainNumber % mainNumberDivisor == 0)
                {
                    mainNumberDivisorsList.add(mainNumberDivisor);
                }
                mainNumberDivisor--;
            }

            //get sum of divisors of mainNumber
            for (Long aDivisor : mainNumberDivisorsList)
            {
                mainNumberDivisorSum = mainNumberDivisorSum + aDivisor;
            }

            secondNumberDivisor = mainNumberDivisorSum / 2;

            //check for perfect number, perfect numbers somehow
            //get added to the list, they are not amicable numbers
            if (!mainNumberDivisorSum.equals(mainNumber))
            {

                //get divisors of secondNumber
                while (secondNumberDivisor != 0)
                {
                    if (mainNumberDivisorSum % secondNumberDivisor == 0)
                    {
                        secondNumberDivisorsList.add(secondNumberDivisor);
                    }
                    secondNumberDivisor--;
                }

                //get sum of divisors of secondNumber
                for (Long aDivisor : secondNumberDivisorsList)
                {
                    secondNumberSum = secondNumberSum + aDivisor;
                }

                //amicable pair test
                if (secondNumberSum.equals(mainNumber))
                {
                    amicableNumbersSet.add(mainNumber);
                    amicableNumbersSet.add(secondNumberSum);
                }
            }
            mainNumber++;

        }

        Long output = 0L;
        //get sum of amicable numbers
        for (Long aLong : amicableNumbersSet)
        {
            output = output + aLong;
        }

        System.out.println(amicableNumbersSet);
        System.out.println("Amicable sum: " + output);
    }

    public static void problem22()
    {
        String names = "";
        try
        {
            names = new Scanner(new File("C:\\Users\\max\\Desktop\\My Programs\\NetBeansProjects\\ProjectEuler\\names.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(ProjectEuler.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<String> namesList = new ArrayList<>();
        Scanner namesListScanner = new Scanner(names);
        namesListScanner.useDelimiter(",");

        while (namesListScanner.hasNext())
        {
            namesList.add(namesListScanner.next());
        }

        //try making your own sort for string later
        Collections.sort(namesList);

        List<Long> namesValue = new ArrayList<>();
        List<Long> namesScore = new ArrayList<>();
        char[] currentNameChars;
        Long currentNameValue;
        for (String aName : namesList)
        {
            currentNameChars = aName.toCharArray();
            currentNameValue = 0L;
            for (char aChar : currentNameChars)
            {
                if (aChar != '"')
                {
                    //System.out.println(aChar);

                    //letters A-Z in unicode have values 10-35
                    //so to get alphabetical position we subtract 9
                    //The numeric value of character 'A' is 10 so to get its
                    //position 10 - 9 = 1 and 'B' is 11 so 11-9 = 2 etc
                    currentNameValue = currentNameValue + (Character.getNumericValue(aChar) - 9);
                }
            }
            namesValue.add(currentNameValue);
        }

        //get namesScores
        //AARON should = 49
        int alphabeticalPosition = 1;
        for (Long aNameValue : namesValue)
        {
            namesScore.add(aNameValue * alphabeticalPosition);
            alphabeticalPosition++;
        }

        //get total
        BigInteger total = new BigInteger("0");
        for (Long aNameScore : namesScore)
        {
            total = total.add(new BigInteger(aNameScore.toString()));
        }
        System.out.println(namesList);
        System.out.println(namesValue);
        System.out.println(namesScore);
        System.out.println(total);
    }

}
