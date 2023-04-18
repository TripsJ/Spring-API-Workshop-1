In the Previous section we wrote the following code

```` java
    package ApiCreation;

    public class Hello {

        public static void main(String[] args) {

            System.out.print("Hello World");

        }

    }
    
    ```

I Will now attempt to provide a little bit of explanation by going through that code line by line.


```Java
    package ApiCreation;
````

the package declaration defines the package the following code is part of.

The Folder the file is saved in needs to correspond to the package name. Modern IDE's can take care of that for us.

``` java
public class Hello {
```

this line does multiple things
1. **public** is an access modifier. it defines under wich circumstances Attributes and methods in the following component can be accessed by other parts of the program, or other programs

**public** : can be accessed anywhere by anyone

**protected**: can only be accessed by child classes and classes within the same package

**default**: if no access modifier is applied the component can only be accessed from within the same package

**private**: can only be accessed from within the same class.

2.  **class**: the class keyword defines that the following code is a class. You can think of classes as blueprints for objects.

3.  Hello is the name of the class, that name also becomes the type of all objects created (or instantiated) from this class.

4.  { defines the beginning of the code block that those modifiers will be applied to

``` java
public static void main(String[] args) {
```

This is the main method.
Once our program is executed, this line indicates the starting point of the program.

The syntax is fixed so your main method will always be

``` java
public static void main(String[] args) {
```

public is the access modifier as we saw before.

**static** defines the method as a class method, thus we dont need an object to call it.

**void** is the return type, so the type of data the method gives back. in this case it returns nothing, thus the type is void

**(String\[\] args)** is the argument, so the type of data that is passed along with the method when the method is called
in this case it is an array (represented by \[\]) of Strings and said array is named args.

``` java
System.out.print("Hello World");
```

within our main method we call the print method
that method is part of Javas System.out package, wich is preinstalled with java.

It takes one argument, in this case a String denoted by "".
the ; is mandatory and denotes the end of a statement in java.
than } closes our main method
and the second } closes our class.

with those components defined we can compile and execute our program.

Using methods and classes we can create our own Objects to represent our own Data and Build our very own Projects.

[The Project](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/The%20Project.md)
