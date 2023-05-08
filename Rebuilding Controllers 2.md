## The Put Request

Updating follows the same logic as saving and uses the same methods, only the mapping changes. But to not unintentionally save something we need to verify if a student by that id already exists. Now we have already seen a method for that
```Java
studentRepository.findById();
```
and we had Lombok create Getters and setters on our Student object so we can use getId() to retrieve a student objects id.
As before we can map a Method to a Put Request by using @PutMapping.

Using studentRepository.save() on an entry that already exists would update that entry. 

Now you could be inclined to do something like this:

```Java
@PutMapping("/student")
public Student updateStudent(@RequestBody Student s) {

try {

Optional<Student>found=getById(s.getId());

studentRepository.save(s);

return s;

}

catch (ResponseStatusException e) {

throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Resource");

}

}
```


This is in my opinion not very clean. 
This takes advantage o the exceprions abillity to interrupt code execution.

If getById() throws an exeception, the code is interrupted right there, wich is why we need to execute that first.


Reusing our repositories methods and throwing an appropriate exception would be better, so let us do that instead:

```Java
public Student updateStudent(@RequestBody Student s) {

Optional<Student>found= studentRepository.findById(s.getId());

if (found.isEmpty()) {

throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Resource");

}

else {

studentRepository.save(s);

return s;

}
```

Now the last thing we need is to delete our Students from our database by sending a Delete Request.

## Deleting

Our repository provides multiple methods for deleting Objects, the one we are going to use here is the deleteById() method.

It functions very much like a getById() in that it can take a path variable and pass that to the method.

```Java

@DeleteMapping("/student/{sid}")

public String deleteById(@PathVariable Integer sid) {

studentRepository.deleteById(sid);

return "deleted";

}
```
Nothing too complicated here.

And now we can do the same for our other Controllers.

[[All Controllers]]