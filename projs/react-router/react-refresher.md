### React

 - React is a front-end framework developed and maintained by Facebook/Meta and more recently, the React foundation.
 - It is a JS/TS first framework that focuses on declarative programming using the JSX/TSX syntax, which is a mix of HTML and JS/TS.

It is able to provide stateful elements that render and react to events such as user input by manipulating a virtual DOM and pushing updates to the page DOM.

#### JSX/TSX

JSX/TSX are extensions of JavaScript and TypeScript respectively that allow both raw JS/TS and the embedding of HTML and React elements within them.

#### Components

 - Define components by defining a function that returns a single JSX element. Afterwards, you're able to import that component via and use it within your JSX code with `<Element />`.

 - Pass in properties into the element via `props`. Within the element function, it should accept a props object that can be destructured within the element's function definition.

```JSX
<Element
    prop1={value1}
    prop2={value2}
/>

// in /components/Element.jsx
export default Element({ prop1, prop2 }) {
    ...
}
```

Within JSX, React supports the embedding of raw JS by escaping with braces:
```JSX
<main>
    <Element />
    {condition && <ConditionalElement />}
</main>

```

 - Arrays of elements are spread and rendered in order.
 - If embedded JS resolves to an element, it is rendered; otherwise, the value is ignored. This is called conditional rendering.

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
 - `initialState` - the default value of our state. Note that if you are using a reference variable, use a generator function that creates a new one to avoid static references: `() => { reference }`.

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
 - `dependencies` is a list of stateful variables that your effect depends on. For example, if your effect performs an API call, one dependency may be a value specifying the query.

Reference: https://react.dev/reference/react/useEffect