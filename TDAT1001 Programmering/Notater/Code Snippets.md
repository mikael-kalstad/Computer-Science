## Code Snippets

### Last number

Find the last number in any number.

````java
int num = 1938;
num % 10 = 8; // Will divide with 10 as many times possible and return the rest
````



### toString() Method

A standardized method for printing out to the system.

````java
class Car {
  int age = 12;
  String name = "Ford";
  
  String toString() {
    return "Age: " + age + ", Name: " + name;
  }
  
  public static void main(String[] args) {
    System.out.println(Car.toString()); // Will output: Age: 12, Name: Ford
    // toString is standardized therefore there is no need to write .toString()
    System.out.println(Car); // Will output the same! 
  }
}
````





## API java.util

### java.util.Random

java has a random class which can be used to create any random number within a range.

`````java
class Random {
  // Object is created from java.util.Random class
  java.util.Random randomMachine = new java.util.Random();
  
  // To store the number that is randomly picked
  int integerNumber = randomMachine.nextInt(); // Will output any int number 
  
  // To specify the range
  int rangedNumber = randomMachine.nextInt(6); // 0-6, for 1-6, just add 1 after (6) +1
  
  // Doubles
  double doubleNumber = randomMachine.nextDouble(); // Output: 0.0 - 1.0
  double rangedDoubleNumber = randomMachine.nextDouble()*3; // Output 0.0 - 3.0 
  
  // Boolean
  boolean booleanValue = randomMachine.nextBoolean(); // Output: true or false
}
`````

### java.util.Scanner 

Receive data directly from the console input. 

```java
import java.util.Scanner;

Scanner userInput = new Scanner(System.in); // userInput is the variable name
int number = userInput.nextInt(); // number will hold the value of what you input
double decimal = userInput.nextDouble(); // For double with decimals
String text = userInput.nextLine(); // For strings
```

## API String

The String class is immutable, which means that methods like toUpperCase() makes new objects of the class String and returns the references for these objects.

### toUpperCase()

Makes every letter uppercase in a String. toLowerCase() does the opposite.

````java
String text = "heLlo";
String textUpperCase = text.toUpperCase();
````

trim()

