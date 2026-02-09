### Props Drilling

Within React, the first-class way of sharing state between components is via passing them through props.

However, if we have distant children that require a shared state, doing so via properties often leads to bloated code as you end up with intermediate children who don't use the props but are required to transfer them to their children who do.

While this is somewhat manageable for small projects, the **props drilling** can make larger projects a lot more disorganized and difficult to read/reason.

## Context

**Context** is a system that allows parents to pass data to all of its subchildren that require it, skipping the parent-child of props.

To start, use the `createContext` function from React to define a context. It takes in the default value and can then be exported to the parent component to provide context:

```TSX
import { createContext } from "react";

const MyContext = createContext(false);

export default MyContext
```

Then, within your parent component, wrap it as a component and pass in the `value` prop as the data you want to share between components.

```TSX
import { useState } from "react";
import MyContext from "./context/MyContext";

export default function Component() {
    const [value, setValue] = useState(false);

    return (
        <MyContext value={value}>
            <IntermediateComponent>
                <ChildComponent />
            </IntermediateComponent>
        </MyContext>
    );
}
```

To access the context within your children, simply call the `useContext` hook and pass in the specific context to access:

```TSX
import { useContext } from "react";
import MyContext from "./context/MyContext";

export default function ChildComponent() {
    const contextValue = useContext(MyContext);

    return (
        <h1>{contextValue}</h1>
    );
}
```

### Use Cases

Context is *not* a replacement for props. In fact, any simpler relationship is better off implemented via props. 

You should realistically only use context when you need 
 - a global shared state, either between deeply-nested children with intermediate non-shared children OR
 - for more global configurations such as theming or session management. 