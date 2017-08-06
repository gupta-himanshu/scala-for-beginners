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

19. List:
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

20. All list operations can be defined in terms of three basic methods:
    ```
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    ```
These three methods are all abstract in class List . They are defined in the subobject `Nil` and the subclass `::` . 

21. The Nil object defines an empty list. The `Nil` object inherits from type `List[Nothing]` .Because of covariance, 
this means that Nil is compatible with every instance of the List type.

22. Class `::`, pronounced “cons” for “construct,” represents non-empty lists. It’s named that way in order to support 
pattern matching with the infix `::` .You have seen that every infix operation in a pattern is treated as a constructor 
application of the infix operator to its arguments. So the pattern `x :: xs` is treated as `::(x, xs)` where `::` is a 
case class.

23. The definitions of the head and tail method simply return the corresponding parameter. In fact, this pattern can be 
abbreviated by letting the parameters directly implement the head and tail methods of the superclass List, as in the 
following equivalent but shorter definition of the :: class:
    ```
    final case class ::[T](head: T, tail: List[T]) extends List[T] {
      override def isEmpty: Boolean = false
    }
    ```
This works because every case class parameter is implicitly also a field of the class (it’s like the parameter 
declaration was prefixed with val).

24. The list construction methods `::` and `:::` are special. Because they end in a colon, they are bound to their right 
operand. That is, an operation such as `x :: xs` is treated as the method call `xs.::(x)` , not `x.::(xs)`. In fact, `x.::(xs)` 
would not make sense, as x is of the list element type, which can be arbitrary, so we cannot assume that this type would 
have a `::` method. For this reason, the `::` method should take an element value and yield a new list. What is the 
required type of the element value? You might be tempted to say it should be the same as the list’s element type, 
but in fact this is more restrictive than necessary. To see why, consider this class hierarchy:
    ```
    abstract class Fruit
    class Apple extends Fruit
    class Orange extends Fruit
    ```

    ```
    scala> val apples = new Apple :: Nil
    apples: List[Apple] = List(Apple@e885c6a)

    scala> val fruits = new Orange :: apples
    fruits: List[Fruit] = List(Orange@3f51b349, Apple@e885c6a)
    ```
The apples value is treated as a List of Apple s, as expected. However, the definition of fruits shows that it’s 
still possible to add an element of a different type to that list. The element type of the resulting list is Fruit ,
which is the most precise common supertype of the original list element type (i.e., Apple ) and the type of the 
element to be added (i.e., Orange ). This flexibility is obtained by defining the :: method (cons)

25. The list concatenation method `:::` is defined in a similar way to `::`.
    ```
    def :::[U >: T](prefix: List[U]): List[U] =
      if (prefix.isEmpty) this
      else prefix.head :: prefix.tail ::: this
    ```
Like cons, concatenation is polymorphic. The result type is “widened” as necessary to include the types of all 
list elements. Note again that the order of the arguments is swapped between an infix operation and an explicit
method call. Because both `:::` and `::` end in a colon, they both bind to the right and are both right associative. 
For instance, the else part of the definition of `:::` contains infix operations of both `::`
and `:::` . These infix operations can be expanded to equivalent method calls as follows:
    ```
    prefix.head :: prefix.tail ::: this
    equals (because :: and ::: are right-associative)

    prefix.head :: (prefix.tail ::: this)
    equals (because :: binds to the right)

    (prefix.tail ::: this).::(prefix.head)
    equals (because ::: binds to the right)

    this.:::(prefix.tail).::(prefix.head)
    ```
26. The typical access pattern for a list is recursive. For instance, to increment every element of a list without using 
map you could write: 
    ```
    def incAll(xs: List[Int]): List[Int] = xs match {
      case List() => List()
      case x :: xs1 => x + 1 :: incAll(xs1)
    }
    ```
One shortcoming of this program pattern is that it is not tail recursive. Note that the recursive call to `incAll` 
above occurs inside a :: operation. Therefore each recursive call requires a new stack frame.
A better alternative is to use a list buffer. List buffers let you accumulate the elements of a list. To do this, 
you use an operation such as “ buf += elem ”, which appends the element elem at the end of the list buffer buf. Once you
are done appending elements, you can turn the buffer into a list using the toList operation. `ListBuffer` is a class 
in package scala.collection.mutable . To use the simple name only, you can import ListBuffer from its package:

    ```
    import scala.collection.mutable.ListBuffer
    ```
Using a list buffer, the body of incAll can now be written as follows:

    ```
    val buf = new ListBuffer[Int]
    for (x <- xs) buf += x + 1
    buf.toList
    ```
This is a very efficient way to build lists. In fact, the list buffer implementation is organized so that both the 
append operation ( += ) and the toList operation take (very short) constant time.

27. Say you are given a list of persons, each defined as an instance of a class Person. Class Person has fields 
indicating the person’s name, whether he or she is male, and his or her children. Here’s the class definition:

    ```
    scala> case class Person(name: String,
                             isMale: Boolean,
                             children: Person*)
    ```

    Here’s a list of some sample person s:

    ```
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)
    ```
    Now, say you want to find out the names of all pairs of mothers and their children in that list. Using map, 
    flatMap and filter, you can formulate the following query:

    ```
    scala> persons filter (p => !p.isMale) flatMap (p =>(p.children map (c => (p.name, c.name))))
    res0: List[(String, String)] = List((Julie,Lara), (Julie,Bob))
    ```
    These queries do their job, but they are not exactly trivial to write or understand. Is there a simpler way? 
    In fact, there is. Using a `for` expression, the same example can be written as follows:

   ```
    scala> for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)
    res2: List[(String, String)] = List((Julie,Lara), (Julie,Bob))
    ```

    The result of this expression is exactly the same as the result of the previous expression.

28. An extractor in Scala is an object that has a method called unapply as one of its members. The purpose of that 
unapply method is to match a value and take it apart.

    ```
    object EMail {
      // The injection method (optional)
      def apply(user: String, domain: String) = user + "@" + domain

      // The extraction method (mandatory)
      def unapply(str: String): Option[(String, String)] = {
        val parts = str split "@"
        if (parts.length == 2) Some(parts(0), parts(1)) else None
      }
    }
    ```
    The apply method has the same meaning as always: it turns EMail into an object that can be applied to 
arguments in parentheses in the same way a method is applied. So you can write `EMail("John", "epfl.ch")`
to construct the string "John@epfl.ch". To make this more explicit, you could also let EMail inherit 
from Scala’s function type, like this:

    ```
    object EMail extends ((String, String) => String) { ... }
    ```

    The unapply method is what turns EMail into an extractor. In a sense, it reverses the construction 
process of apply . Where apply takes two strings and forms an email address string out of them, unapply 
takes an email address and returns potentially two strings: the user and the domain of the address. 
But unapply must also handle the case where the given string is not an email address. That’s why 
unapply returns an Option -type over pairs of strings. Its result is either Some(user, domain) if the string 
`str` is an email address with the given user and domain parts, 1 or None, if str is not an email address. 
Here are some examples:

    ```
    unapply("John@epfl.ch") equals Some("John", "epfl.ch")
    unapply("John Doe") equals None
    ```

    Now, whenever pattern matching encounters a pattern referring to an extractor object, it 
invokes the extractor’s unapply method on the selector expression. For instance, executing the code:

    ```
    selectorString match { case EMail(user, domain) => ... }
    ```

    would lead to the call:

    ```
    EMail.unapply(selectorString)
    ```

    As you saw previously, this call to EMail.unapply will return either None or Some(u, d), 
for some values u for the user part of the address and d for the domain part. In the None case, 
the pattern does not match, and the system tries another pattern or fails with a MatchError exception.

29. There is no one-tuple in Scala.

30. To return just one pattern element from an Extractor, the unapply method simply wraps the element 
itself in a Some. For example:

    ```
    object Twice {
      def apply(s: String): String = s + s
      def unapply(s: String): Option[String] = {
        val length = s.length / 2
        val half = s.substring(0, length)
        if (half == s.substring(length)) Some(half) else None
      }
    }
    ```

31. An extractor pattern that does not bind any variable returns a boolean— true for success and 
false for failure. For instance:

    ```
    object UpperCase {
      def unapply(s: String): Boolean = s.toUpperCase == s
    }
    ```
32. In Scala, all the numeric types are objects, including Byte ,Char ,Double ,Float ,Int ,Long ,and 
Short. These seven numeric types extend the AnyVal trait, as do the Unit and Boolean classes, 
which are considered to be “nonnumeric value types.”
