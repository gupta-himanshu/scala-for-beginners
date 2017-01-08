1. Scala is a blend of object-oriented and functional programming concepts in a statically typed language.

2. Scala is designed to be extended and adapted by the people programming in it. Instead of providing all constructs
you might ever need in one “perfectly complete” language, Scala puts the tools for building such constructs into your hands.

3. We can design and implement abstractions in Scala that address radically new application domains, yet still feel like 
native language support when used.

4. Other languages might have objects and functions as two different concepts, in Scala a function value is an object.

5. Scala is an object-oriented language in pure form: every value is an object and every operation is a method call. 
For example, when you say 1 + 2 in Scala, you are actually invoking a method named + defined in class Int. 
You can define methods with operator-like names that clients of your API can then use in operator notation.

6. Functional programming is guided by two main ideas. 
   a. The first idea is that functions are first-class values. In a functional language, a function is a
      value of the same status as, say, an integer or a string. You can pass functions as arguments to other functions, 
      return them as results from functions, or store them in variables. You can also define a function inside another
      function, just as you can define an integer value inside a function. And you can define functions without giving 
      them a name, sprinkling your code with function literals as easily as you might write integer literals like 42.
   b, The second main idea of functional programming is that methods should not have any side effects. To see the difference, 
      consider the implementation of strings in Ruby and Java. In Ruby, a string is an array of characters. Characters in a
      string can be changed individually. For instance you can change a semicolon character in a string to a period inside 
      the same string object. In Java and Scala, on the other hand, a string is a sequence of characters in the math-
      ematical sense. Replacing a character in a string using an expression like s.replace(';', '.') yields a new string 
      object, which is different from s. Another way of expressing this is that strings are immutable in Java whereas
      they are mutable in Ruby. So looking at just strings, Java is a functional language, whereas Ruby is not.

7. Java’s primitive types have corresponding classes in the scala package. For example, scala.Boolean corresponds to Java’s 
boolean. scala.Float corresponds to Java’s float. And when you compile your Scala code to Java bytecodes, the Scala com-
piler will use Java’s primitive types where possible to give you the performance benefits of the primitive types.

8. Scala has two kinds of variables, val s and var s. A val is similar to a final variable in Java. Once initialized, 
a val can never be reassigned. A var , by contrast, is similar to a non-final variable in Java. A var can be reassigned
throughout its lifetime.

9. Function definitions start with def. The function’s name, in this case max , is followed by a comma-separated list 
of parameters in parentheses. A type annotation must follow every function parameter, preceded by a colon, because
the Scala compiler does not infer function parameter types.

10. The equals sign that precedes the body of a function hints that in the functional world view, a function defines 
an expression that results in a value.

11. Sometimes the Scala compiler will require you to specify the result type of a function. If the function is recursive, then 
we must explicitly specify the function’s result type.

12. Scala’s Unit type is similar to Java’s void type; in fact, every void - returning method in Java is mapped to a Unit -
returning method in Scala.

13. Java’s ++i and i++ don’t work in Scala. To increment in Scala, you need to say either i = i + 1 or i += 1.

14. for (arg <- args)
      println(arg)
The parentheses after the “ for ” contain arg <- args .To the right of the <- symbol is the familiar args array. 
To the left of <- is “ arg ”, the name of a val , not a var . (Because it is always a val , you just write “ arg ” by
itself, not “ val arg ”.) Although arg may seem to be a var , because it will get a new value on each iteration, 
it really is a val : arg can’t be reassigned inside the body of the for expression. Instead, for each element of the args
array, a new arg val will be created and initialized to the element value, and the body of the for will be executed.

15. In Scala, you can instantiate objects, or class instances, using new .When you instantiate an object in Scala, you can 
parameterize it with values and types. Parameterization means “configuring” an instance when you create it. You parameterize 
an instance with values by passing objects to a constructor in parentheses. For example, the following Scala code instantiates 
a new java.math.BigInteger and parameterizes it with the value "12345" : 
    
    ```
    val big = new java.math.BigInteger("12345")
    ```
16. Arrays in Scala are accessed by placing the index inside parentheses, not square brackets as in Java.

17. When you define a variable with val ,the variable can’t be reassigned, but the object to which it refers could potentially 
still be changed. So in this case, you couldn’t reassign greetStrings to a different array; greetStrings will always point to the
same Array[String] instance with which it was initialized. But you can change the elements of that Array[String] over time, 
so the array itself is mutable.

18. Lists are not “built-in” as a language construct in Scala; they are defined by an abstract class List in the scala package, 
which comes with two sub-classes for `::` and `Nil`.

19. 
    ```
    package scala
    abstract class List[+T] {
    ```
List is an abstract class, so you cannot define elements by calling the empty List constructor. For instance the expression 
“new List” would be illegal. The class has a type parameter T . The + in front of this type parameter specifies that lists 
are covariant, as discussed in Chapter 19. Because of this property, you can assign a value of type List[Int] to a
variable of type List[Any] :
    ```
    scala> val xs = List(1, 2, 3)
    xs: List[Int] = List(1, 2, 3)
    scala> var ys: List[Any] = xs
    ys: List[Any] = List(1, 2, 3)
    ```
