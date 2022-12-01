import React from "react";
import avatar from "./img/avatar.png";
import notification from "./img/notification.png";
import figma from "./img/figma.png";
import pinterest from  "./img/pinterest.png";
import google from "./img/google.png";
import instagram from "./img/instagram.png"
import "./DashboardNothing.css";



const DashboardNothing = () => {

  const applicationArray = [
    {
        id:1,
        img:figma,
        role:"Frontend Dev",
        time:"10hrs ago",
        type:"full-time",
        platform:"figma"

    },
    {
        id:2,
        img:instagram,
        role:"UI/UX design",
        time:"10hrs ago",
        type:"full-time",
        platform:"instagram"

    },
    {
        id:3,
        img:figma,
        role:"Web Design",
        time:"2 days ago",
        type:"Remote",
        platform:"Globex Corporation"

    },
    {
        id:4,
        img:pinterest,
        role:"Visual design",
        time:"7 days ago",
        type:"full-time",
        platform:"pinterest"

    },
    {
        id:5,
        img:google,
        role:"Product Design",
        time:"2 weeks ago",
        type:"part-time",
        platform:"Google"

    },

  ]

  const arrayRender = applicationArray.map(item=>(
    <div key={item.id} className="application-array-card">

        <div className="cardleftarray">
            <img src={item.img} alt={item.platform}></img>
            <div className="card-details">
                <h4>{item.role}</h4>
                <p>{item.platform}</p>
            </div>
        </div>

        <div className="card-job-type">{item.type}</div>

        <div className="card-job-type">{item.time}</div>

    </div>
  ));










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
                            <p>Total Application</p>

                        </div>



                    </div>

                    <div className="overview-card-wrapper">
                            

                               <div className="overview-card">
                                    <h3>11</h3>
                                    <p>Complete Interview</p>
                                </div>



                    </div>

                    <div className="overview-card-wrapper">
                            
                            <div className="overview-card">
                                 <h3>4</h3>
                                 <p>Active Applications</p>
                             </div>

                   </div>

                  
                </div>

             </section>


             {/* section for my application */}


             <section className="dashboard-myapplication">


                <h5>My Application</h5>

             <div>
                {arrayRender}
             </div>
             </section>
        </div>


    )
};

export default DashboardNothing;
