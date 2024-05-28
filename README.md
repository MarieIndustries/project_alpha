# project_alpha

### A rest API that has a repository of jokes. 

This is a small project to demonstrate testing REST APIs with integrated tests using Cucumber

You can say this is a bit of a tutorial on how to set up a REST API alongside integrated Cucumber tests

### Set Up
1. Bring in the appropriate dependencies in the pom.xml
2. Hammer out your feature file and its specification
3. Set up the Cucumber testing infrastructure:
      * Set up your IT runner file - see annotations on com.marieindustries.project_alpha.CucumberIT
      * Steps file (since when you run com.marieindustries.project_alpha.CucumberIT it will help you add steps)
      * Services are split into their own classes
        * The top-most layer is DomainSpecificLanguage (which will allow you to access the necessary BDD services)
        * BddJokesService (which will specify the API call)
        * BddMockMvcService (which mock performs the actual generic REST API call). 
4. This far should get you to the mock rest call, which should fail. Now you can implement the real REST API code


### REST API creation
1. You can start with your REST controller. Make a controller class and annotate with @RestController, and it's a good practice to define the API's mapping at the class level with @RequestMapping
2. Which method do you want to implement first, to pass the tests? Pick one of the CRUD operations.
3. Now you've picked your operation, which HTTP protocol fits it? GET, POST, PUT, DELETE. Use the specific RequestMapping annotations, that is @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
4. Decide how you're going to bring in your necessary identifiers to the method. Is it a @RequestParam? A @PathVariable? A @RequestBody? If you need help deciding, see https://stackoverflow.com/questions/67649464/difference-between-pathvariable-requestparam-and-requestbody#:~:text=Example%201%3A-,%40RequestParam,-is%20used%20mainly
5. But.. never use verb naming for the endpoints!
6. So you have to action your HTTP protocol... you'll probably need a repository. Remember, Spring can handle it for you with JpaRepository 
7. Make sure you have the JpaRepository dependency added, and might as well add the H2 (or other db) dependency
8. We need to enable JpaRepository so once you create your repo interface that extends JpaRepository - your entity will need to be set up with @Entity; don't forget it needs a no-arg constructor
9. Next create a JpaConfiguration file to support the repository. It is a @Configuration and will need @EnableTransactionManagement


### Finishing the tests
1. You will need to verify your expected and actual match. First we need to pull in the data from the expected
      * A simple string is easy enough to match. But normally, we have Datatables
2. Assuming we have a Datatable, we will pull it in as a parameter in the Given/When/Then method
3. Imagine the Datatable as a spreadsheet, and for each row we have to assemble an object using the data column names
      * This is where streams come in handy... we take the Datatable as a stream, and then map it - that is, apply a function to extract out the data and assemble our object, and then bundle them up in a List
4. Of course, we need the result from our actual 
5. We then compare the expected and actual (likely they are both Lists) via size and perhaps with a simple for-loop


