import React from 'react'
import Footer from '../../components/footer/Footer'
import Helpful_contact from '../../components/helpful/Helpful_contact'
import Nav from '../../components/nav/Nav'
import classes from '../../pages/afmworks/Afmworks.module.css'
const HowAfmWorks = () => {
  return (
    <>
    <Nav />
        
        <main className={classes.main_container}>
          <h1 className={classes.main_header}>
            How afm works ?
          </h1>
          <div className={classes.main_para_wrap}>

            <p className={classes.main_para_one}>
            ApplyForMe is a job application startup aimed at helping the busy and overwhelmed job seekers easily apply for jobs without 
            any hassle and with ease. 
            </p>
            <p className={classes.main_para_two}>

                First, you need an account where all your information is contained. So, create an account.<br/>
                From the User menu, proceed to your Profile.<br/>
                Fill out the forms on all sections; personal data, Professional information and experience, Educational information.<br/>
                Provide information on your dream job; Employment type, role type, Salary range, Job location and upload your resume.<br/>
                ApplyForMe uses these information to select suiting jobs and apply on your behalf. You get notified on all successful applications.<br/>


            </p>
            
          </div>
          <Helpful_contact />
        </main>

        
    <Footer />
    </>
  )
}

export default HowAfmWorks