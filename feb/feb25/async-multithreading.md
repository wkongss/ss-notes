### Async/Await

C# allows for a single thread to work on multiple jobs in parallel through the `Task` library.

First, create an `async` method by including the `async` keyword and making sure it returns a `Task<T>` object.

```C#
public async Task<bool> doTask()
{
    return true;
}
```

This task will now run in the background whenever the method is called, though the method call itself will return a task object.
To get the inner value, use the `await` keyword on the task to resolve to the return value. This will yield execution to other asynchronous values until the task at hand is complete:

```C#
Task<bool> myTask = doTask();

// Returns true
bool myResult = await myTask;
// Does not execute until myTask is resolved
Console.WriteLine("Task complete!");
```

Generally, define all your tasks first and then `await` when you need the result of the task for subsequent operations.
You can use static `Task` methods to help with this control flow:
 - `Task.WhenAll(taskList)` will return a task that resolves only when all tasks resolve.
 - `Task.WhenAny(taskList)` will return a task that resolves when any of the tasks resolve.

### Multithreading

C# also has multithreading support via the `Thread` class.
Create a new Thread and pass in a function for it to run (can be a lambda function, class method, etc.)

To start the thread, use `thread.Start()`.
To wait for a thread to finish in the current thread, use `thread.Join()`.

```C#
Thread myThread = new Thread(() => {
    Console.WriteLine("Hello world from a thread!");
});

myThread.Start();
```

Multithreading can also be done via tasks with the `Task.run()` method.

#### Thread Safety

You can manage shared resources with a variety of methods including locks and semaphores.

To create a lock, instantiate an arbitrary object to serve as your lock with `new object()`.
Then, use the `lock` keyword on your object followed by the codeblock accessing the shared resource:

```C#
lock (obj)
{
    // Do work here!
}
```

If a thread tries to access a currently-locked object, it will be blocked until the lock is released
After the code block is finished executing, the lock is automatically released for the next thread.

You can have deadlocks for example:
```C#
// One thread
lock (obj1)
{
    lock (obj2)
    {

    }
}

// Another thread
lock(obj2)
{
    lock (obj1)
    {

    }
}
```

Here, neither thread can make progress nor do they release their own resources!
You can better synchronize your locks by using the `Monitor` static classes:

 - `Monitor.wait(obj)` will release the lock temporarily as the thread waits for constraints to continue execution
 - `Monitor.pulse(obj)` will notify waiting locks that conditions have changed and they should recheck if their requirements have been met

These are particularly useful in producer-consumer models where a producer will pulse for waiting consupers.