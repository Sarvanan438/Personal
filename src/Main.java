import java.util.Arrays;

/**
 * Naming conventions
 * 1. use intention revealing names : use names that provide context/intent of what it does or what operations can be done using it
 * 2. Avoid names which provide false context: Like using userList where the actual data structure is a map this gives wrong info
 * 3. make names meaningfully disntiguishable : So if you have two constructs that needs to differ name them in such a way that they clearly
 *                                              distinguish the difference
 *                                              Ex: Accounts And AccountsInfo both look similar without the function construct
 *                                              So if one fetches the Accounts and other fetches the Accounts meta info clearly state the difference using clear names
 *                                              Ex: ActiveAccounts, InactiveAccount, DeactivatedAccounts, DuePayments, ClearPayments
 *                                              These show clear difference
 * 4. use pronouncable names : like use elapsedTimeInDays instead of ETID ( don't abrevate which is not commonly understood) ASCII is common
 * 5. use searchable names : When naming variable follow a principle where it is easy to search the names , ex MAX_CACHE_SIZE ,
 *                          getActiveAccounts instead of size  or accounts because there might be way too many instances of the same names
 *                          Like using e for error which is bad
 *
 * 6. Avoid encoding : Like userNameString : this encodes the type or userList . the issue here is when the
 */
public class Main {
    // this function states that it finds max and using the parameters we can say it finds max of 2 numbers
    // we have to go through the code to find what happens when equal

    public static boolean max(int a,int b){
        return a>b;
    }
    // this conveys that it checks if a >b , we can say the intent without looking at parameter and the return type of
    // function especially useful in javascript as no func signature

    public static  boolean isAGreaterThanB(int a, int b){
        return a>b;
    }

    public static int isAGreaterThanB(String s,String b){
        return s.compareTo(b);
    }

    // Lets say we have two functions that numbers by even or odd

    // this clearly says the function returns numbers which are odd from the passed number Array
    // here having names like filterNumbers1 and filterNumbers2 doesn't provide good distinguishment, nor getOddNumbers because this doesn't say
    // the function expects inputs because it says get OddNumbers
    public int[] filterOddNumbers (int[]numbers){
        return Arrays.stream(numbers).filter(n->n%2==1).toArray();
    }

    public int[] filterEvenNumbers(int[]numbers){
        return Arrays.stream(numbers).filter(n->n%2==0).toArray();
    }
    // this parameter clearly says which is the source file and which is destination file
    // the function says copying file contents to destination file , having names like makeACopy would convey temporary location etc

    public void copyFileContentTo (String source, String destination){

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}