## The Document Object Model

The DOM is a tree loaded in memory that represents the webpage structure from an HTML document. In Javascript, this is accessed via the `document` global object.

### Querying Elements

From there, we can access elements within the document as an [HTMLElement](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement) in Javascript by querying the DOM in a number of ways:
 - `document.getElementById(id)` - given a string `id`, returns either the `HTMLElement` object if found or `null`.
 - `document.querySelector(selector)` - give a CSS selector `selector` as a string, returns the first `HTMLElement` object found or `null` if no matches were found.

Generally, `getElementById` is faster if you know the id of what you're looking for, though querySelector is much more versatile.

Aggregate selectors return an [HTMLCollection](https://developer.mozilla.org/en-US/docs/Web/API/HTMLCollection) of HTML elements and include:
 - `document.getElementsByClassName, document.getElementsByName, document.getElementsByTagName` for querying based on a specific attribute

 - `document.querySelectorAll` for selecting all matches of a CSS selector.

### Creating Elements

You can create a new element by calling
```JS
const element = document.createElement(tag)
```

 - The tag is a string value of what type of element you're trying to create. For example, to create an anchor element, pass in `a` as the tag.

 You can then set the properties of this element by setting the properties such as `href` like you would with normal JS objects. Alternatively, use the `setAttribute` method:

```JS
element["href"] = "https://google.com";
// or
element.href = "https://bing.com";
// or
element.setAttribute("href", "https://duckduckgo.com");
```

To change the text or HTML within the element, modify the `innerText` or the `innerHTML` properties of the element respectively:

```JS
element.innerText = "link to google";
element.innerHTML = "<p>link to bing</p>":
```

### Adding Elements

To add the element to the current DOM, select the parent of the element, once again with one of your DOM querying functions.

Then, append the element to its parent using the `addChild(element)` function:

```JS
const parent = document.querySelector(".parent");
parent.addChild(element);
```

### Forms and UI

A lot of the time, we'll want to manipulate portions of the application where the user is able interact with. For forms in particular, we can listen to the `submit` or set the form's `onsubmit` function.
 - Within the callback function, you can create a new `FormData()` object to make it easier to extract data from your form. It will create a new object where the keys will be the `name` attribute of every input element and the values will be the data.

Here, we may perform a quick client-side form validation (note that this should also be reflected on the server side) and provide feedback if the contents are invalid.

We may then send the information to our server's API endpoint to be processed and persisted.

To prevent redirection, set the property of `action` to `#`. To prevent refreshing, call `event.preventDefault()` in the `submit((event) => {...})` callback.
 - If you're doing this, you may need to manually reset the form with `element.reset()`

Hide forms by setting `display` to `none`.