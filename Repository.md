As mentioned before, we need to implement an interface to perform operations on our database. That interface is called a Repository, and we can implement multiple different repositories, depending on what we do with them. For our purposes, we are going to use JPA Repositories.

In our repositories package, create a new Interface (Right click > New > Interface) and call it StudentRepository

```Java
public interface StudentRepository  {

}
```
Next, we will have that interface inherit methods from JPA Repository. According to the Documentation, said repository has the following fingerprint.

```Java
public interface JpaRepository<T,ID>
```

And that is something we haven't seen before, or have we?

Remember List<T> it's the same weird structure.

That structure is called a Generic.

Generics are Objects, or interfaces, that tale other Objects as Parameters. These parameters go between < > to differentiate them from normal methods.
Generics only work on Objects.

Remember, back when we introduced the Integer class?
That's why.

I will not tell you how to write generics yourself, but it is an interesting subject to look into.
 JPA repository needs an Object and a corresponding ID, that must be an Object too. We also want to inherit from it to our StudentRepository.

Thus we modify the interface as follows

```Java
public interface StudentRepository extends JpaRepository<Student,Integer>   {

}
```
Student is the Data Object we want to work on, Integer is the Type of its ID.
The repository does not need any content, as JpaRepository comes with everything we need for our application.
Do not forget that JpaRepository needs to be imported, as does our Model for each repository.

you go and create repositories for Promotion, Coach, and Course too.

[Our Repositories](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Our%20Repositories.md)
