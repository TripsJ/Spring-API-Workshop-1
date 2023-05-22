## Refactoring code

If we have a look at our files, it is easy to get confused by the sheer number of files, That is one of the reasons why Java developers often use sub packages to manage their files. We are going to do the same.

In our package "org.workshop.spring.CourseApi" we are going to right-click select > New > Package or New > Other > Package and create a Package org.workshop.spring.CourseApi.Models

Move the Student.java, Promotion.java, Coach.Java and Course.java into that package by drag and drop. Eclipse will as if it should refactor, where you accept without modifying anything.

The Same way, we will create a package org.workshop.spring.CourseApi.Controllers where we will move our controllers.

After that, only one file should remain in our main package.
If you now have a look at any of your Models or Controllers, the first line should have been changed to include the new package name.

Other than improving visibility, structuring your code in multiple packages also helps to further restrict the access of certain classes, thus making sure a class only accesses the parts of our code it is supposed to access.

Now create a new package again and call it
package org.workshop.spring.CourseApi.Repositories

We are going to create files in that package that will help us to access our database.

[[Inheritance]]


