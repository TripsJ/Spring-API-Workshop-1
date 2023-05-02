Right now our Student Object looks like this:

``` java
package org.workshop.spring.CourseApi;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Student {

private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

}
```

we can easily turn this into a table by adding 2 Annotations to the class

@Entity and @Table

these two are povided by jakarta.pesistance or JPA for short.

@Entity, tells JPA and with it Spring that the class represents a part of our database 
@Table tells it that that part is indeed a table. 
Tables are the default for Entity annotations but in order to make things clearer, you should still add @Table. Also, if you wanted to change the Tables name you need to add @Table too. If no name is specified, the class name will be used.

With that our Student class now looks like this.

```Java

package workshop.spring.courseapi;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@Entity

@Table

public class Student {



private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;

}
```

Remember that every row in a Database need an id. We have an Attribute for that but we need to tell Java that this is indeed the id for our entry and how to generate it. Lucky for us, jakarta persistence has annotations for that too.

@Id will tell java wich field to use as the id for a database entry. 
@GeneratedValue will define that the value of a field is automatically generated. it needs an argument to specify how the value is supposed to be derived the so called strategy.

In our case, @GeneratedValue(strategy=GenerationType.AUTO) will set the generation to automatic and should serve us just fine.

So let us add both of those on top of our id field and import the dependencies.

Our student class should now look like this.

```Java

package workshop.spring.courseapi;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@Entity

@Table

public class Student {

@Id

@GeneratedValue(strategy=GenerationType.AUTO)

private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;

}
```

Next we need to make sure our Coach, Promotion and Course classes are their respective tables too and i am sure you can do that by yourselves, so go ahead and modify them as needed and i will show you the results on the next page.

**relations need to be established FOR TABLE CREATION TO WORK**

[[Our Tables]]