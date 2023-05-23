## Introduction

  

This workshop was originally created to be followed by my classmates in training. My aim was to provide you with a bit of a guideline to get up and running and introduce you to Java. To achieve that, I chose to build an API.

  

This workshop assumes:

- Basic programming knowledge.

- Knowledge of your chosen operating system

Furthermore, this workshop uses Eclipse IDE, which is free. 
[Eclipse Downloads \| The Eclipse Foundation](https://www.eclipse.org/downloads/)

  

We will make use of MySQL as our database which you can either get from your distribution's repository, or from here:
[MySQL:: MySQL Community Downloads](https://dev.mysql.com/downloads/)

  

You can install phpMyAdmin to have a graphical tool to work on your database. Again from your distro's repo or:

[PhpMyAdmin](https://www.phpmyadmin.net)

  

The easiest way to get those up and running is a Docker container. A good tutorial on that is here:

[Run MySQL and phpMyAdmin with Docker Compose | Lulu's blog](https://lucidar.me/en/docker/mysql-and-phpmyadmin-with-docker-compose/)

  

And I will use Postman for testing, which again can either be downloaded here: 
[Postman API Platform | Sign Up for Free](https://www.postman.com) Or in your distribution's repository.

  

I Include screenshots of Eclipse and Postman in this Workshop that show how you should set up a particular Eclipse function wherever that is helpful.

I find that far more appealing than giving you a list

1 Tick this

2 Tick that

3 untick That

  

The IDE takes care of installing Java and the Dependency management, called Maven.

  

1. Install Eclipse

  

2. Create a new Workspace in Eclipse

The Workspace keeps track of your IDEs setup as well as configurations and Plugins

  

3. Create a new Java Project. That project manages the Java Version used as well as the compiler and the Dependencies. Go To File \> New \> Java Project

![Pasted image 20230329154838.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230329154838.png)

  

4. Next we create a package. Packages are used in Java to reference and encapsulate certain parts of a program or even an entire program

File \> New \> Package

![Pasted image 20230329155657.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230329155657.png)

And now we create a Class

5. File \> New \> Class
![Pasted image 20230329155933.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230329155933.png)

6. You should have something like this

  

  

  

``` java

package ApiCreation;

  

public class Hello {

  

public static void main(String[] args) {

  

//Auto-Generated Comment Here

  

}

  

}

```

  

7. Remove the line Starting with //

  

8. put this in its place

`Java System.out.print("Hello World");`

  

Your Code should now Look like this:

  

``` java

package ApiCreation;

  

public class Hello {

  

public static void main(String[] args) {

  

System.out.print("Hello World");

  

}

  

}

```

  

9. Save and Run

  

10. **Congratulations, You just wrote your first Java program**

Wasn't that hard now, was it?

  

Ok, Enough with the Jokes.

As you can see, Java is complicated and requires a lot of boilerplate code.

  

Fortunately, There are Frameworks and Tools out there, that can make working with Java a lot easier.

Before we talk about those, I want to just quickly dissect the Code we wrote so you can understand what the individual components do.

  

[Anatomy of Hello World](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Anatomy%20of%20Hello%20World.md)
