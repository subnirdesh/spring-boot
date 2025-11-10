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




