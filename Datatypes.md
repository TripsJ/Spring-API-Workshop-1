
# Datatypes

Java is a *strictly typed* programming language. That means it needs the Programmer to specify the type of data the program is working with.

In order to do that, Java comes with 8 Datatypes that are referred to as primitive Datatypes. On top of that, more advanced Datatypes exsist as well. 
We will look at the primitive Datatypes first and later have a first look at more advanced ones.

## Primitive Datatypes

The 8 primitive Datatypes in Java are

| Datatype | Usage                                                          | Size    |
| -------- | -------------------------------------------------------------- | ------- |
| boolean  | represents truth values True or False                          | 1 byte  |
| char     | a single character                                             | 2 bytes |
| byte     | whole numbers between -128 and 127                             | 1 byte  |
| short    | whole numbers between -32,768 and 32,767                       | 2 bytes |
| int      | whole numbers between -2,147,483,648 and 2,147,483,647         | 4 bytes |
| long     | whole numbers up to 9,223,372,036,854,775,807 and its negative | 8 bytes |
| float    | floating point numbers with up to 6 decimal digits             | 4 bytes |
| double   | floating point numbers with up to 15 decimal digits            | 8 bytes |

As you can see from the table above, the primitive types differ in the amount of memory they occupy. This is one of the strong points of strict typing.
Knowing in advance how much memory a program will need can make for extremely memory efficient programs.

Let us now look at the syntax and how those primitive types are declared in Java

```Java

boolean result = true;
char capitalC = 'C';
byte b = 100;
short s = 10000;
int i = 100000;
double d1 = 123.4;
float f1  = 123.4f;
long bigLong = 9223372036854775807 ;
```

Note that Java provides syntax to use different numbering systems, such as binary or hexadecimal, but for the purpose of this tutorial we will not explore those.

Primitive datatypes are just that. They are there to store a certain type of data, nothing else. Al primitive Datatypes are declared using lowercase letters only.

Later we will encounter Objects and You will learn about more complex datatypes such as String.

Before we do that, i'll introduce you to the Project we will build during this Workshop.

[The Project](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/The%20Project.md)

