## What are Arrays in Java


Put Simply, Arrays are objects that can store a predefined number of elements of a same type.

And therein lies the problem.

Up until now we dealt with arrays because we always knew how many Students, Coaches, Courses etc we had to deal with. Thus an array was the perfect fit. Now, with a database running behind it, we do not know how many entries we are going to have and hence we need a dynamic way of storing Elements.

To cover those needs, Java has the Collections Framework.


## Collections

The Collections Framework provides an architecture to store and manipulate groups of Objects in different ways. It allows searching, sort, insert, delete and Manipulate groups of objects.

One of the Data structures the Collections Framework can provide is a List. And that list is defined as an Interface.

To instantiate the List interface, we use the following Syntax:

1.  List <datatype> l1= new ArrayList();
2.  List <datatype> l2 = new LinkedList();
3.  List <datatype> l3 = new Vector();
4.  List <datatype> l4 = new Stack();

There are several implementations of the List interface that we will not go into because Spring Handels that for us.


## Interface


An interface is a special type of implementation that serves to define the minimum requirements of methods. You use interfaces to define the names, parameters, and return types of methods without having to worry about how those methods are implemented. You can later use the Interface as you would an Object type. 

We need to change our entities so that the Arrays are lists of Objects 

In the case of our Coach Class, that would mean changing it as follows.
```Java
public class Coach {

@Id

@GeneratedValue(strategy=GenerationType.AUTO)

private Integer id;

private String firstname;

private String lastname;

private String[] expertise;

@OneToMany(mappedBy= "responsibleCoach")

private List<Course> givingCourses;

@OneToMany(mappedBy = "headCoach")

private List<Promotion> headCoachOf;
}
```
Notice how i simply replaced the arrays below @OneToMany by lists of the same type. The expertise a remain an Array, as it is meant to be declared only once.

Similar changes are needed for the Course, Promotion, and Student classes

As a rule of thumb @OneToMany always stands above Collections.

Once all the changes are done, we can execute our code and login to our PhpMyAdmin to see the created tables.

Our code has become quite complex, and it is high time we looked into organizing it a bit.

[Refactor](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Refactor.md)
