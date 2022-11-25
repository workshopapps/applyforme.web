import { configureStore } from "@reduxjs/toolkit";
import UserSlice from "./slice/UserSlice";
import  salary_Slice from './salary-rangeSlice'

const store = configureStore({
    reducer: {
        user: UserSlice,
        salary: salary_Slice.reducer,
    }
});

export default store;
