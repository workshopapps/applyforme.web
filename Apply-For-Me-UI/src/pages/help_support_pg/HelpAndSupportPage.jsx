import React from 'react'
import { Route, Routes } from 'react-router'
import BlueButton from '../../components/buttons/blue_background/BlueButton'
import Card from '../../components/card/Card'
import Footer from '../../components/footer/Footer'
import Nav from '../../components/nav/Nav'
import HowAfmWorks from '../afmworks/HowAfmWorks'
import classes from './Help.module.css'
import { useNavigate } from 'react-router'

const HelpAndSupportPage = () => {
    const navigate = useNavigate();
  return (
    <>
        <Nav />
            <div className={classes.help_container}>
                <div className={classes.help_header__wrap}>
                    <h2 className={classes.help_header}>Hello, We are here to help</h2>
                    <h5 className={classes.help_subhead}>Welcome to our Help and Support Center</h5>
                </div>
                <div className={classes.card_wrap}>
                    <Card header="How afm works"
                            para=" ApplyForMe is a marketplace that connects 
                            job seekers with their dream jobs.
                            Here, job seekers like you sign up, letting professionals 
                            and registered applicants do the job searching/application.
                            And all you have to do is attend the interviews once your 
                            application is successful."
                            link="/howafmworks"
                    />
                    <Card header="Need help?"
                            para=" Send us your resume and let us recommend
                             a package that suits your needs.
                              Reach us to us @ applyforme@xxxxxxx.
                            "
                            link="/needHelp"
                    />
                    <Card header="Careers"
                            para=" Interested in working with us at ApplyForMe?
                             Click here to see current opening & stay up 
                             to date about jobs."
                            link="/howafmworks"
                    />
                    <Card header="Tips"
                            para=" Looking to onboard? 
                            Go to the signup page and fill your biodata
                             & CV let’s do the rest for you. 
                            Forgot your password? Go to the login page and 
                            click on the forgot password link.."
                            link="/howafmworks"
                    />
                    <Card header="Account and Security"
                            para=" Having issues with your account? 
                            You can learn make changes in your account settings, 
                            change your password and do lots more."
                            link="/howafmworks"
                    />
                    <Card header="Payment"
                            para=" Finding it difficult to pay for your subscription?
                             There are various payment methods we accept at ApplyForMe."
                            link="/howafmworks"
                    />
                </div>
                <div className={classes.contactus_wrap}>
                    <h4 className={classes.contactus_header} style={{marginTop:"0",marginBottom:"0"}}> 
                        Haven't found answer? We can help..
                    </h4>
                    <p className={classes.contactus_para}  style={{marginTop:"0",marginBottom:"0"}}>
                        Contact us and we'll get back to you as soon as possible.
                    </p>
                    <BlueButton width="150" text="Contact us" func={()=>navigate('/contact')}/>
                </div> 
            </div>
        <Footer /> 
        <Routes> 
        <Route path="/howafmworks" element={<HowAfmWorks />}/>
                
        </Routes>
    </>
  )
}

export default HelpAndSupportPage