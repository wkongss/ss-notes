import { useReducer } from "react";

export default function Counter() {
    const [state, dispatch] = useReducer((prev: any, action: any) => {
        switch (action.type) {
            case "INCREMENT":
                return { ...prev, count: prev.count + 1};
            case "DECREMENT":
                return { ...prev, count: prev.count - 1};
            case "SET":
                return { ...prev, count: action.payload };
        }
    } , { count: 0 });

    return(
    <>
        <button onClick={() => dispatch({ type: "INCREMENT" })}> + </button>
        <button onClick={() => dispatch({ type: "DECREMENT" })}> - </button>
        <button onClick={() => dispatch({ type: "SET", payload: 0 })}> Reset </button>

        <h1>Current Count: {state.count}</h1>
    </>
);
}