import React from 'react'
import { useNavigate } from 'react-router-dom'
import BlueButton from '../buttons/blue_background/BlueButton'
import classes from './Helpful.module.css'
const Helpful_contact = () => {
  const navigate = useNavigate();
  return (
    <>
        <div className={classes.wrapper}>
            <h5 className={classes.helpful_header}>
                Was this helpful? 
            </h5>
            <p className={classes.helpful_para} onClick={()=>navigate('/contact')}>
                Contact us and we will get back to you soon as possble.
            </p>
            <BlueButton width="150" text="Contact us"  func ={()=>navigate('/contact')}/>
        </div>
    </>
  )
}

export default Helpful_contact