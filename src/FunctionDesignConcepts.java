/**
 * 1. Functions should be small at max they should be around 20 lines long
 * 2. Max 2 indents and keep the if , while else one line if possible , may be extract the logic to function and call it
 * 3. Do one thing  : A function should have one reason to change and it should do only one thing at a time
 *                         One thing means that it should do only 1 abstraction level below the function name
 *4. Read code from top to bottom : Each function at higher level should do just one level of abstraction below ,
 *                                  The code should read like top to bottom fashion
 *5. Switch statements : Keep the switch statements at the lowest level of abstraction and keep the code in such a way that it
 *                       doesn't need to repeated like use abstract factory to create a object and let the object methods be used
 *
 * 6. use descriptive names : use names that describes what the function would do exactly
 * 7. Function arguments :
 *                  1. niladic (0): no function arguments , this would be better and can be achieved using the member function or abstraction on a class or obejct
 *                  2. monadic (1): one function arguments
 *                                These type of functions should try to fit within 3 forms
 *                                1. question type like isFileExists(filename), isOdd(number) etc these ask a question for a specific context
 *                                2. operation/transformation to be performed on a input like openFile(filename) this returns filestream , squareNumber(number)
 *                                3. EventBased : basically used to perform certain side effects/operations that are needed to be done on event occurrence
 *
 *                                So basically to achieve this we need to have the function name clear and the follow these principles
 *                                Avoid monadic functions with inputs that act as output arguments like
 *                                i.e like void square(int x ) using x as output too
 *
 *
 *                                Avoid flag arguments like a boolean to take condition:
 *                                  render(true) we can just call the individual render based on the condition at higher level
 *                                  or move the logic which fetches the flag to a lower abstraction and conditional statement within
 *                                  the same level and make the function niladic
 *                  3. dyadic(2): 2 argument functions
 *                               use dyadic functions where the arguments make ordered sense like new CartesianProduct(0,0) here the
 *                               args say ordered fashion i.e x,y or copyTO(source,destination) ordered
 *                               we can make this monaic by creating a object and copy as a member
 *
 *
 *                  4. triadic(3):
 *                  5. Polyadic(>3):
 *
 *                  Better rule is to compose an object of the arguments when the args are more than 2 . this keep them ordered and easy
 *                  to pass and operate on
 *
 *  8. Functions nammes :  use verb to indicate the action of unction and nouns for args to make a descriptive intuition
 *              example writeToFile(name)
 *  9.Avoid using side effects in function : A function should do what the function name describes it to do , it should do hidden things
 *                                          This creates a temporal coupling that works on certain hidden condition only
 *                                          Like createUser() which indicates creating user but if it also does the notifying part
 *                                          like message then failure of message but create problems during dubuggin as to why notification
 *                                          didn't go
 *
 *                                          So we can name it createUserAndNotify
 * 10. CQRS : a function should do someting or answer something it should not do both
 *           A function should transform /operate or do something and can return a result
 *           but it should not combine both like
 *           boolean setValueAtIndex(index,value): this should just set value ,but returning a boolean here kind of looks like
 *           answering a question like whether the value at index already exisits or is the same as the value already presnet
 *           so its confusing . Instead on failure to set we can use error / exceptions that is better
 *
 * 11. Try to use Exceptions instead of error codes or boolean flags as output arguments . This keep code cleaner
 *
 * 12. structured programmin : a block , function etc should have one entry and one exit point . But not really possible.
 * If possible code is cleaner
 *
 * 13. DRY: don't repeat yourself
 */
public static class FunctionDesignConcepts {
    /**
     *
     * Here the function just does one thing that is call the abstraction for create user and notify the event
     * here all the function does is call the abstraction to create user and notify event
     * it doesn't have logic to actually create a user and handle notifying the event . it is not he functions job
     */
    public void createUserAndNotifyEvent(User user){

        try {
            user.save();
            // notify event
        }catch(Exception userCreationError){

        }
    }


    /**
     * Switch statement with abstract factory to keep the code dry . Basically isolate the creation code or provide a abstraction as response
     * so that the caller can use the methods/ abstraction for operation instead of letting switch case handle it
     * Because switch case increases complexity and cannot have Open closed part of SOLID
     * here we create abstract factory of employee with abstractions which lets us handle the functions in a better way
     * This function is small and does only one thing i.e createEmployeeByType
     * How to use the employee object is completely out of scope
     *
     *
     */
}
    public Employee employeeByType(String type){
      switch (type){
          case EmployeeTypeConstants.CONTRACT :
              return new ContractEmployee();
          case EmployeeTypeConstants.PERMANENT:
              return new PermanentEmployee();
      }
      return new VoidEmployee();
    }

public void main() {
}