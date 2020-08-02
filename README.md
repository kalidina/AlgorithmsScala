# AlgorithmsScala
Implement algorithms in scala

Learnings:

-  [Operators] : 

        No increment operators(eg: variable++) in scala
-  [Idioms] : 

        Use the Scala Option/Some/None idiom to initialize empty var fields — and specifically DO NOT use null values for the same purpose.
        Eg: https://alvinalexander.com/scala/initialize-scala-variables-option-none-some-null-idiom/
-  [Class] : 
             
         using var in class constructor(for class members), makes the members private but mutable.
         
         using val in class constructor(for class members), makes the members private and immutable.
-  [Method] : 

         All method arguments are val's in Scala. so method cannot change arguments values.
