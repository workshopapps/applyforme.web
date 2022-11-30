import React from 'react';
import { useState } from "react";
import axios from 'axios';


const ContactUsForm = () => {

    const initialValues = { first_name: "", last_name: "",  phone_number: "", 'message': "" , privacy_policy: "true" };
    const [formValues, setFormValues] = useState(initialValues);

    
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('https://official-volunux.uc.r.appspot.com/api/v1/contact-us', formValues )
    
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })

        alert('Your message has been sent sent. Thank You!')

      };


  return (
    <div className="form-body">
        <form onSubmit={handleSubmit}>

                <div className="form-first-line">
                    <div className="form-group first-line-1">
                        <label>First Name</label>
                        <input type="text" name='first_name' required value={formValues.first_name} onChange={handleChange}/>
                       
                    </div>

                    <div className="form-group first-line-2">
                        <label>Last Name</label>
                        <input type="text" name='last_name' required value={formValues.last_name} onChange={handleChange}></input>
                      
                    </div>
                </div>

                <div className="form-second-line">
                    <div className='form-group'>
                        <label>Email</label>
                        <input type="email" name='email_address' required value={formValues.email_address} onChange={handleChange}></input>
                       
                    </div>

                </div>

                <div className="form-third-line">
                    <div className="form-group">
                        <label>Phone Number</label>
                        <input type="text" name='phone_number' required value={formValues.phone_number} onChange={handleChange}></input>
                    </div>
                </div>

                <div className="form-fourth-line">
                    <div className="form-group">
                        <label>Message</label>
                        <div className="textarea">
                           <textarea  name='message' required value={formValues.message} onChange={handleChange}></textarea>
                          
                        </div>
                       

                    </div>

                </div>

                <div className="form-fifth-line">
                    <div className="radio-group">
                        <input type="radio" value={formValues.privacy_policy} onChange={handleChange}></input>
                        <label className="privacy"> I have read the afm privacy</label>
                    </div>
                </div>

                <button value='submit' >Send Message</button>

        </form>
      
    </div>
  );
}

export default ContactUsForm;

