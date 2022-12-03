import React from 'react';
import avatar from "./img/avatar.png";
import notification from "./img/notification.png";
import "./DashboardNothing.css";






const NewUserDashboard = () => {
  return (
    <div className='dashboardnothing'>


         {/* this is the top stripe */}

         <section className="top-dashboard-stripe">
                  <div className="top-dashboard-left">
                     <h2>
                        Welcome, Bukola

                     </h2>
                     <p>
                       Here's an overview
                     </p>

                  </div>


                  <div className="top-dashboard-right">
                    <div className="dashboard-img-wrapper">
                       <img src={notification} alt="icon"></img>
                    </div>

                    <div className="dashboard-img-wrapper">
                          <img src={avatar} alt="notification"></img>
                    </div>
                   
                    

                  </div>
             </section>

             <hr></hr>



             {/* section for overview */}


             <section className="dashboard-overview">
                <h5>overview</h5>

                <div className="overview-cards-wrapper">
                    <div className="overview-card-wrapper">


                      <div className="overview-card">

                            <h3>0</h3>
                            <p>Total Application</p>

                        </div>



                    </div>

                    <div className="overview-card-wrapper">
                            

                               <div className="overview-card">
                                    <h3>0</h3>
                                    <p>Completed Interview</p>
                                </div>



                    </div>

                    <div className="overview-card-wrapper">
                            
                            <div className="overview-card">
                                 <h3>0</h3>
                                 <p>Active Applications</p>
                             </div>

                   </div>

                   
                    <div className='mobile-create'>
                            <span> Welcome, you have no job profile yet Tap  </span>
                         <span>   <button> + </button> </span>  
                            <span>to create a new job profile</span> 
                    </div>

                  
                </div>

             </section>


             {/* section for nothing to see here */}

             <section className='nothing-to-see-here'>
                <div className='normal-create'>
                    Nothing to see here <button>Create a Job Profile +</button> to get started
                </div>

               

             </section>


      
    </div>
  );
}

export default NewUserDashboard;
