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

20. In Scala, anything defined within the body of the class other than method declarations 
is a part of the primary class constructor.

21. the visibility of constructor fields in a Scala class is controlled by whether the fields 
are declared as val , var , without either val or var , and whether private is also added 
to the fields.

• If a field is declared as a var , Scala generates both getter and setter methods for that
field.
• If the field is a val , Scala generates only a getter method for it.
• If a field doesn’t have a var or val modifier, Scala gets conservative, and doesn’t
generate a getter or setter method for the field.
• Additionally, var and val fields can be modified with the private keyword, which
prevents getters and setters from being generated.

22. Scala does not follow the JavaBean naming convention when generating accessor and 
mutator methods.

23. We can add the private keyword to a val or var field. This keyword prevents getter 
and setter methods from being generated, so the field can only be accessed from 
within members of the class.

24. Case class constructor parameters are val by default.

25. Auxiliary Constructors:

• Auxiliary constructors are defined by creating methods named this .
• Each auxiliary constructor must begin with a call to a previously defined construc‐
tor.
• Each constructor must have a different signature.
• One constructor calls another constructor with the name this .

26. If you want to add new “constructors” to your case class, you write new apply methods.

27. To make the primary constructor private, insert the private keyword in between the
class name and any parameters the constructor accepts.

28. A companion object is simply an object that’s defined in the same file
as a class , where the object and class have the same name. If you
declare a class named Foo in a file named Foo.scala , and then declare
an object named Foo in that same file, the Foo object is the compan‐
ion object for the Foo class.
A companion object has several purposes, and one purpose is that any
method declared in a companion object will appear to be a static
method on the object.

29. We can’t override the getter and setter methods Scala generates for you, 
at least not if you want to stick with the Scala naming conventions.

30. To solve this problem, change the name of the field you use in the class constructor so
it won’t collide with the name of the getter method you want to use. A common approach
is to add a leading underscore to the parameter name, so if you want to manually create
a getter method called name , use the parameter name _name in the constructor, then
declare your getter and setter methods according to the Scala conventions.

31. the recipe for overriding default getter and setter methods is:
a. Create a private var constructor parameter with a name you want to reference
from within your class. In the example in the Solution, the field is named _name .
b. Define getter and setter names that you want other classes to use. In the Solution
the getter name is name , and the setter name is name_= (which, combined with Scala’s
syntactic sugar, lets users write p.name = "Jony" ).
c. Modify the body of the getter and setter methods as desired.

32. Defining a field as private[this] takes this privacy a step further, and makes the field
object-private, which means that it can only be accessed from the object that contains
it. Unlike private , the field can’t also be accessed by other instances of the same type,
making it more private than the plain private setting.

33. In Scala there’s no direct way to control which superclass constructor is called from
an auxiliary constructor in a subclass. In fact, because each auxiliary constructor must
call a previously defined constructor in the same class, all auxiliary constructors will
eventually call the same superclass constructor that’s called from the subclass’s primary
constructor.

34. There are two main reasons to use an abstract class in Scala:
• You want to create a base class that requires constructor arguments.
• The code will be called from Java code.

35. The way abstract fields work in abstract classes (or traits) is
interesting:
• An abstract var field results in getter and setter methods being generated for the
field.
• An abstract val field results in a getter method being generated for the field.
• When you define an abstract field in an abstract class or trait, the Scala compiler
does not create a field in the resulting code; it only generates the methods that
correspond to the val or var field.

36. When we provide concrete values for these fields in your concrete
classes, you must again define your fields to be val or var . Because the fields don’t
actually exist in the abstract base class (or trait), the override keyword is not necessary.

37. To prevent a concrete val field in an abstract base class from being overridden in a
subclass, declare the field as a final val.

38. Defining a class as a case class results in a lot of boilerplate code being generated, with
the following benefits:
• An apply method is generated, so you don’t need to use the new keyword to create
a new instance of the class.
• Accessor methods are generated for the constructor parameters because case class
constructor parameters are val by default. Mutator methods are also generated for
parameters declared as var .
• A good, default toString method is generated.
• An unapply method is generated, making it easy to use case classes in match ex‐
pressions.
• equals and hashCode methods are generated.
• A copy method is generated.

39. The first thing to know about Scala and the equals method is that, unlike Java, you
compare the equality of two objects with == . In Java, the == operator compares “reference
equality,” but in Scala, == is a method you use on each class to compare the equality of
two instances, calling your equals method under the covers.
