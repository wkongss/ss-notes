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

- The spread operator allows you to spread an array out into comma separated values. Can be used for making a deep copy of an array or as input for a function:
```JS
const arr = [1, 2, 3, 4, 5];

myFunc(0, ...arr, 6);

const copy = [0, ...arr, 6];
```