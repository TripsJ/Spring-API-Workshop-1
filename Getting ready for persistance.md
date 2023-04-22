
# Introduction

We now have a Rest Api with some Endpoints, However we are still working on Dummy Data.

In order to make a usable application we will need a way to store the data. 

To achieve this, we will use a Mysql Database and add endpoints and methods for all CRUD operations. 

While doing that, we will learn a few new concepts like Service classes, Interfaces, Inheritance and dependencie Injection. 

## Dependencies.

we need to add a couple of dependencies to our project

- spring-boot-starter-data-jpa: Enables Communication with the Database
- mysql-connector-j: Lets us use a MySQL Database


When we set up our project, we selected a build Manager for our project. We Chose Maven.

Maven manages the dependencies of our project and to do that it uses a file called pom.xml. We can find that file at the root of our project and you might have taken a look at it before, specifically to verify that lombok was included.
Pom stands for Project Object Model.

The contents of that file look like this

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

<modelVersion>4.0.0</modelVersion>

<parent>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-parent</artifactId>

<version>3.0.5</version>

<relativePath/> <!-- lookup parent from repository -->

</parent>

<groupId>org.workshop.spring</groupId>

<artifactId>CourseApi</artifactId>

<version>0.0.1-SNAPSHOT</version>

<name>CourseApi</name>

<description>Demo project for Spring Boot</description>

<properties>

<java.version>20</java.version>

</properties>

<dependencies>

<dependency>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-web</artifactId>

</dependency>

<dependency>

<groupId>org.projectlombok</groupId>

<artifactId>lombok</artifactId>

<optional>true</optional>

</dependency>

<dependency>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-test</artifactId>

<scope>test</scope>

</dependency>

</dependencies>

<build>

<plugins>

<plugin>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-maven-plugin</artifactId>

<configuration>

<excludes>

<exclude>

<groupId>org.projectlombok</groupId>

<artifactId>lombok</artifactId>

</exclude>

</excludes>

</configuration>

</plugin>

</plugins>

</build>

</project>
```

The lines until <parent> contain information about the structure of the pom.xml itself as well as where to find its schema. 
For our purposes we can leave those as is and you generally dont need to touch those as spring initializer should always include a current shema.

The <parent> section itself contains information about the version of spring boot that we use to create our project. And, unless you change the Framework version midway in a project, the Initializer takes care of setting this up too. 

Afterwards we find these lines:

```xml
<groupId>org.workshop.spring</groupId>

<artifactId>CourseApi</artifactId>

<version>0.0.1-SNAPSHOT</version>

<name>CourseApi</name>

<description>Demo project for Spring Boot</description>
```


This s the information about our project that we gave the initializer when we generated the project.

below that we define the properties of our project, wich currently just contains the version of java we use.

the <dependencies> section is where things get interesting,

this section specifies which external packages our project needs to be build, these packages can that be retrieved by your IDE from Apache Maven's servers.

That way we dont have to manually add jar files to our project.


Below the </dependencies> section we find the build section that contains information on plugins used to build our project.
Project lombok icludes one such plugin.

Optionally, there can also be a <reporting> section that includes its own plugins.

The Maven project website provides more detailed documentation on Maven and the pom.xml file

[Maven – Welcome to Apache Maven](https://maven.apache.org)

## Adding Dependencies

Adding a dependency is fairly easy.

all dependencies follow the same structure and look a lot like this:

```xml
<dependency>

<groupId>org.projectlombok</groupId>

<artifactId>lombok</artifactId>

<optional>true</optional>

</dependency>
```

and to add one, you simply add its <dependency> definition to the end of your <dependencies> block. So just before the closing </dependencies> tag.

In order to find the definition for a specific package we use the Maven repository that is hosted at https://mvnrepository.com.

Now let us add the required packages.

- spring-boot-starter-data-jpa
- mysql-connector-j

Search for each one of them and Select the latest version.

The Website will propose Maven dependency blocks for each of them.

![[Pasted image 20230422141844.png]]

Add those to your list of dependencies in your pom.xml file, save the file and left click on your pom.xml file in the project window, go to Maven => Update project.

You end up in this window.

![[Pasted image 20230422142141.png]]

Make sure your Project name is ticked as well as update Project configuration from pom.xml

Click ok and your IDE will now import the missing packages.

Once that is done, we can

[Configure the Database](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Database%20Configuration.md)



