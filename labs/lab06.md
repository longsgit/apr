* You have a Calculator class as given below for reference 

```java
	public class Calculator {
		public int add(int num1, int num2) {
			return num1 + num2;
		}
		
		public int subtract(int num1, int num2) {
			return num1 - num2;
		}
		
		public int multiply(int num1, int num2) {
			return num1 * num2;
		}
	}
```


* Create a functional interface called __Calc__ with an abstract method that accepts two arguments and returns an int.

* Create Lab06.java with a **main()** method. 
* In the __main()__ create Lambda expressions for add, subtract and multiply using __Calc__
* Create a new method called __operate(Calc calc)__ in Lab07 and pass your lambdas as arguments. Use numbers 10 and 5 for all the operations