import React from 'react'
import BlueBorderButton from '../../components/buttons/blue_border_button/BlueBorderButton'
import Footer from '../../components/footer/Footer'
import HelpfulContact from '../../components/helpful/Helpful_contact'
import Nav from '../../components/nav/Nav'
import classes from '../../pages/afmworks/Afmworks.module.css'

const NeedHelp = () => {
  return (
    <>
                <Nav/>
                <main className={classes.main_container}>
                    <h1 className={classes.main_header}>
                        Need help ?
                    </h1> 
                    <div className={classes.need_help_wrap}>
                        <ul className={classes.need_help_lists}>
                            <li className={classes.need_help_list}>Finding Jobs which perfectly suit your skillset?
                                <p className={classes.need_help_para}>Finding Jobs which perfectly suit your skillset?
                                    AFM algorithm matches available jobs to your skill specification.
                                    </p>
                            </li>
                            <li className={classes.need_help_list}>
                                Adding bespoke job specifications not on our platform?
                                <p className={classes.need_help_para}>
                                    Contact our support to help you get sorted out
                                </p>
                            </li>
                            <li className={classes.need_help_list}>
                                Adding bespoke job specifications not on our platform?
                                <p className={classes.need_help_para}>
                                    Create an account on AFM, let's fix up with amazing jobs, rich work culture and awesome compensation plans
                                </p>
                                <div className={classes.help_btn_position}>
                                <BlueBorderButton width="100" text="More" />    
                                </div>
                                
                            </li>
                        </ul>
                    </div>
                    <HelpfulContact/>
                </main>

                <Footer />
    </>
  )
}

export default NeedHelp