import { useState, useEffect } from "react";


export default function Counter() {
    const [count, setCount] = useState(0);
    useEffect(() => {
        console.log(`Use effect ran with count ${count}`);

        return () => {
            console.log("Unmount");
        }
    }, [count]);

    return (
        <>
            <p>
                Count: {count}
            </p>
            <button onClick={() => setCount((old) => old + 1)}>
                Add 1
            </button>
        </>
    )
}