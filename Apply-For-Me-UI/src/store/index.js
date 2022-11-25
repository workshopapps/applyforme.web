import { configureStore } from "@reduxjs/toolkit";
import UserSlice from "./slice/UserSlice";
import salarySlice from "./slice/salary-rangeSlice";

const store = configureStore({
    reducer: {
        user: UserSlice,
        salary: salarySlice.reducer,
    }
});

export default store;
