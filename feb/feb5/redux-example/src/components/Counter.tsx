import { useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import type { RootState } from "../store.ts";
import { increment, set } from "../slices/counterSlice.ts";

export default function Counter() {
    const { value } = useSelector((store: RootState) => store);

    const dispatch = useDispatch();
    const inputRef = useRef<HTMLInputElement>(null);

    return (
        <>
            <h1>Count: {value}</h1>
            <button onClick={() => {dispatch(increment())}} >+</button>

            <input type="number" ref={inputRef} />
            <button onClick={() => dispatch(set(Number(inputRef.current?.value)))} >set</button>
        </>
    );
}