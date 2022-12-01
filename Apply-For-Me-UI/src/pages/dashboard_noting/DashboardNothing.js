import React from "react";
import avatar from "./img/avatar.png";
import notification from "./img/notification.png";
import "./DashboardNothing.css";



const DashboardNothing = () => {
    return(

        <div className="dashboardnothing">

             {/* this is the top stripe */}

             <section className="top-dashboard-stripe">
                  <div className="top-dashboard-left">
                     <h2>
                        Good Evening Bukola

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



             {/* overview cards */}


             <section className="dashboard-overview">
                <h5>overview</h5>

                <div className="overview-cards-wrapper">
                    <div className="overview-card-wrapper">


                      <div className="overview-card">

                            <h3>72</h3>
                            <p>Total Appliaction</p>

                        </div>



                    </div>

                    <div className="overview-card-wrapper">
                            

                               <div className="overview-card">
                                    <h3>72</h3>
                                    <p>Total Appliaction</p>
                                </div>



                    </div>

                    <div className="overview-card-wrapper">
                            
                            <div className="overview-card">
                                 <h3>72</h3>
                                 <p>Total Appliaction</p>
                             </div>

                   </div>

                  
                </div>

             </section>


             {/* section for my application */}

             
             <section className="dashboard-myapplication">


             </section>
        </div>


    )
};

export default DashboardNothing;
