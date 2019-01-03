package hello;

/*
    Create a representation class
    First, give some thought to what your API will look like.

    You want to handle GET requests for /hello-world, optionally with a name query parameter. In response to such a request, you will send back JSON, representing a greeting, that looks something like this:

    {
        "id": 1,
        "content": "Hello, World!"
    }
    The id field is a unique identifier for the greeting, and content is the textual representation of the greeting.

    To model the greeting representation, create a representation class:
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
