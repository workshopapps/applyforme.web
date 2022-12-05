import { configureStore } from "@reduxjs/toolkit";
import UserSlice from "./slice/UserSlice";
import salarySlice from "./slice/salary-rangeSlice";
import RR_Admin_Slice, { Fetch_RR_Admin, getApplicants } from "./slice/RR_AdminSlice";

const store = configureStore({
    reducer: {
        user: UserSlice,
        salary: salarySlice.reducer,
        RRadmin: RR_Admin_Slice.reducer
    }
});

store.dispatch(Fetch_RR_Admin());
store.dispatch(getApplicants());
export default store;

