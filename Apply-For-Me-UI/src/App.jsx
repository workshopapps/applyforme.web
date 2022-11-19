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
import Layout from "./pages/dashboard_layout/Layout";
import AdminDashboard from "./pages/admin_dashboard/AdminDashboard";
import AdminProfile from "./pages/admin_profile/AdminProfile";
import Error from "./pages/error/Error";
import AdminApplication from "./pages/admin_application/AdminApplication";
import AdminUsers from "./pages/admin_users/AdminUsers";
import AdminHelp from "./pages/admin_help/AdminHelp";
import AdminMessage from "./pages/admin_messages/AdminMessage";
import BestQuestions from "./pages/blog/pages/bestquestions/BestQuestions";
import Skills from "./pages/blog/pages/skills/Skills";
import Cover from "./pages/blog/pages/cover/Cover";
import Work from "./pages/blog/pages/work/Work";
import Signs from "./pages/blog/pages/signs/Signs";
import Resume from "./pages/blog/pages/resume/Resume";
import Brand from "./pages/blog/pages/brand/Brand";
import Endorsment from "./pages/blog/pages/endorsement/Endorsement";

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
                <Route path="dashboard" element={<Layout />}>
                    <Route path="/dashboard/" element={<AdminDashboard />} />
                    <Route path="profile" element={<AdminProfile />} />
                    <Route path="application" element={<AdminApplication />} />
                    <Route path="users" element={<AdminUsers />} />
                    <Route path="messages" element={<AdminMessage />} />
                    <Route path="help" element={<AdminHelp />} />
                </Route>
                <Route path="*" element={<Error />} />
            </Routes>
        </>
    );
}

export default App;
