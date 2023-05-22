## What is Spring

  

Spring is the most popular Java Framework

It can take most of the object generation and initialization out of your hands.

It also provides a lot of annotations to make complex development tasks a breeze.

On top of Spring, a lot of starter packages were developed to ease dependency management.

A lot of those starter packages are included in Spring Boot.

  

## How to get started

  

it's very easy to get started,

Go to https://start.spring.io

  

### Spring boot and Spring initializer

  

The Website you are currently on is the Spring Initializer

  

![Spring Initializer](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230330141920.png)

  

Add Spring Web to the dependencies

Also, add Lombok to the dependencies

  

if we need anything else, we can still add them later

  

Next, Set the Project to Maven and the Language to Java

  

Select the Heighest Stable Spring Boot Version available. For Stability Avoid Snapshot and Release Candidates (M2) versions

  

For the Metadata, by convention, the group is a reverse domain name and the artifact is the Name of the package.

For the sake of this Workshop, I chose

  

Group: org.workshop.spring

  

Artifact: CourseApi

  

Name: CourseApi

  

Description:

  

Package name: org.workshop.spring.CourseApi

  

select packaging to Jar and your Java version to the highest available.

20 at the time of writing.

  

Finally, click on Generate and Save the resulting Zip file to your hard drive.

Extract it to a folder.

  

This is the Starting point of your Project. No more manual Package creation, the configuration is also created for us and the included dependencies are at the latest version already.

  

To use Spring effectively, you will need to understand 2 important concepts first

  

[[Inversion of Control]]