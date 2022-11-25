import { configureStore } from "@reduxjs/toolkit";
import UserSlice from "./slice/UserSlice";

const store = configureStore({
    reducer: {
        user: UserSlice
    }
});

export default store;
