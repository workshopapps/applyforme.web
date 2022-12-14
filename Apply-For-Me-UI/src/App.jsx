/* eslint-disable react/jsx-pascal-case */
/* eslint-disable no-unused-vars */
import * as Sentry from "@sentry/react";
import { Routes, Route, useLocation } from "react-router-dom";
import LandingPage from "./pages/landing_page/LandingPage";
import AboutUs from "./pages/about_us/AboutUs";
import FAQs from "./pages/faqs/FAQs";
import FaqsPage from "./pages/faqs/FaqsPage";
import ContactUs from "./pages/contact_us/ContactUs";
import TermsAndCondition from "./pages/terms_condition/TermsAndCondition";
import Privacy from "./pages/privacy/Privacy";
import Cookies from "./pages/cookies/Cookies";
import Career from "./pages/career/Career";
import Blog from "./pages/blog/Blog";
import Onboarding from "pages/tryout_form/components/Onboarding";
import Error from "./pages/dashboard_profile/Success/error/Error";
import Dashboard from "./pages/dashboard/Dashboard";
import AccountSettings from "./pages/account_settings/AccountSettings";
import UserDashboardLayout from "./pages/user_dashboard/UserDashboardLayout";
import DashboardNothing from "./pages/dashboard_noting/DashboardNothing";
import Applications from "./pages/applications/Applications";
import RRApplications from "./pages/applications/rr_all_applications";
import BestQuestions from "./pages/blog/pages/bestquestions/BestQuestions";
import Skills from "./pages/blog/pages/skills/Skills";
import Cover from "./pages/blog/pages/cover/Cover";
import Work from "./pages/blog/pages/work/Work";
import Signs from "./pages/blog/pages/signs/Signs";
import Resume from "./pages/blog/pages/resume/Resume";
import Brand from "./pages/blog/pages/brand/Brand";
import Endorsment from "./pages/blog/pages/endorsement/Endorsement";
import JobDescription from "./pages/job_decription/JobDescription";
import HelpAndSupportPage from "./pages/help_support_pg/HelpAndSupportPage";
import HowAfmWorks from "./pages/afmworks/HowAfmWorks";
import NeedHelp from "./pages/need_help/NeedHelp";

// import AdminDashboard from "./pages/admin_dashboard/AdminDashboard";
import ApplicantDetails from "./pages/admin_dashboard/components/applicant_details/ApplicantDetails";
import ApplicationForm from "./pages/admin_dashboard/components/application_form/ApplicationForm";
import DashboardHome from "./pages/admin_dashboard/components/dashboard_home/DashboardHome";
import { pricingPage } from "pages/pricing_plan/pricingData";
// import { formData } from "pages/checkout/checkoutData";
import Pricing from "./pages/pricing_plan/Pricing";
// import Checkout from "pages/checkout/Checkout";
import ProtectedRoute from "ProtectedRoute";
//UserDashboard
import NoProfile from "./pages/dashboard_profile/NoProfile/NoProfile";
import Success from "./pages/dashboard_profile/Success/Success";
import CreateProfile from "./pages/dashboard_profile/CreateProfile/CreateProfile";
import ProfileDescription from "pages/dashboard_profile/Profile/ProfileDescription";
import EditProfile from "./pages/dashboard_profile/EditProfile/EditProfile";
import { ProfileScreen } from "components/superAdmmin_profile/superAdmin_profileScreen";
import RRProfile from "pages/reverse_recruiter_profile/rrp";

// Auth Logic
import jwt_decode from "jwt-decode";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";

//Authentication
import Welcome1 from "pages/authentication-pages/Welcome1";
import Welcome2 from "pages/authentication-pages/Welcome2";
import Verification from "pages/authentication-pages/Verification";
import Password from "pages/authentication-pages/Password";
import NewPass from "pages/authentication-pages/NewPass";
import Registration from "pages/authentication-pages/Registration";
import { RRAdminProfilePage } from "pages/RR_admin_profile/RR_admin_profile";
import { useEffect } from "react";

import SignIn from "pages/RR_recuiters_page/Sign_In";
import SignUp from "pages/RR_recuiters_page/Sign_Up";
import { SuperDashBoard } from "pages/super_admin_dashboard/dashboardview";

import TryoutForm from "pages/tryout_form/TryoutForm";
import TrySuccess from "pages/tryout_form/Success";

import * as atatus from "atatus-spa";
import ReactGA from "react-ga4";
import { CreateRecruiter } from "pages/createRecruiter/create_view";
import { SuperApplicantsPage } from "pages/users_page/user_page_applicants";
import { PaystackPage } from "pages/paystack/paystack";

import PaymentVerification from "pages/paystack/verification/Verification";

atatus.config("c626faaef503411ea6216d7b6112de1c").install();

const MEASUREMENT_ID = "G-RV4WJK9T7P";
ReactGA.initialize(MEASUREMENT_ID);

function App() {
    const dispatch = useDispatch();

    useEffect(() => {
        if (localStorage?.getItem("tokenHngKey")) {
            let decoded = jwt_decode(localStorage?.getItem("tokenHngKey"));
            dispatch(userInfo(decoded));
        }
    }, [dispatch]);

    return (
        <>
            <Routes>
                <Route exact path="/super_page" element={<SuperDashBoard />} />
                <Route exact path="/" element={<LandingPage />} />
                <Route exact path="/about" element={<AboutUs />} />
                <Route exact path="/faqs" element={<FAQs />} />
                <Route exact path="/faqs/faqspage" element={<FaqsPage />} />
                <Route exact path="/contact" element={<ContactUs />} />
                <Route exact path="/t&c" element={<TermsAndCondition />} />
                <Route exact path="/privacy" element={<Privacy />} />
                <Route exact path="/cookies" element={<Cookies />} />
                <Route exact path="/career" element={<Career />} />
                <Route exact path="/help" element={<HelpAndSupportPage />} />
                <Route exact path="/howafmworks" element={<HowAfmWorks />} />
                <Route exact path="/needHelp" element={<NeedHelp />} />
                <Route exact path="/tryout-form" element={<TryoutForm />} />
                <Route exact path="/reverse/profile" element={<RRProfile />} />
                <Route exact path="/registration" element={<Registration />} />
                <Route
                    exact
                    path="/checkout/verify-payment"
                    element={<PaymentVerification />}
                />
                <Route
                    exact
                    path="/tryout-form/success"
                    element={<TrySuccess />}
                />
                <Route
                    exact
                    path="/pricing"
                    element={<Pricing {...pricingPage} />}
                />
                <Route
                    exact
                    path="/checkout/:planName/:paymentInterval/:price"
                    // element={<Checkout {...formData} />}
                    element={<PaystackPage />}
                />

                <Route exact path="blog" element={<Blog />} />
                <Route
                    exact
                    path="/blog/questions"
                    element={<BestQuestions />}
                />
                {/* BLOG ROUTE */}
                <Route exact path="/blog/skills" element={<Skills />} />
                <Route exact path="blog/cover" element={<Cover />} />
                <Route exact path="blog/work" element={<Work />} />
                <Route exact path="blog/signs" element={<Signs />} />
                <Route exact path="blog/cover" element={<Cover />} />
                <Route exact path="blog/resume" element={<Resume />} />
                <Route exact path="blog/brand" element={<Brand />} />
                <Route exact path="blog/endorsement" element={<Endorsment />} />
                {/* <Route path="/dashboard/" element={<DashboardNothing />} /> */}

                {/*AUTH ROUTE */}
                <Route exact path="/wel1" element={<Welcome1 />} />
                <Route exact path="/wel2" element={<Welcome2 />} />
                <Route exact path="/reg" element={<Registration />} />
                <Route exact path="/pass" element={<Password />} />
                <Route exact path="/reset-password" element={<NewPass />} />
                <Route exact path="/veri" element={<Verification />} />

                {/* onboarding */}

                <Route
                    path="/onboarding/:token/complete"
                    element={<Onboarding />}
                />

                {/* RECRUITER ROUTE */}

                <Route exact path="/rr_sign_in" element={<SignIn />} />
                <Route exact path="/rr_sign_up" element={<SignUp />} />

                {/*  PROTECTED ROUTE*/}

                {/*  SuperAdmin */}
                <Route
                    element={
                        <ProtectedRoute allowedRoles={["SuperAdministrator"]} />
                    }
                >
                    {/* SUPER ADMIN ROUTE*/}

                    <Route exact path="/user-page" element={<Dashboard />} />
                    <Route
                        path="/user-page/profile"
                        element={<ProfileScreen />}
                    ></Route>
                    <Route
                        exact
                        path="/user-page/reverseRecruiterAdmin/:id"
                        element={<RRAdminProfilePage />}
                    />
                    <Route
                        exact
                        path="/superAdmin/applicants/profiles/details/:id"
                        element={<SuperApplicantsPage />}
                    />
                    <Route
                        exact
                        path="/create/recruiter/page"
                        element={<CreateRecruiter />}
                    />
                </Route>

                {/* Reverve Recruiter/Recruiter - Route (Recruiter) */}
                <Route
                    element={<ProtectedRoute allowedRoles={["Recruiter"]} />}
                >
                    {/*Reverse Recruiter Dashboard */}
                    <Route path="/rr_admin" element={<DashboardHome />} />
                    <Route
                        path="/rr_admin/form/:id"
                        element={<ApplicationForm />}
                    />
                    <Route
                        path="/professional-profile/user/details/:id"
                        element={<ApplicantDetails />}
                    />
                    <Route
                        path="/rr_admin/all_applications"
                        element={<RRApplications />}
                    />
                </Route>

                {/* User  Route (Professional)  */}
                <Route
                    element={<ProtectedRoute allowedRoles={["Professional"]} />}
                >
                    {/* USER DASHBAORD */}
                    <Route path="/dashboard" element={<UserDashboardLayout />}>
                        {/* User Dashboard Profile */}

                        <Route
                            path="/dashboard"
                            element={<DashboardNothing />}
                        />
                        <Route
                            exact
                            path="/dashboard/settings"
                            element={<AccountSettings />}
                        />
                        <Route path="user/" element={<NoProfile />} />
                        <Route
                            path="user/create-profile"
                            element={<CreateProfile />}
                        />
                        <Route path="user/success" element={<Success />} />
                        <Route
                            path="/dashboard/user/:id"
                            element={<ProfileDescription />}
                        />
                        <Route
                            path="/dashboard/user/:id/edit"
                            element={<EditProfile />}
                        />

                        {/* User Dashboard Applications */}
                        <Route path="applications" element={<Applications />} />
                        {/* <Route index element={<Applications />} /> */}
                        <Route
                            path="applications/:jobId"
                            element={<JobDescription />}
                        />
                    </Route>
                </Route>
                <Route path="*" element={<Error />} />
            </Routes>
        </>
    );
}

export default Sentry.withProfiler(App);
