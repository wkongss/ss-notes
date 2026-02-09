import { createSlice } from "@reduxjs/toolkit";

const counterSlice = createSlice({
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

export default counterSlice

export const { increment, set } = counterSlice.actions;