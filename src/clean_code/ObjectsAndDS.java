package clean_code; /**
 * The concepts give clear meaning of the boundaries , responsibilities ,limits ,defination and usage
 *
 * Private variables are made to keep them not exposed and have the freedom to change them within the enclosure without worrying
 * about breaking anything , so if there is a need to expose them then a good amount of consideration needs to be put
 *
 * Objects : are classes or instance of classes that contain data which is not exposed directly to the outside of the enclosure
 *          The objects doesn't provide direct accessors or setters . It uses well defined abstractions that operate on the data
 *          and doesn't give a hint about how the internal data is stored  . It only provides abstractions/methods/accessors that give
 *          the user information/ability to perform action . But it doesn't expose how the data is stored
 *
 *          OO makes adding new objects easy as you have to create a new object with the same abstraction and it can be replaced ,
 *          But it makes hard for adding new abstractions/methods/functions because all the objects have to implement it even if not needed
 *
 *
 *  Data structure : DS basically is a enclosure that helps enclose the data and provide methods to work on it . It exposes the data
 *  with not a highly abstracted methods/points . The ds exposes the internal mechanism and is tightly coupled . The caller has to handle the data
 *  sanity in some cases and the exposed methods are lightweight
 *
 *  DS helps in procedural programming because the exposed functions help us create new functions without issues
 *  as the new function has to handle all the case logics using the internal structure
 *  whereas it makes it hard to add new data objects as it needs changes in all the functions that is dependendant on it
 *
 *
 *  Law of demeter : it states that  a module should not know the innards of the objects it manipulates,
 *      A method f of class C should only call methods of
 *      1. C
 *      2. Any objects created in f
 *      3. An object passed as arg to f
 *      4. An object held instance variable in f
 *
 *      It should not call methods of obj returned from these above functions as it knows the method would return
 *      and the object structure . Because working on the objects is fine but knowing the contents means
 *      the method is dependant on something it doesn't directly see or co relate
 *
 *      This violates the above law
 *      final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
 *      This type of chaining is called train wrecks as it connects a chain of calls to get the end result
 *      as any change in the innards of first object requires changes in this function
 *
 *      And this law only applies to objects not ds so instead if they were ds with exposing data members then it is fine
 *      as the above law doesn't apply
 *      ex:
 *      final String outputDir = ctxt.options.scratchDir.absolutePath
 *
 *  Hybrids :
 *      structures which are half objects and half ds . the problem with this approach is that is attracts the bad points of
 *      both the types . So always create one type as it shows the objects usage as beneficial for that design
 *
 *
 * Hiding structure :
 *  i.e hiding the internal details and letting the object create abstractions that help the user to avoid accessing the innards of the
 *  objects .
 *      final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
 *      this can be avoided if the use case was to create a bufferedOutputstream using the path
 *      than we can have a abstraction like ctxt.createScratchDirBufferedOutputStream()
 *      This hides the navigational chain and lets the use case be handled
 *
 *  DTO : Data transfer objects, these have public varirables with no functions . These help in data communications especially useful
 *  for message parsing from sockets and database record to bean
 *
 *  Active Record :
 *      These are ds with navigational methods like find and save .Typically used to store data from data sources or databases .
 *      These are ds and should be treated as ds
 *      Any bussiness rule in this will create hybrids and should be avoided instead create a object over an instance of Active record
 *      as data and hide implmentation details by providing abstractions
 */

/**
 * Object example of a cartesian product
 * As you can see there is no information exposed that the internal data storage is using x,y data
 * it only provides abstraction to set cordinates in different forms and sets a ordered pair restriction. It doesn't allow individual change
 * it also lets user get the data in polar abstraction .
 * This way of abstracting the implementation to give only the information/ability to perform operation on the essense of data is objects
 */

class CartesianObject{
    int x,y;

    public void setCartesian(int x,int y){
        this.x=x;
        this.y=y;
    }

    public double getR(){
        return 0.0;
    }

    public double getTheta(){
        return 0.0;
    }

    public void setPolar(double r,double theta){

    }
}

/**
 * Here the data storage is exposed the data structure only provides functions with the implementation exposed
 * so the user is aware of the internal implmentation and the usage of the data storage to outer calls
 * The caller is responsible for the sanity of the data state no abstraction is provided here
 * These are useful when procedural implemenation needs to be done because adding new functions depending on these
 * DS won't effect the ds or the existing functions , but adding new DS types will effect the existing functions as we have to add
 * new cases logics
 *
 * here both the ints are exposed and the setting of each is independently done making the data inconsistent or not sane if user
 * doesn't handle it
 */
 class CartesianDataStructure{

     public int x ,y;

}
class  Point{
     int x, y;
}
 class Square { public Point topLeft; public double side;
}
 class Rectangle { public Point topLeft; public double height; public double width;
}
 class Circle { public Point center; public double radius;
}

/**
 * This shows the procedural way where the data is directly accessed using ds and area is calculated
 * so adding new shapes requires changes in area code , while adding new function like perimeter is easy
 */
 class Geometry {
    public final double PI = 3.141592653589793;
    public double area(Object shape)  {
        if (shape instanceof Square) { Square s = (Square)shape; return s.side * s.side;
        }

        else if (shape instanceof Rectangle) { Rectangle r = (Rectangle)shape; return r.height * r.width;
        }
        else if (shape instanceof Circle) {
            Circle c = (Circle)shape;
            return PI * c.radius * c.radius; }
        return 0; }
 }

/**
 * OO way of implementing the same
 * here the oo makes it easy to add new objects as the contract is set
 * while adding new functions requires changes in all the objects
 * so useful where creation of object is more while functions are constant , else use procedural or combine
 *
 */interface Shape{
     public double area();
}
 class SquareOO implements Shape { private Point topLeft;
    private double side;
    public double area() { return side*side;
    } }
 class RectangleOO implements Shape { private Point topLeft;
    private double height;
    private double width;
    public double area() { return height * width;
    } }
public class ObjectsAndDS {




}
