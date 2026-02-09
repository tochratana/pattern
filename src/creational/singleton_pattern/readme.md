### 1. What is Singleton Pattern?

Singleton = Only ONE object in the whole program

No matter how many times you call it → you always get the same instance.

Used when:

- Database connection 
- Logger 
- Config / Settings 
- Cache 
- Thread pool

### 2. Your Code Explained
- Class Declaration 
- class User
- private static User instance;

> static → belongs to class (shared)

Only one variable to store the single object

Private Constructor
```bash
private User(String uuid){
this.uuid = uuid;
}
```
Why private ❓

So no one can create object using new User()

❌ This is NOT allowed:

```bash
User u = new User(); // ERROR (constructor is private)
```


Only the class itself can create the object.

getInstance() — The Heart of Singleton
```bash
public static User getInstance(){
if(instance==null){
instance = new User(UUID.randomUUID().toString());
  }
  return instance;
}
```


Logic:

Step	What Happens
1. First call → instance == null 
2. Create new User object 
3. Store inside static instance 
4. Return it 
5. Next calls → instance != null → return same object

So object is created ONLY ONE TIME.

UUID Field
private String uuid;


Each object would normally have different UUID, but since only one object exists, UUID is always same.

### 3. Main Method Behavior
```bash
   User user1 = User.getInstance();
   User user2 = User.getInstance();
   User user3 = User.getInstance();
   ...
```

Even though you call 6 times → ALL variables point to same object

Memory view:
```bash
user1 ─┐
user2 ─┤
user3 ─┤──► [ SINGLE User Object | uuid = same ]
user4 ─┤
user5 ─┤
user6 ─┘
```
Output

All lines print same UUID

Example:

- a8f1-xyz-123 
- a8f1-xyz-123
- a8f1-xyz-123 
- a8f1-xyz-123
- a8f1-xyz-123 
- a8f1-xyz-123

### 4. Problem in Your Version ⚠️ (Thread Safety)

Your singleton is NOT thread-safe.

If two threads run this at same time:
```bash
if(instance == null)
```
[
They might both create object → ❌ 2 instances (break singleton)

### 5. Thread-Safe Version (Best Practice)
   Option 1 — Synchronized
```bash
public static synchronized User getInstance(){
    if(instance==null){
    instance = new User(UUID.randomUUID().toString());
   }
   return instance;
}
```

]()
✔ Safe
❌ Slower (lock every call)

Option 2 — Lazy + Double Check (Best)
public static User getInstance(){
if(instance==null){
synchronized (User.class){
if(instance==null){
instance = new User(UUID.randomUUID().toString());
}
}
}
return instance;
}


✔ Thread safe
✔ Fast
✔ Real-world usage

6. Eager Singleton (Another Style)

Object created immediately when class loads:

private static final User instance = new User(UUID.randomUUID().toString());

public static User getInstance(){
return instance;
}


✔ Thread safe
✔ Simple
❌ Object created even if never used

### 7. When to Use Singleton?

Use when:`

Only one object must exist

Shared global resource

Avoid duplicate object creation

Example:`
```bash
Logger.getInstance().log("Hello");
Database.getInstance().connect();
```


### 8. Small Test (Check Same Object)

Add this:
````bash
System.out.println(user1 == user2); // true
````


`true → same object`
`false → different object`