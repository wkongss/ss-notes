## Redux

Redux and its associated React Redux and Redux Toolkit are libraries that help manage complex state within frontend applications.
It introduces an opinionated (of those who had to deal with the mess before us) on how to best manage state via the provider model.

To start, install the libraries via the node package manager:

```bash
npm i @reduxjs/toolkit react-redux
```

### Slices

Slices are the equivalent of `useReducer` within redux and help automatically manage state within our application.

To use slices, import the `createSlice` function from react redux. Then, pass in an object with three properties:

1. `name` - a name to give to the slice.
2. `intialState` - the starting value of the state.
3.  `reducers` - an object containing all of the reducer functions associated with the state.

Similar to `useReducer`, the functions passed into `reducers` take in one to two parameters: an `oldState` and an `action` object which contains an `action` and `payload`.

Unlike `useReducer`, however, to update the state within a reducer function, you mutate the state directly (such as using `++` to increment):

```TS
import { createSlice } from "@reduxjs/toolkit";

const counterSlice: Slice<initialStateT, reducersT> = createSlice({
    name: "counter",
    initialState: { value: 0 },
    reducers: {
        increment: (state) => {
            state.value++;
        },

        set: (state, action: { payload: number }) => {
            state.value = action.payload;
        }
    }
});
```

Afterwards, export the slice and its reducers like so:

```TS
export default counterSlice;

export const { increment, set } = counterSlice.actions;
```

### Stores

To actually use the reducer, we create a Store, that creates dispatches for us. To do so, we use `configureStore` in another file:

```TS
// in store.ts
import { configureStore } from "@reduxjs/toolkit";
import counterSlice from "./slices/counterSlice.ts";

const store = configureStore({
    reducer: counterSlice.reducer
});
```

We can then export our store to other parts:
```TS
export default store;
export type AppStore = typeof store;
export type RootState = ReturnType<AppStore["getState"]>
```

To use our store, we have to pass it within our VirtualDOM tree via the `Provider` element. We can simply wrap our App within it like so:

```TSX
// main.tsx
import { Provider } from "react-redux";
import store from "./store.ts";

return (
    <Provider store={store}>
        <App />
    </Provider>
);
```

To access the state from our store within one of our components, we use the `useSelector` hook. This takes in a single parameter: a function that takes in a store and outputs the state from the store to select.

Then, to call dispatches, import the reducers from the actions of the slice in conjunction with the `useDispatch` hook to get a dispatch function to pass your reducers into.

#### Using Stored State in Components

```TSX
// /components/Counter.tsx
import { useSelector, useDispatch } from "react-redux";
import type { RootState } from "../store.ts";
import { increment, set } from "../slices/counterSlice.ts";

export default function Counter() {
    const { value } = useSelector((store: RootState) => store.counter);

    const dispatch = useDispatch();

    return (
        <>
            <h1>Count: {value}</h1>
            <button onClick={() => {dispatch(increment())}} >+</button>

            <input type="number" ref={inputRef} />
            <button onClick={() => dispatch(set(Number(inputRef.current?.value)))} >set</button>
        </>
    );
}
```

Note that store is global across all of your components, so if one component modifies the state, it will also be reflected in other components.