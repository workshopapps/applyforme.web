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
import UserDashboardLayout from "./pages/user_dashboard/UserDashboardLayout";
import DashboardNothing from "./pages/dashboard_noting/DashboardNothing";
import BestQuestions from "./pages/blog/pages/bestquestions/BestQuestions";
import Skills from "./pages/blog/pages/skills/Skills";
import Cover from "./pages/blog/pages/cover/Cover";
import Work from "./pages/blog/pages/work/Work";
import Signs from "./pages/blog/pages/signs/Signs";
import Resume from "./pages/blog/pages/resume/Resume";
import Brand from "./pages/blog/pages/brand/Brand";
import Endorsment from "./pages/blog/pages/endorsement/Endorsement";
import Welcome2 from "./pages/authentication-pages/Welcome2";
import Registration from "./pages/authentication-pages/Registration";
import Welcome1 from "./pages/authentication-pages/Welcome1";
import Verification from "./pages/authentication-pages/Verification";
import Password from "./pages/authentication-pages/Password";
import NewPass from "./pages/authentication-pages/NewPass";
import Button from "./pages/authentication-pages/components/Elements/Button";

function App() {
    return (
        <>
            <Routes>
                <Route exact path="/b" element={<LandingPage />} />
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
                <Route exact path="blog/cover" element={<Cover />} />
                <Route exact path="blog/resume" element={<Resume />} />
                <Route exact path="blog/brand" element={<Brand />} />
                <Route exact path="blog/endorsment" element={<Endorsment />} />
                <Route path="dashboard" element={<UserDashboardLayout />}>
                    <Route path="/dashboard/" element={<DashboardNothing />} />
                </Route>

                <Route exact path='/' element={<Welcome1/>}/>
                <Route exact path='/reg' element={<Registration/>}/>
                <Route exact path='/wel2' element={<Welcome2/>}/>
                <Route exact path='/pass' element={<Password/>}/>
                <Route exact path='/veri' element={<Verification/>}/>     
                <Route exact path='/nwpass' element={<NewPass/>}/> 
                <Route exact path='/nwpass' element={<Button/>}/>   

                <Route path="/b" element={<Error />} />
            </Routes>
        </>
    );
}

export default App;
