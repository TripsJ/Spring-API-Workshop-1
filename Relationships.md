# Relationships

In order to get an idea how our tables relate to each other, it is a good idea to draw out an Entity relation diagram.

These diagrams are visual representations of a database structure and look a bit like this.

![[Pasted image 20230502105457.png]]

You can use tools like draw.io or [smartdraw.com](https://cloud.smartdraw.com) to create them.

You will note in the diagram above, I have indicated what fields are in relation to each other by lines. I also indicated the number of elements a field can contain with a number next to it.
***n*** represents an arbitrary number of elements.

If you observe the Diagram carefully, you will notice that the promotions HeadCoach is not yet related to a coach. That is because the Coach class does not have a field to contain the promotions he leads.

Let us fix that.
In our Coach class, add a new private field, let's call it headCoachOf. That field should be an array and contain the promotions a Coach has led or is leading.

```Java
private Promotion[] headCoachOf;
```

Next let's add that field to our diagram and indicate the relation to the Promotion.

![[Pasted image 20230502111708.png]]

You can probably tell, but there are 3 main types of relations:

- One to One (as in the relationship between spouses)
- One to Many (like the relationship between Students and promotions. One promotion can contain many Students, but each student can only be in one promotion)
- Many to Many (like the relationship between Students and Courses)

## Indicating Relations in our Classes.

The Jakarta persistence library comes with a set of handy annotations to indicate the relations between fields. Those are
- @OneToOne
- @OneToMany and its counterpart @ManyToOne 
- @ManyToMany 

As we can see in our Diagram above, we do not have One-To-One Relationships. As such, we will start by implementing our 1 to many Relationships.

### One to Many

Our Database contains a couple of One-to-many relationships, I will show you how to implement the relationship between Promotion and Student, but the same applies to Coaches and Courses or Coaches and Promotions.

First we go to the One part of our relationship, in this case the Promotion class, specifically its containedStudents[] field.
We annotate this field with @ManyToOne 

Next we go to our Many end of the relationship, the Student class, and annotate its promotion field with the inverse relation @OneToMany. 

Now we need to get back to our Promotion and tell Java which field the relationship is supposed to use, we do that by adding to our @OneToMany a parameter (mappedBy = "Name of the corresponding @ManyToOne Field ").

```Java
@OneToMany(mappedBy = "promotion")

private List<Student> containedStudents;
```

And that's it. 

The relationship is now established.

Next we will see how to implement a Many-to-Many relationship.

### Many To Many

If we go back to our diagram, we can see that the relationship between Students and Courses is n to n or otherwise known as Many to Many.

![[Pasted image 20230502122635.png]]

Let us see how to implement that type of relationship.

Many-to-Many relationships need an additional database table to be created in MySQL, as there is no way to support that kind of relationship without that intermediary Join Table in MySQL. However, we can instruct JPA to do that for us.

First we add
```Java
@ManyToMany(cascade = CascadeType.ALL)
```

Cascade defines how to treat elements with multiple entries.
On top of our courses' field in the Student's class.
Below that, we need to instruct JPA to create our intermediary table with @JoinTable. 

We require that join table to have a name and map the column ID of student to the column ID of Promotion.
We can set that up by passing in the following parameters.

```Java
@JoinTable(name = "Student_Promotion",

joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),

inverseJoinColumns = @JoinColumn(name = "course_id",

referencedColumnName = "id"))
```


Next we need the other end of the relationship to be annotated as well, so we go to our Course class and annotate the attendingStudents field as follows
```Java
@ManyToMany(mappedBy ="courses")
```
 As previously, we simply tell it what field it is mapped to.

As an exercise, try to establish the missing relations as shown above.

I will show you all the classes on the next page.

[Established Relations](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Established%20Relations.md)
