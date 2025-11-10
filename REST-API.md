# REST API

## What is REST API? 
REST (Representational State Transfer) is an architectural style for building web services. A REST API is a way for different applications to communicate with each other over HTTP, using standard web protocols.

**Key Purposes**

- Enable Communication -> Allow different applications (mobile apps, web apps, other servers) to talk to your backend
- Data Exchange - Send and receive data in a standardized format (usually JSON)
- Separation of Concerns - Frontend and backend can be developed independently
- Reusability - One API can serve multiple clients (web, mobile, desktop)

##Main HTTP Methods

**GET - Retrieve/Read**

  - Purpose: Fetch data without modifying anything
  - Safe (doesn't change server state)
  - Idempotent (calling it 100 times = calling it once)
  - **GET** is idempotent because repeating it doesn’t change the server’s state.
  - Can be cached
  - Parameters go in URL (query strings)

**POST - Create**

- Purpose: Create a new resource
- Not idempotent (calling twice creates two resources)
- Data sent in request body
- Returns 201 (Created) with location header

**PUT - Update/Replace**

- Purpose: Replace an entire resource or create if doesn't exist
- Idempotent (same result no matter how many times)
- Sends complete resource in body
- Must specify the resource ID in URL

**DELETE - Remove**

- Purpose: Delete a resource
- Idempotent (deleting multiple times has same effect)
- May return 204 (No Content) or 200 with confirmation

##  @Controller and @RestController
 Both @Controller and @RestController are Spring stereotypes that mark class as web controller; meaning they handle HTTP requests. But they work differently under the hood.
 
 **@Controller - The Traditional Way**
- Originally designed for MVC applications that return views (HTML pages).
- Returns view names (strings that resolve to HTML templates)
- Uses Model to pass data to views
- Works with template engines (Thymeleaf, JSP, Freemarker)
- For traditional server-side rendering
-  With @Controller:
  Spring checks the return type

  If it's a String, looks for a view with that name
  
  If method has @ResponseBody, converts return value to JSON/XML using HttpMessageConverter

**@RestController - The Modern REST Way**
- A convenience annotation that combines @Controller + @ResponseBody
- Every method automatically gets @ResponseBody behavior
- Perfect for REST APIs that return JSON/XML
- No need to add @ResponseBody to each method
- Cleaner code, less boilerplate
- With @RestController:
  
  Spring automatically applies @ResponseBody to all methods
  
  Converts all return values to JSON/XML
  
  No view resolution happens


 **Quick Reference** 


| Feature | @Controller | @RestController | 
|---------|-------------|-----------------|
| Purpose | MVC views | REST APIs |
| Returns | View names | Data (JSON/XML) |
| @ResponseBody | Manual on each method | Automatic on all methods |
| Use with | Thymeleaf, JSP | React, Angular, Mobile |
| Response | HTML pages | JSON/XML data |
| Best for | Traditional web apps | Modern SPAs, Microservices |

## Request Mapping and its variants 
Core Purpose: Maps HTTP requests to handler methods in your controller.
Think of it as routing - it tells Spring "when this URL is hit with this HTTP method, call this method."

```
@RestController
@RequestMapping("/api/users")  // Class-level: base path
public class UserController {
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    // URL: GET /api/users/all
}
```

**Specialized Variants (Shortcuts)**

Spring provides shorthand annotations that are cleaner and more readable:

| Annotation | HTTP Method | Use Case |
|------------|-------------|----------|
| @RequestMapping | Any (flexible) | Complex mappings, multiple methods, class-level |
| @GetMapping | GET | Retrieve data |
| @PostMapping | POST | Create new resource |
| @PutMapping | PUT | Update entire resource |
| @PatchMapping | PATCH | Partial update |
| @DeleteMapping | DELETE | Remove resource |

## Path Variable

**Core Purpose**: Extracts values from the URI path itself and binds them to method parameters.

```
@GetMapping("/products/{productId}")
public Product getProduct(@PathVariable Long productId) {
    return productService.findById(productId);
}
```

##  @RequestParam 
@RequestParam is a Spring Boot annotation that extracts query parameters from the URL and binds them to method parameters in your controller.

In simple words, it captures the key=value pairs that come after the ? in a URL and makes them available as Java variables in your code.
```
@RestController
@RequestMapping("/api")
public class SearchController {
    
    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return searchService.findByKeyword(keyword);
    }
    // URL: /api/search?keyword=laptop
    // keyword = "laptop"
}
```

Spring automatically converts string query parameters to Java types.

## @ResponseEntity

ResponseEntity is a Spring class that represents the entire HTTP response including:

- HTTP Status Code (200, 404, 500, etc.)
- Headers (Content-Type, Authorization, etc.)
- Body (The actual data - JSON, XML, etc.)

ResponseEntity is a wrapper that gives you complete control over the HTTP response you send back to the client.

** Structure of ResponseEntity
```
ResponseEntity<T>
    ↓
    ├── Status Code (HttpStatus)
    ├── Headers (HttpHeaders)
    └── Body (T - your data type)
```

## HTTP Status Code

```
1xx - Informational  → "Hold on, processing..."
2xx - Success        → "✓ All good!"
3xx - Redirection    → "→ Go somewhere else"
4xx - Client Error   → "✗ You made a mistake"
5xx - Server Error   → "✗ We made a mistake"
```








 
 
 

 




