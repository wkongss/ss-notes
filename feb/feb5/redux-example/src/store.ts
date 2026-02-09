import { configureStore } from "@reduxjs/toolkit";
import counterSlice from "./slices/counterSlice.ts";

const store = configureStore({
    reducer: counterSlice.reducer
});

export default store;
export type AppStore = typeof store;
export type RootState = ReturnType<AppStore["getState"]>