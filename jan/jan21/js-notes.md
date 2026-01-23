### JavaScript

 - No relation to Java - just similar names!
 - Dynamically, loosely typed and inferred variable typing.
    - The same variable can change types over its lifetime! Can be avoided using TS or a static type checker.
 - Follows the ECMAScript (currently ES6) standard.
 - Stresses event-oriented programming and first-class functions. Contains OOP syntax via a prototype model, but not as stressed.

 - Print stuff with `console.log();`
 - Semicolons are automatically-inserted at the end of every statement/expression, so they're optional - just keep your styling consistent!

 - Declare variables with one of three keywords:
    - `var` - global or function scoped, type 2 hoisted to the the top of the scope (only declaration, not the value). Generally avoid if possible since block scoped variables are much easier to reason with.
    - `let` - block scoped variable, no hoisting.
    - `const` - block scope variable, must be initialized on declaration and cannot be reassigned afterwards. Note that for reference types, it only means the reference itself does not change. You can still, for instance, mutate elements of the array.

 - Primitive types include: `number, string, boolean, undefined, null, BigInt Symbol`.
 - Reference types include: `Object, Array, Map, Set, Function, Error, Date, RegExp`. Note that all primitives have their respective object wrapper (i.e. `number` -> `Number`).
    - Yes, functions are objects! They can be passed into other functions, returned by functions, and even assigned to variables just like everything else!

 - Use the `typeof` to find the type of a value.
 - Perform casts by using the wrapper constructor and passing in the value you wish to cast.

 - Variables may be automatically cast via **Type Coercion**. For example, adding a string "10" with 5 will result in a string of "105". The `5` is automatically cast to a string and concatenated.

 - ES6 also supports template literals, defined with the grave sign: \`. These allow for string interpolation using the `${}` syntax in between. Note that new lines within the literal are considered as actual new lines within the string.
 
 Example:

 ```JS
 const v = 10 + 5;
 console.log(`The value of v is: ${v}`);
 ```

 would print:
 ```
 > The value of v is: 15
 ```

 ### Array Functions

Higher-order functions are functions that either take in a function or return a function (or both!).
A good example of these are arrays. Note that JS arrays are more like Python lists or Java ArrayLists in that they don't have a fixed size and are instead dynamic.

 - `arr.forEach()` takes a function with values `(element, index, arrRef) => { ... }` and loops through every element once (if the array is modified, it only loops through the original array). Note that JS also does have classical for and for each (for ... of) loops, but this is the preferred method of processing arrays.
    - If you don't need index or arrRef, they may be omitted.
 - `arr.map()` takes in a function with values `(element, index, arrRef) => { ... }` loops through the array and returns a new element where the element at index `i` is the the output of the function passed in applied to `arr[i]`.
 - `arr.filter()` takes in a function with values `(element, index, arrRef) => { ... }` and returns a new array with only elements from `arr` that return a truthy value when passed into the function.
 - `arr.reduce()` takes in a function with values `(accumulator, element) => { ... }` and returns the accumulator after looping through the array. The accumulator is set to the return value of the function after each element is processed.
    - There is also `reduceRight` if you wish to reduce from right to left.
    - You may also pass in an initial value for the accumulator as a second argument for the `reduce function`

- `arr.some()` and `arr.every()` take in a function with values `element, index, arrRef => { ... }` and returns a boolean value. `some` returns `true` iff at least one element returns a truthy value; `every` returns `true` iff all elements return a truthy value.
- Add elements with `push` and remove the last element with `pop`.
- Create a deep copy with spread operator: `let newArr = [...arr];`

- Sort the array with `arr.sort()` to sort in place. To get a reference to a new sorted array, use `arr.toSorted()`.

Reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

### `setTimeout` and `setInterval`

 - The `setTimeout(callback, wait)` function will invoke the callback function after ~`wait` number of ms have elapsed (this is not an exact measure due to process handling and so forth).
 - The `setInterval(callback, wait)` function will continue to invoke the callback function every ~`wait` number of ms until a `clearInterval(interval)` is called on the object. For this reason, it's important to assign the call to a variable:

```JS
let counter = 0;
const myInterval = setInterval(() => {
   console.log(`${++counter} seconds have passed!`);
   if (counter >= 10) {
       clearInterval(myInterval);
       return;
   }
}, 1_000);
```

### Truthiness

In JS, certain types are automatically converted to booleans during type coercion.

The following are considered "Falsy":
 - `0`, `-0`, and `0n`
 - `false`
 - `""`
 - `null`
 - `undefined`
 - `NaN` and `Number.NaN`
 - `document.all`

Everything else is considered "Truthy". This can make a difference in control flow, for instance:

```JS
const f = 0;
const t = 1;

if (f) {
    console.log("f is True");
}

if (t) {
    console.log("t is True");
}
```

### ES6 Features

The ECMAScript 2015 standard brought a ton of useful features into Javascript including:

#### Arrow functions
Shorthand for creating functions with syntax similar to lambda functions in other languages: `(params) => { code block }`.
 - If the code block is a single line, the braces can be omitted. There is also an implicit return in these cases.

#### JS Object Literals 
These are key-value pairs of a `{ name: value, name: value }`. Name should be a string, value can be a primitive type, array, or other object. 
- You can access and modify these properties with dot notation or indexing notation:

```JS
const obj = {
    a: "b",
    c: ["d", "e"]
}

obj.c.push("f");
console.log(obj["c"]);
```

 - To make your object immutable, use the `Object.freeze(obj)`. To prevent extensions, use `Object.seal(obj)`.
    - Note that this doesn't throw a runtime exception - just that any attempted modifications will not mutate the object.

- To loop through the properties of an object, use a `for .. in` loop as objects are enumerable, not iterable.         

#### Destructuring
This allows you to assign values from complex objects (Objects and Arrays).
- Destructure objects using braces: 
```JS
const obj = {
    a: 1,
    b: 2,
    c: 3
};

// a = 1, c = 3
const { a, c } = obj;
```
You can also nest destructuring like so:
```JS
const obj = {
    a: {
        b: 1,
        c: 2
    },
    d: 3
}
// b = 1, c = 2, d = 3
const { a: { b, c }, d } = obj;
```

Arrays are destructured in a similar fashion, but you also have access to

#### Nullish Coalescing Operator and Short Circuiting

 The Nullish Coalescing operator is used for default values in case a value is `null` or `undefined`: 
 ```JS
 const a = value ?? default
 ```
 If `value` is `null` or `undefined`, `default` will be assigned to `a`; otherwise, `value`.

 Similarly, the `&&` operator can be chained to find the first falsy value or the last truthy value.

 The `||` operator is used to find the first truthy value or the last falsy value:

```JS
// 0
const a = 1 && 0 && 3;

// 3
const b = 1 && 2 && 3;

// 0
const c = null || 0 || 0;

// 3
const d = 3 || 2 || 0;
```
These are extremely useful for things such as conditional rendering when we get into React.

#### Optional Chaining

Lets you dodge Null Pointer Exceptions by terminating accessing a property if the parent is null:
```JS
const a = { 
    b: { c: 3 } 
};

// Valid! val = 3
let val = a.b.c;

// Valid! Returns undefined!
val = a?.d;

// Inalid! Null pointer!
val = a.d;
```

#### Spread and Rest

- The rest operator allows further iterable destructuring by returning the remaining portion of the array as a subarray. This can also be used to take an arbitrary number of elements as a parameter for functions.

To use it, define a variable with prefix `...` as the last element of an array destructure.

```JS
const arr = [1, 2, 3, 4, 5];
const [first, second, ...rest] = arr;

// first = 1, second = 2, rest = [3, 4, 5]

function sum (a, b, ...rest) {
    let ans = 0;
    ans += a + b;

    rest.forEach((e) => { ans += e });
    return ans;
}
```

- The spread operator allows you to spread an array or object out into comma separated values. Can be used for making a deep copy of an array or as input for a function:
```JS
const arr = [1, 2, 3, 4, 5];

myFunc(0, ...arr, 6);

const copy = [0, ...arr, 6];
```

### The Event Loop

JavaScript, unlike languages like Java, has little support for multithreading. In other words, tasks need to be scheduled in order to achieve asynchronous-like function (though since it's single-threaded, it isn't true concurrency).

Think of this as a brain quickly swapping between multiple tasks instead of processing them in parallel.

Within JS, there's an **event loop** which acts as a queue for which tasks are ran. Tasks are categorized into two types:

 1. Microtasks are asynchronous tasks given high priority. The most notable of these are **Promises**.
 2. Macrotasks are asynchronous tasks given low priority. These include FileIO, `setTimeout` and `setInterval`. This is why you can't rely on them for accurate time keeping.

The event loop, then, determines the order in which these asynchronous tasks are run. In general, it looks like this:

1. All synchronous call stack operations are performed.
2. Every microtask from the microtask queue is run. Note that these may generate more microtasks to be put in the microtask queue for the next cycle.
3. One macrotask from the macrotask queue is run.
4. Repeat steps 2-3 until program terminates.

### Promises

Promises are JS' way of handling asynchronous calls. They are sort of an asynchronous contract to perform a task that will perform a callback once fulfilled.

Promises are returned by functions declared with the `async` keyword:

```JS
// Asynchronous function f returns a Promise { boolean }
async function f() {
    return true;
}
```

Promises go through a lifecycle of of:
1. Pending - still waiting on the result.
2. Fulfilled/Rejected - finished. If fulfilled, contains a result. If rejected, then errored.

To wrangle with the lifecycle, you can use callbacks `then`, `catch`, and `finally`.

```JS
async function f() => {
    return true;
};

const myPromise = f();

myPromise
    .then((res) => {
        // callback with a thennable result as the parameter

        doStuff(res);
    })
    .catch((err) => {
        // callback with the error as a parameter

        doStuff(err);
    })
    .finally(() => {
        // callback that executes after either then or catch
    });

// You can also explicitly define a promise:

function g() {
    // The constructor takes in a function with two parameters.
    // res is a function to be called with the thennable output if the function is resolved.
    // rej is a function to be called with the error if the function is rejected.
    return new Promise((res, rej) => {
        if (today === "Monday") {
            rej("I hate Mondays");
            return;
        }

        res("It's not Monday!");
    })
}

```

Prior to promises, you had issues with extremely nested callbacks where you would want to schedule more tasks after a certain task completed. This made code extremely difficult to reason with - "callback hell, pyramid of doom".

This can now be done with promise chaining due to callbacks also returning promises!

```JS
myPromise
    .then((res1) => { ... })
    .then((res2) => { ... })
    .then((res3) => { ... });
```

Instead of chaining, you may also opt for the `async` and `await` structure. Within an `async` block, you can block code execution until a promise is resolved/rejected by using the `await` keyword:

```JS
async function f() {
    const res = await fetch("https://google.com");
    console.log("Fetch completed!");

    const data = await res.json();
    console.log("Json completed!");
    // If any exceptions occur, the promise is rejected

    // Otherwise, returns the result as a promise (can be void, so Promise<void>)
    // Wraps data in a promise: Promise<DataType>
    return data;
}
```



Reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise