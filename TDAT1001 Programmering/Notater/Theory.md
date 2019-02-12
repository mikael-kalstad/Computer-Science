# Theory in java

In this file there will be different topics and code snippets that further explain some theory in Object Oriented Programming such as Java.

### Mutable vs Immutable 

**Mutable**: a object is mutable it has fields that can be changed after it is created. 

**Immutable**: when a object has fields that cannot be changed after it is created. 

The keyword final is important to achieve this. 

````java
class Mutable{
  private int value;

  public Mutable(int value) {
     this.value = value;
  }

  //getter and setter for value
}

class Immutable {
  private final int value;
// Notice final 
  
  public Immutable(int value) {
     this.value = value;
  }

  //only getter
}
````

### 

### Default Constructor 

Every class have a constructor to make objects. If we do not program any constructors, a standard constructor with no parameters and content will be made.

```java
// Constructor syntax
public className(parameters) {
  // do something here
}

class Train {
  int speed;
  String name;
  // Constructor
  
  public Train (int speed, String name) {
    // this.variableName refers to the variable in this class scope
    this.speed = speed; 
    this.name = name;
  }
  
  // OR you can have different parameters names  
  
  public Train (int trainSpeed, String trainName) {
    // this. notation is not needed since they have different names
    speed = trainSpeed;
    name = trainName; 
  }
}
```



### Heap and stack

**Heap**: Objects are always allocated with new to an area called "heap".

**Stack**: References and variables of primitive datatypes, including parameters and return-values from methoder, are stored in an area called "stack".



### Exceptions 

##### NullPointerException

This exception is thrown when an application attempts to use null in a case where an object is required. 

````java
int age
````

##### ArrayIndexOutOfBoundsException

This is thrown when the index of an array is not in the range specified when the array was created.

`````java
String[] names = new int[5];
names[6] = "Bobby brown";

// Output 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 6
`````



### Arrays

Arrays also refered to as "tabeller", are used to store data of similar datatype. Instead of making a variable for each instance, which is cumbersome, it is much easier to create an array to put all the data in. 

````java
// Creating an array to store data. Sunny or not sunny each day.
int[] sunny = new int[7];

// Much easier than creating several variables for each day of the week.
int monday = 0;
int thursday = 1;
...

// The size of the array can be set once you know the required size
int[] sunny;
sunny = new int[31] // Everyday for a month instead of a week
  
// To give each instance in the array a value 
sunny[0] = 1; // It was sunny the first day of the month!
sunny[30] = 0; // The last day of the month was not sunny
int aDay = sunny[12]; // Store the value of the 12th day in a variable aDay
````

The values of an array can be initialized directly.

````java
double[] weight = {3.0, 5.32, 6.69};
````

##### Exceptions

Index in arrays are important, if the index is not valid the program will throw *ArrayIndexOutOfBoundsException*. This also applies to the length method in arrays.

````java
String[] names = new int[5];
names[6] = "Bobby brown";

// Output 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 6
````

##### Length

An array is an object, therefore we can use methods inside the object, such as length which return the length of the array.

````java
String[] names = {"Bob", "Linda", "Michael"};
names.length // Output: 3
  
// Note to use the length in for and if loops, remember to -1
if (names[length] == "Michael") // Will throw ArrayIndexOutOfBoundsException
if (names[length-1] == "Michael") // Is valid, and is true
````

##### Copy

Arrays are objects, therefore setting one array equal another will result in two different names that are references to the object.

````java
int[] array1 = {1, 2, 3, 4};
int[] array2 = {4, 3, 2. 1};

array2 = array1; // It is declared from left to right
array2 = {1, 2, 3, 4} // Therefore array2 has array1 values
````



![](C:\Users\mikae\Dropbox\Dataingeniør\TDAT1001 Programmering\Notater\Bilder\20180901_130352.jpg)

###### **arraycopy**

To copy only specific items from another array to a specific place in an array, arraycopy is used.

````java
// Syntax for arraycopy
System.arraycopy(arrayCopyingFrom, fromIndex, arrayCopyingTo, fromIndex, amout);

// Example
int[] array1 = {1, 2, 3, 4};
int[] array2 = {4, 3, 2. 1};
System.arraycopy(array1, 0, array2, 2, 2);
array2 = {4, 3, 1, 2}; // 1 and 2 from array1 replaced index 2 and 3 in array2
````



![](C:\Users\mikae\Dropbox\Dataingeniør\TDAT1001 Programmering\Notater\Bilder\20180901_130416.jpg)

