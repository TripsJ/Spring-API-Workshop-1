
At this point, we will need a database. 
As mentioned in the beginning, i assume that you have phpmyadmin and mysql installed and set up.

Log into phpmyadmin and create a new database. Depending on your setup, this may require you to login as root.

*the following is the database setup i will be using from here on.
Your setup may vary and you should never expose a password.*


```

I will use testdb as a database  name
the root users name is root
the root password is 1234
the standard users username is user
the users password is 1234
and my database runs on localhost port 6033

```


## application.properties 

During initialisation, our project was set up with a /source/main/java folder and a /source/main/resources folder

The first one is, as you probably figured out, where all your java packages live under.

The second one contains templates, static content and application specific configuration files.

your  project has been initialized with an empty application.properties file.

that file can be used to configure your application, however there exists a more modern syntax in the form of an application.yml file.

.yml is a YAML file and YAML (Yet Another Markup Language) is a type of markup language that is very easy to read.

In a normal application.properties file, you need to specify a full configuration key per line where as a yaml file can structure those in parent and child keys.

Not only does that make your configuration more readable, it also saves you typing and adds structure.

As such i want you to rename your application.properties file to application.yml by right clicking and selecting Refactor => Rename.

**In YAML Spaces matter and indentation is important.**

we will use that file to configure our database.

set it up as follows

**application.yml**

```Yaml
spring:

	jpa:

		hibernate:

			ddl-auto: update

		show-sql: true

	datasource:

		url: jdbc:mysql://localhost:6033/testdb

		username: user

		password: 1234

		driver-class-name: com.mysql.cj.jdbc.Driver
```

you will need to adapt that configuration where necessary.

	you notice that i only use a user account to connect to the database. I do that for 2 reasons:
	1. root has too much power over the system so outside of the database
	2. we can easily restrict the Users rights once everything is set up and running.

In order to do that, connect as root to your database or phpmyadmin and run the following SQL command

```SQL
grant all on testdb.* to 'user'@'%';
```

that grants all the rights on the database to the user "user".
We should however modify that once we are all set up and all tables are created.

Speaking of Tables, we  need to modify our Dataclasses so Spring and JPA know that they have to deal with a table now.

[Making Tables](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Making%20Tables.md)
