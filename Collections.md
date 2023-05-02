## What are Arrays in Java


Put Simply Arrays are objects that can store a predefined number of elements of a same type.

And therein lies the problem.

Up until now we dealt with Arrays because we always knew how many Students, Coaches, Courses etc we had to deal with. Thus an array was the perfect fit. Now, with a database running behind it,we do not know how many entries we are going to have and hence we need a dynamic way of storing Elements.

To cover those needs Java has the Collections Framework.


## Collections

The Collections Framework provides an architecture to store and manipulate groups of Objects in different ways. It allows to search, sort, insert, delete and Manipulate groups of objects.

One of the Datastructures the Collections Framework can provide is a List. And that list is defined as an Interface.

To instantiate the List interface, we use the following Syntax:

1.  List <data-type> list1= new ArrayList();
2.  List <data-type> list2 = new LinkedList();  
3.  List <data-type> list3 = new Vector();  
4.  List <data-type> list4 = new Stack();

There are several implementations of the List interface that we will not go into because Spring Handels that for us.


## Interface


An interface is a special type of implementation that serves to define the minimum requirements of methods. You use interfaces to define the names, parameters and return types of methods without having to worry about how those methods are implemented. You can later use the Interface as you would an Object type. 

We need to change our entities so that the Arrays are lists of Objects 

in the case of our Coach Class that would mean changing it as follows.
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
Notice how i simply replaced the Arrays below @OneToMany by lists of the same type. The expertise an remain an Array as it is meant to be declared only once.

Similar changes are needed for the Course, Promotion and Student classes

As a rule of thumb @OneToMany always stands above Collections.

Once all the changes are done, we can execute our code and login to our phpMyAdmin to see the created tables.

With this we need to find a way to interact with the Database by creating what is known as a Repository.

[[Repository]]
