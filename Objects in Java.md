# What are Objects in Java

An object is javas way of representing a real world thing as data. Objects exist in memory and are defined by a class of the corresponding name. You define a Class with its Attributes and methods, Getters, Setters and Constructors.

we will get through does line step by step in the next chapter and use this chapter to give you a broad overview.

Below you will find the code For a Dummy object.

``` java
public class Dummy {
// Attribules
    private String name;
    private int age;
    private float height;

    public void sayHello(){
        System.out.print("Hello");
    }
    
// Constructor
    public Dummy(){ 

        } 
// Getters and Setters
    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

        }

    public int getAge() {

        return age;

    }

    public void setAge(int age) {

        this.age = age;

    }

    public float getHeight() {

        return height;

    }

    public void setHeight(float height) {

        this.height = height;

    }

// toString Method
    @Override

    public String toString() {

        return "Dummy [name=" + name + ", age=" + age + ", height=" + height + "]";

    }

        
    

}
```

Attributes represent everything an object Knows while methods are more what an Object can do.

Objects in Java come with all the bells and Whistle modern Programming languages are used to but they do need a lot of boilerplate code.

In this Dummy class you will see a few things.

### 1. The attributes are typed:

``` java
private String name;
private int age;
private float height;
```

In fact, Java is a strictly typed programming language, witch means that Attributes need to specify what type of data they contain.
In this case String, int and float

Also, as we mentioned earlier, methods need that too:

``` java
public void sayHello(){
        System.out.print("Hello");
    }
```

Here we define the return value of sayHello() to be of type void.

### 2. The Constructor

In our Dummy class we find the following code

``` java
public Dummy(){ 

} 
```

this is a Constructor; the Constructor tells Java, or more accurately the Java Virtual Machine, how to instantiate, or build, an object of a class.

Constructors can be empty, in wich case Java supposes its a builtin default constructor, or they can have parameters and associated values and even method calls. We will see more complex constructors later in this workshop.

They will always be named after the class they construct objects of.

# 

Imagine a Project where we need Students with fields like this

**Class Student**

\[\[5. Projects/Workshop Java Spring API/#\^Table\]\]

Suddenly the Object gets a lot more complex and would look like this:

``` java

import java.util.Arrays;

public class Student {

// Fields

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

//getters and Setters

public String getUsername() {

return username;

}

public void setUsername(String username) {

this.username = username;

}

public Promotion getPromotion() {

return promotion;

}

public void setPromotion(Promotion promotion) {

this.promotion = promotion;

}

public String getOrientation() {

return orientation;

}

public void setOrientation(String orientation) {

this.orientation = orientation;

}

public Course[] getCourses() {

return courses;

}

public void setCourses(Course[] courses) {

this.courses = courses;

}

public Coach[] getResponsibleCoaches() {

return responsibleCoaches;

}

public void setResponsibleCoaches(Coach[] responsibleCoaches) {

this.responsibleCoaches = responsibleCoaches;

}

public Student(String username, Promotion promotion, String orientation, Course[] courses,

Coach[] responsibleCoaches) {

super();

this.username = username;

this.promotion = promotion;

this.orientation = orientation;

this.courses = courses;

this.responsibleCoaches = responsibleCoaches;

}

@Override

public String toString() {

return "Student [username=" + username + ", promotion=" + promotion + ", orientation=" + orientation

+ ", courses=" + Arrays.toString(courses) + ", responsibleCoaches="

+ Arrays.toString(responsibleCoaches) + "]";

}

}
```

and all this does is represent a Student, we still need Promotions, Courses and Coaches all in their own classes

that makes for a lot of typing work, and makes your code harder to read. There are still a few interesting things to go through in our student class, so, as we did earlier with Hello World, let us see the Student class line by line

\[\[Anatomy of the Student class\]\]
