With our controllers in place we can try and insetr some complex data into our database.

Let us push a POST request onto our Coach endpoint with the following information

```JSON
{


"firstname": "Jack",

"lastname": "Bauer",

"expertise": [

"Mysql"

],

"givingCourses": [

{

"id": 1,

"subject": "Mysql",

"attendingStudents": []

}

],

"headCoachOf": []

}
```

This should pass no problem.

Now try to get the Information back by sending the corresponding Get Request

If you now get an Error 500 Internal Server Error, that is expected. In Fact Postman is unable to Handle the Information it just got back because your application just threw an exception.

First let us configure How Spring handles Errors comming from the Server.

 O^pen your application.yml file and add the following
 ```yml
server:

	error:

		include-message: always

		include-binding-errors: always

		include-stacktrace: never

		include-exception: true
```

This Information instructs Spring on How to return errors to you.

Now let us open a terminal and use curl to send the get request.

since postman cant handle the backlash we can run

```
curl http://127.0.0.1:8080/coach
```

and you get the data back including an error message similar to this:

```
{"timestamp":"2023-05-06T09:07:08.629+00:00","status":200,"error":"OK","exception":"org.springframework.http.converter.HttpMessageNotWritableException","message":"Could not write JSON: Infinite recursion (StackOverflowError)","path":"/coach"}
```

In Fact what happens is that we are trying to build Json out of objects in a list that contain Lists of Objects and our code doesen't Know where to stop, eventually causing our memory to run Out because we are stuck in an infinite loop causing what's known as StackOverflow.

In order to stop this from Happening we need to tell Spring, or more precisely the java Jackson library, that is responsible for converting between Objects and Json, what fields it should handle.

Spring has 3 Annotations for that.

- @JsonManagedReference 
- @JsonBackReference 
- @JsonIgnore 

Elemets marked with @JsonManagedReference get treated normally, we use these on the parts we want to see.

The back part of the relationships will be annotated with @JsonBackReference and will not be translated into Json. This will avoid the chain and thus the resulting error.

Alternatively, we can use @JsonIgnore to exclude a field from serialisation entierly.

So let us now modify our Coach Model by adding @ManagedReference to the givingCourses and headCoachof

Accordingly we need to add @JsonBackReference to the Courses responsible coach field and the promotions headCoach field.

We need to modify the rest of our Models in a similar way. I Will show you my choices for each class on the next page but choosin wich side of a relationship to manage and wich to exclude is ultimately up to you.


[Example Models]
 