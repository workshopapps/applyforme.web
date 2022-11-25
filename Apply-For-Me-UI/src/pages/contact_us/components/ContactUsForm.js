import React from 'react';


const ContactUsForm = () => {

    const formSubmit = (e) =>{
        e.preventDefault();
        alert("submitted");
    }

  return (
    <div className="form-body">
        <form onSubmit={formSubmit}>

        


                <div className="form-first-line">
                    <div className="form-group first-line-1">
                        <label>First Name</label>
                        <input type="text" required></input>

                    </div>

                    <div className="form-group first-line-2">
                        <label>Last Name</label>
                        <input type="text" required></input>

                    </div>
                </div>

                <div className="form-second-line">
                    <div className='form-group'>
                        <label>Email</label>
                        <input type="email" required></input>
                    </div>

                </div>

                <div className="form-third-line">
                    <div className="form-group">
                        <label>Phone Number</label>
                        <input type="text" required></input>
                    </div>
                </div>

                <div className="form-fourth-line">
                    <div className="form-group">
                        <label>Message</label>
                        <div className="textarea">
                           <textarea required></textarea>
                        </div>
                       

                    </div>

                </div>

                <div className="form-fifth-line">
                    <div className="radio-group">
                        <input type="radio" required></input>
                        <label className="privacy"> I have read the afm privacy</label>
                    </div>
                </div>

                <button>Send Message</button>

        </form>
      
    </div>
  );
}

export default ContactUsForm;

