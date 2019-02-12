# Java

### 					      Primitive data typer	

<u>*Det finnes 8 forskjellige datatyper i Java*</u>

**byte, short, int** og **long** brukes til å lagre hele tall.

**float** og **brukes** til desimal tall.

**char** brukes til å lagre bokstaver.

**boolean** er en datatype som er enten sann eller usann.

| Type    | Størrelse | Mulige verdier                                            | Standard verdi | Kommentar    |
| ------- | --------- | --------------------------------------------------------- | -------------- | ------------ |
| boolean | 1 bit     | true/false                                                | false          |              |
| char    | 16 bits   | characters                                                | null           |              |
| byte    | 8 bits    | -128 til 127                                              | 0              |              |
| short   | 16 bits   | -32.768 til 32.767                                        | 0              |              |
| int     | 32 bits   | -2.147.483.648 til 2.147.483.647                          | 0              |              |
| long    | 64 bits   | -9,223,372,036,854,775,808 til -9,223,372,036,854,775,807 | 0              | L på slutten |
| float   | 32 bits   | 6 til 7 desimaler                                         | 0              | F på slutten |
| double  | 64bits    | 15 desimaler                                              | 0.0            | D er default |
|         |           | EKSTRA STRING ER EN EGEN KLASSE                           |                |              |
| String  |           |                                                           | null           |              |



##### Eksempler 

````java
boolean hasOwner = true;
char letter = "A";
byte num = 4;
short largerNum = 200;
int bigNum = 50000;
long hugeNum = 120000000L;
float decimalNum = 3.14F;
double pi = 3.1423213323; //D på slutten er default, så er ikke påkrevd.
````

## 

### 							Keywords

#### Flow Control

##### break 

Jumps out of a loop or switch. Useful if you have found an instance in an loop, therefore there is no point in checking the remaining ones.  

````java
int num = 3;

for (int i = 0; i < 10; i++) {
  if (i == num) {
    System.out.print("It is the right number!");
    break; //If it was not here, it would go through all the other numbers (4-9)
  }
}
````

##### default

If no cases match in a switch statement, the default will be executed.

````java
switch(something) {
  case "A": 
    int x = 0;
    break;
  default:
    System.out.println("No values matching!"); 
    //Break is not needed as this is the last one in the switch statement.
}
````

##### instanceof

Check if a certain object comes from a certain class. Returns true or false.		

````java
Object car = new String("hello");
if (car instanceof String) {
  //do something
}
````

##### return

Ends the method and possibly returns a value.

````java
int getAge() {
  int myAge = 29;
  return myAge;
} 
//If the function is called, it will return myAge which has a value of 29.
````

#### 

#### Access modifiers

##### private 

Indicates that a variable or method can only be used within a certain class.

````java
class car {
  private int carAge = 10;
  //or method
  private getCarAge {
  	return carAge;
  }
}
````

##### public

The opposite of private, which means that a variable, class or method can be used by any other java code.

````java
public class train { //Class
  public String trainName = "NSB"; //Variable
  public getNumberOfPassengers { //Method
    int passengers = 130;
    return passengers;
  }
}
````

##### protected 

Indicates that a variable or method can be used in subclasses from another package.

````java
package p1

  public class plane {
    protected int planeWidth = 80;
    protected getFuelLevel() {
      int fuelLevel = 98;
      return fuelLevel;
    }
  }
````



#### Package control

##### import 

Is used to make classes and interfaces available and accessible to the current source code. Must be placed on top of the source file, just below the package statement. 

````java
import javax.swing.JOptionPane.* //* indicates that you want to import every class from JOptionPane

import java.swing.JOptionPane.showInputDialog //Specific class, rather than .*
````

##### package

A package is a pack(group)  of classes, interfaces and other packages. It is used to organize our classes and interfaces. There are two types, built in ones, and the ones we make. Needs to be on the first line!

````java
import java.util.Scanner;
//Java is a top level package
//Util is a sub package
//Scanner is a class in the sub package util
---------------------------------------------
package readBooks //Remember must be on top!

public class books {
  //Code goes in here
}
//The class books is stored in the package readBooks
//To access the class books in another file/program:
	import readBooks.books;
````

#### 

#### Class, methods, variable modifiers

##### class

Used to declare a class.

````java
class Person {
  //methods...
  //properties...
}
````

##### extends 

Used to extend a class with a subclass. When you want to create a subclass extends is used.

````java
class car {
  //do something...
}

class wheels extends car{
  //do something...
}
````

##### final

Indicates that a variables value cannot be changed (constant), that a class functionality cannot be extended, or that a method cannot be overridden. If a variable is final, you have to declare a value to it, either directly or through a method.

````java
final class person { }
class people extends person { } // Compile error

final String MSG = "hello"; // Constants/final should have names in uppercase
MSG = "goodbye" // Compile error
````

##### new

New is used to create a new instance (object) of a class. 

````java
class car { }
car newCar = new car(); // Creates a new instance of a class

int numbers[] = new int[3]; // Creates a new array object

````

##### static 

Indicates that a method or variable belongs to a class, rather than to any object created from the class.

````java

````



#### Other

##### super

Super is a reference variable to refer to its immediate parent class object.

````java
class animal { // Animal is cats parent class object
  String color = "black";
}

class cat extends animal {
  String color = "orange";
  System.out.println(color); // Will output cat color (orange)
  System.out.println(super.color); // Will output animal color (black)
}
````

##### this

Is used to refer to the current instance of a class.

````java
class airplane {
  String name = "SAS";
  
  public getName(String name) {
    this.name = name;
  }
}
````

##### void

Is used to indicate a method that does not return any value.

````java
public void getTickets() {
  // do something here
  // but do not return anything
}
````



#### Error handling 

##### throw

Creates a new exception object and indicates that an exceptional situation (usually something unwanted) had occurred. 

````java
// Check if number length is 4
if (number < 1000 || number > 9999) {
    throw new IllegalArgumentException("Number must have a length of 4, your number is: " + number)
}
````







