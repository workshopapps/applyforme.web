import { Routes, Route } from "react-router-dom";
import LandingPage from "./pages/landing_page/LandingPage";
import AboutUs from "./pages/about_us/AboutUs";
import FAQs from "./pages/faqs/FAQs";
import ContactUs from "./pages/contact_us/ContactUs";
import TermsAndCondition from "./pages/terms_condition/TermsAndCondition";
import Privacy from "./pages/privacy/Privacy";
import Cookies from "./pages/cookies/Cookies";
import Career from "./pages/career/Career";
import Blog from "./pages/blog/Blog";
import PricingPlan from "./pages/pricing_plan/PricingPlan";
import Error from "./pages/error/Error";
import Dashboard from "./pages/dashboard/Dashboard";
import AccountSettings from "./pages/account_settings/AccountSettings";
import UserDashboardLayout from "./pages/user_dashboard/UserDashboardLayout";
import DashboardNothing from "./pages/dashboard_noting/DashboardNothing";
import ApplicationsDashboardLayout from "./pages/applications/layouts/ApplicationsDashboardLayout";
import Applications from "./pages/applications/Applications";
import BestQuestions from "./pages/blog/pages/bestquestions/BestQuestions";
import Skills from "./pages/blog/pages/skills/Skills";
import Cover from "./pages/blog/pages/cover/Cover";
import Work from "./pages/blog/pages/work/Work";
import Signs from "./pages/blog/pages/signs/Signs";
import Resume from "./pages/blog/pages/resume/Resume";
import Brand from "./pages/blog/pages/brand/Brand";
import Endorsment from "./pages/blog/pages/endorsement/Endorsement";

import AdminProfile from "./pages/admin_profile/AdminProfile";


import Welcome2 from "./pages/authentication-pages/Welcome2";
import Registration from "./pages/authentication-pages/Registration";
import Welcome1 from "./pages/authentication-pages/Welcome1";
import Verification from "./pages/authentication-pages/Verification";
import Password from "./pages/authentication-pages/Password";
import NewPass from "./pages/authentication-pages/NewPass";
import Button from "./pages/authentication-pages/components/Elements/Button";


import JobDescription from "./pages/job_decription/JobDescription";
// import AdminDashboard from "./pages/admin_dashboard/AdminDashboard";
import ApplicantDetails from "./pages/admin_dashboard/components/applicant_details/ApplicantDetails";
import ApplicationForm from "./pages/admin_dashboard/components/application_form/ApplicationForm";
import DashboardHome from "./pages/admin_dashboard/components/dashboard_home/DashboardHome";

import NoProfile from "./pages/dashboard_profile/NoProfile/NoProfile";
import Success from "./pages/dashboard_profile/Success/Success";
import Profile from "./pages/dashboard_profile/Profile/Profile";
import CreateProfile from "./pages/dashboard_profile/CreateProfile/CreateProfile";

import ReverseApp from './pages/App_s/Appss'


function App() {
    return (
        <>
            <Routes>
                <Route exact path="/" element={<LandingPage />} />
                <Route exact path="/about" element={<AboutUs />} />
                <Route exact path="/faqs" element={<FAQs />} />
                <Route exact path="/contact" element={<ContactUs />} />
                <Route exact path="/t&c" element={<TermsAndCondition />} />
                <Route exact path="/privacy" element={<Privacy />} />
                <Route exact path="/cookies" element={<Cookies />} />
                <Route exact path="/career" element={<Career />} />
                <Route exact path="/pricing" element={<PricingPlan />} />
                <Route exact path="/user-page" element={<Dashboard />} />
                <Route exact path="blog" element={<Blog />} />
                <Route
                    exact
                    path="/blog/questions"
                    element={<BestQuestions />}
                />
                <Route exact path="/blog/skills" element={<Skills />} />
                <Route exact path="blog/cover" element={<Cover />} />
                <Route exact path="blog/work" element={<Work />} />
                <Route exact path="blog/signs" element={<Signs />} />
                <Route exact path="/reverse-app" element={<ReverseApp />} />
                <Route exact path="blog/cover" element={<Cover />} />
                <Route exact path="blog/resume" element={<Resume />} />
                <Route exact path="blog/brand" element={<Brand />} />
                <Route exact path="blog/endorsement" element={<Endorsment />} />
                <Route exact path="/settings" element={<AccountSettings />} />
                <Route path="dashboard" element={<UserDashboardLayout />}>
                    <Route path="profile" element={<AdminProfile />} />
                    <Route path="/dashboard/" element={<DashboardNothing />} />

                    <Route path="admin" element={<DashboardHome />} />
                    <Route path="admin/form" element={<ApplicationForm />} />
                    <Route
                        path="admin/details"
                        element={<ApplicantDetails />}
                    />
                    <Route path="user/" element={<NoProfile />} />
                    <Route
                        path="user/create-profile"
                        element={<CreateProfile />}
                    />
                    <Route path="user/success" element={<Success />} />
                    <Route path="user/profile-list" element={<Profile />} />

                </Route>


                <Route exact path='/wel1' element={<Welcome1/>}/>
                <Route exact path='/reg' element={<Registration/>}/>
                <Route exact path='/wel2' element={<Welcome2/>}/>
                <Route exact path='/pass' element={<Password/>}/>
                <Route exact path='/veri' element={<Verification/>}/>     
                <Route exact path='/nwpass' element={<NewPass/>}/> 
                <Route exact path='/nwpass' element={<Button/>}/>   

                <Route
                    path="/dashboard/applications"
                    element={<ApplicationsDashboardLayout />}
                >
                    <Route index element={<Applications />} />
                    <Route path=":jobId" element={<JobDescription />} />

                </Route>
                <Route path="*" element={<Error />} />
            </Routes>
        </>
    );
}

export default App;
