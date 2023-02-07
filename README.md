# Url-shortener
This service receive a url and shortens it.

#### Example
- The system receives a post to shorten the url `google.com` and returns the following json

``` 
{ 
  url: "http://localhost:8080/abc123ab";
} 
```
- On receiving a get to `http://localhost:8081/abc123ab` it will return a redirect to the url saved in the database (`google.com`)
