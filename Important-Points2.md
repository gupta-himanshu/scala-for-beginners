1. In Scala, all the numeric types are objects, including Byte ,Char ,Double ,Float ,Int ,Long ,and 
Short. These seven numeric types extend the AnyVal trait, as do the Unit and Boolean classes, 
which are considered to be “nonnumeric value types.”

2. The seven built-in numeric types in Scala have the same data ranges as their Java primitive 
equivalents.

3. Scala doesn’t have checked exceptions.

4. To increment or decrement numbers using operators like ++ and −− that are available in other 
languages, but Scala doesn’t have these operators.

5. Although the Scala BigInt and BigDecimal classes are backed by the Java BigInteger
and BigDecimal classes, they are simpler to use than their Java counterparts. As you can
see in the examples, they work just like other numeric types, and they’re also mutable.

6. Scala’s if / then / else structure is similar to Java, but can also be used to return a value. 
As a result, though Java has a special syntax for a ternary operator, in Scala you just use a 
normal if statement to achieve the ternary effect.

7. The try / catch / finally structure is similar to Java, though Scala uses pattern matching
in the catch clause. This differs from Java.

8. Scala match expression look like a Java switch statement, but because we can match any 
object, extract information from matched objects, add guards to case statements, return 
values, and more, match expressions are a major feature of the Scala language.

9. scala> 1 to 3
res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
Using a Range like this is known as using a generator.

10. When we use the for / yield combination with a collection, we're building and returning 
a new collection, but when we use a for loop without yield, we’re just operating on 
each element in the collection—we’re not creating a new collection. 
The for / yield combination is referred to as a for comprehension, 
and in its basic use, it works just like the map method.

11. How for loops are translated by the Scala compiler:
   a. A simple for loop that iterates over a collection is translated to a foreach method
      call on the collection.

   b. A for loop with a guard is translated to a sequence of a withFilter
      method call on the collection followed by a foreach call.

   c. A for loop with a yield expression is translated to a map method call on the collection.

   d. A for loop with a yield expression and a guard is translated to a withFilter
      method call on the collection, followed by a map method call.

12. Using a for loop with a yield statement is known as a for comprehension.

13. If you’re new to using yield with a for loop, it can help to think of the loop like this:
   a. When it begins running, the for / yield loop immediately creates a new, empty
      collection that is of the same type as the input collection. For example, if the input
      type is a Vector , the output type will also be a Vector . You can think of this new
      collection as being like a bucket.

   b. On each iteration of the for loop, a new output element is created from the current
      element of the input collection. When the output element is created, it’s placed in
      the bucket.

   c. When the loop finishes running, the entire contents of the bucket are returned.

14. Scala doesn’t have `break` or `continue` keywords.

45. `break` and `breakable` aren’t actually keywords; they’re methods in `scala.util.control.Breaks`.
In Scala 2.10, the `break` method is declared as follows to throw an instance of a `BreakControl` 
exception when it’s called.

16. In Scala there is no special ternary operator.

17. following conditions must be true for Scala to apply the `tableswitch` optimization:
   a. The matched value must be a known integer.

   b. The matched expression must be “simple.” It can’t contain any type checks, if
      statements, or extractors.

   c. The expression must also have its value available at compile time.

   d. There should be more than two case statements.

18. It’s important to provide a default match. Failure to do so can cause a `MatchError`.

19. If you’re coming to Scala from Java, you’ll find that the process of declaring a primary
constructor in Scala is quite different. In Java it’s fairly obvious when you’re in the main
constructor and when you’re not, but Scala blurs this distinction.
