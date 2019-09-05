public class Book
{
    //  class: collection of state and behavior that compleely describe something
    //  state: fields (AKA attributes)
    //  behavior: methods

    //  object: instance of class
    //  a class = blueprint, object is realization of that blueprint

    //fields:
    private String title; // make attributes private unless you absolutely have to
    private String author;
    private int numPages;

    //  constructors
    //  we get a default value constructor (DVC) for free
    //  - assigns all private member variables default variables

    //  explicit value constructor (EVC):
    public Book(String title, String paramAuthor, int paramPages)
    {
        //  this is a keyword that refers to the invoking obj.
        //      - Invoking object: object being created
        //      - this is reference to the created object
        this.title = title; //  shadowing .. the parameter title shadows the field title
        author = paramAuthor;
        numPages = paramPages;
    }

    //  when we define our own constructor we lose the free DVC so we have to make out own
    public Book()
    {
        title = "BLANK_TITLE";
        author = "BLANK_AUTHOR";
        numPages = -1;
    }

    //  we inherit several useful methds from Object
    //  toString()
    //  we will override the toString() method we inherit from Object

    //  ANNOTATIONS
    //  metadata/metainformation used by compiler and IDE
    //  not part of source code
    //  @Override @Deprecated @SuppressWarnings

    @Override
    public String toString()
    {
        //  returns a string representation of the object
        return title+" by "+author;
    }

    //  access modifiers
    //  1. public (accessible everywhere)
    //  2. package private (accessible within the package)
    //  3. protected (package-private + accessible by subclasses)
    //  4. private (only accessible to the class)

    //  getters and setters
    //  you and only you should control access to your class members (encapsulation)

    //getters (AKA accessors)
    public String getTitle()
    {
        //  this ensures that the object invoking the method is the only one that is operated on
        //  if this was static no object reference would be needed

        // static = class level, this = object level
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public int getNumPages()
    {
        return this.numPages;
    }

    //setters (AKA mutators)
    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor)
    {
        this.author = newAuthor;
    }

    public void setPages(int newNumPages)
    {
        this.numPages = newNumPages;
    }

    //  IntelliJ keyboard shortcut for making getters and setters : Alt + Insert !!!!
    //  IntelliJ keyboard shortcut for all overridable methods : ctrl + x

    //  task 2: in this project create a Point class and a PointTester class
    //  Point representes point in 2D space with x and y coord
    //  toString()
}
