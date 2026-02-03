## React

React is an extremely popular frontend library developed by Meta (formerly Facebook) that allows for easier DOM manipulation and rerendering based on a copy of the DOM called a Virtual DOM (or react-dom).

Instead of rerendering the entirety of the DOM tree, the Virtual DOM will selectively re-render only the child.

React allows us to define state that changes our application is displayed. This may be some dynamic data, for example. The Virtual DOM will then rerender the View whenever this state changes.

We are also able to define custom reusable components that act as a blueprint for parts of our page (i.e. a component representing a YouTube video would contain a stateful thumbnail, title, and viewcount).

We can further extend this with client-side routing to create single page applications (no page refreshing - just rerendering of our original page).

### JSX/TSX

React allows us to write our markup directly within our JavaScript files in JSX. We can then return this markup as HTML-esque code to form components and export/import them across our application. This also allows us to embed JS into our markup for customizable rendering.

Under the hood, this uses either Babel or SWC to transpile  it into browser-compatable JavaScript code.

### Getting Started

Vite is a tool that allows for the development (via hot module reloading) and deployment (via building and minifying) of React applications.

Create a Vite application with
```bash
npm create vite@latest
```

Follow the instruction steps and then install the necessary dependencies.

Here, we find ourselves a React application with a short `index.html`, `index.css` file and our `main.jsx` file. Within our `html` file, we have a root element that will serve as the base of our Virtual DOM and where our application will be rendered.

We then select this root element and create a react-dom root with `createRoot` and then render our application from the root with `render` in our `main.jsx`.

### ESM Importing and Exporting

To export, we can either use a default export (once per file):

```JS
// myFunc.js
export default function myFunc() { ... }
```

Which is then imported like so:

```JS
// main.js
import myFunc from "./myFunc";
```

Or, we can use named exports (as many as we want per file):

```JS
// myNamedFunc.js
export function myNamedFunc() { ... }
```

and import using destructuring:

```JS
// main.js
import { myNamedFunc } from "./myNamedFunc";
```

We export components as functions that return a single JSX rooted element.

### React Components


 - Define components by defining a function that returns a single JSX element. Afterwards, you're able to import that component via and use it within your JSX code with `<Element />`.

 - Pass in properties into the element via `props`. Within the element function, it should accept a props object that can be destructured within the element's function definition.
    - Note that `props` reserves the `children` prop to automatically pass in any child elements the component may be defined with.

```JSX
// using in another jsx file
<Element
    prop1={value1}
    prop2={value2}
/>

// in /components/Element.jsx
export default Element({ prop1, prop2 }) {
    return (
        // Fragment return
        < >
            // child elements here
        < />
    )
}
```

The return value of the component should be a single JSX parent element (it doesn't allow for multiple elements). Oftentimes, this is wrapped in an empty **fragment**.

Within JSX, React supports the embedding of raw JS by escaping with braces:
```JSX
<main>
    <Element />
    {condition && <ConditionalElement />}
</main>

```

 - Arrays of elements are spread and rendered in order.
 - If embedded JS resolves to an element, it is rendered; otherwise, the value is ignored. This is called conditional rendering.

#### Component Lifecycle

The general lifecycle of a React component is as follows:

1. Mounted - The component is initialized and added to the screen view.
2. Updated - The component is updating based on changes in its stateful props or passed-in state.
3. Unmounted - The component is no longer visible to the screen view.

### Hooks

Hooks are what allow us to manage the state of our elements in an event-driven manner. The two most common of which are `useState` and `useEffect`.

Note that you can only call hooks at the top level of your component or your own custom hooks.

#### useState

This is a hook that allows us to define a variable that our elements will be able to react to changes.

The basic syntax is as follows:
```JSX
import { useState } from "react";

// destructured array
const [varName, setVarName] = useState(initialState);
```

Breaking this down:
 - `varName` is the variable that elements will react to.
 - `setVarName` is the setter function that changes the state and then notifies the elements that use the state. There are two uses of this: either input the next value or a single parameter function that takes `(oldState) => newState`.
 - `initialState` - the default value of our state. Note that if the initial state is an expensive calculation, use a generator function that creates a new one to avoid recalculating it upon rerenders: `() => { reference }`.

Note that calling setVarName doesn't actually change the value of the variable immediately - instead, it changes the next value that will be rendered.

Reference: https://react.dev/reference/react/useState

#### useEffect

A lot of times, we'll want to perform functions with side effects from external systems such as API requests. The way we handle this in React is with the `useEffect` hook with the following syntax:

```JSX
useEffect(setup() => { cleanUp() | void }, dependencies)
```

Again, breaking this down:
 - The `setup` is a function that contains logic for our side effects. This is usually run once before the page loads and then again every time one of our dependencies changes.
     - Additionally, you may opt to return a cleanup function which is run before each setup when a dependency changes.
     - More specifically, this callback function is called once on component mount, and every time a dependency changes. If a function is returned, that function is ran on unmount.
 - `dependencies` is a list of stateful variables that your effect depends on. For example, if your effect performs an API call, one dependency may be a value specifying the query.

Reference: https://react.dev/reference/react/useEffect

#### useRef

`ref` is similar to state; however, it doesn't rerender the component every time it is changed, but still persists across rerenders.

Define a `ref` using the `useRef` hook:

```JS
const myRef = useRef(default);
```

This returns a Javascript Object with one value: `ref.current` set to the default value.

This value is mutable, meaning you can change it with something like:

```JS
myRef.current = 10;
```

Again, this does not rerender the component. Additionally, do not access or mutate `ref.current` outside of hooks and callbacks as behavior is undefined when called during the rendering of a component.

When would you use this over state?
 - Mostly when you need a value that doesn't actually affect rendering. For example, you can save an interval from setInterval to a reference and have a button that starts/stops it.
 - Pass it to elements via the `ref` prop to have `ref.current` dynamically reference the element. You can then use it for non-rerendering DOM manipulation such as calling built-in element functions like `focus()`.

Reference: https://react.dev/reference/react/useRef

### Controlled Components

When taking in input from the user such as from a text field, it's a common pattern to have a single source of truth between the React Component and the raw DOM element. To achieve this, you can tie the value of the input to a React stateful variable:

```JS
const [text, setText] = useState("");

return (
    <input 
        value={text} 
        onChange={(e) => setText(e.target.value)}
    />
);
```

Now, the value of our text input depends on the `text` state, and nothing but the `text` state, forming a **controlled component**.

#### StrictMode

This immediately mounts and unmounts your components so it can be useful for spotting persistent components that may be causing memory leaks.

For this reason, it's generally used in development environments rather than production environments.