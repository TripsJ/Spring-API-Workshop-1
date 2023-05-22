
# Advanced Datatypes and Autoboxing.

When we have a look at our cleaned up Student Class, we notice that there are variables of type String.
There are also Variables that end with [].

``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter


public class Student {

// Fields

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;


}
```

## Strings

A String is an example of an Advanced Datatype.

Strings are Objects and thus come with their own methods that can be called to work and Manipulate Stings. Strings are a representation of text.

In the case of Strings, some methods included, are,

| Method               | Effect                             |
| -------------------- | ---------------------------------- |
| String.toUpperCase() | Converts a String to ALL UPPERCASE |
| String.toLowerCase() | Converts a String to all lowercase |
| String.length()      | returns the length of the String   |

Many more String methods are available to us by looking at the Documentation

## Arrays

when we look at our Code, we also Notice this line,

```Java
private Course[] courses;

```

Variables whose type ends on [] are Arrays.
Arrays are indexed collections of elements of a given type.

In our case of type Course
They allow us to store multiple objects and retrieve them by their place in the list.

Let us define an array of type char and store a few letters in it.

```Java
char[] letters = {'A','B','C'};
```

To retrieve these, one would use a syntax like:

```Java
letters[0]; // Would return 'A'
letters[1]; // Would return 'B'
letters[2]; // Would return 'C'
```

Arrays are useful to avoid creating redundant variables.


## Wrapper Classes

Java has Wrapper classes that allow us to store the 8 primitive Datatypes in the form of Objects


| Primitive | Wrapper   |
| --------- | --------- |
| boolean   | Boolean   |
| char      | Character |
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |

You can use those just as you would the primitives, but they are complete Objects, which allows us to use Advanced Java features on them that are Object exclusive.

Let us now return to our Student class and finish cleaning it up.

[Data Classes 2](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Dataclasses_2.md)
