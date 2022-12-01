import React from "react";
import "./Home.css";
import subheader from "../../assets/subheader.svg";
import home1 from "../../assets/home1.png";
import home2 from "../../assets/home2.png";
import home3 from "../../assets/home3.png";
import home4 from "../../assets/home4.png";
import home5 from "../../assets/home5.png";
import home6 from "../../assets/home6.png";
import home7 from "../../assets/home7.png";
import home8 from "../../assets/home8.png";

import { Link } from "react-router-dom";

const Home = () => {
    return (
        <>
            <div className="home">
                <div className="subheader">
                    <img src={subheader} alt="evolve" />
                </div>
                <div className="content row ">
                    <div className="left col-md-8">
                        <div className="main">
                            <h1>JOB INTERVIEWS</h1>
                            <div className="items-container">
                                <div className="item">
                                    <img src={home1} alt="Question" />
                                    <p className="bold">
                                        5 Best Questions To Ask In An Interview
                                    </p>
                                    <p>
                                        So you think you've had a successful
                                        interview so far but just before you
                                        leave, the recruiter drops a
                                        bombshell...
                                    </p>
                                    <Link to="/blog/questions">
                                        <button>Read More</button>
                                    </Link>
                                </div>

                                <div className="item">
                                    <img src={home2} alt="Signs" />
                                    <p className="bold">
                                        5 Signs An Interview Went Well
                                    </p>
                                    <p>
                                        Getting an interview invite and
                                        attending the interview is a huge step
                                        to securing a job. However, the
                                        anticipation of the outcome...
                                    </p>
                                    <Link to="/blog/signs">
                                        <button>Read More</button>
                                    </Link>
                                </div>
                            </div>
                        </div>

                        <div className="main">
                            <h1>RESUMES AND COVER LETTERS</h1>
                            <div className="items-container">
                                <div className="item">
                                    <img src={home3} alt="Question" />
                                    <p className="bold">
                                        How To Write A Resume For An Internal
                                        Position
                                    </p>
                                    <p>
                                        You just found out that your company has
                                        opened up a position that you have been
                                        vying for for a while. How do you....
                                    </p>
                                    <Link to="/blog/resume">
                                        <button>Read More</button>
                                    </Link>
                                </div>

                                <div className="item">
                                    <img src={home4} alt="Signs" />
                                    <p className="bold">
                                        How To List Computer Skills On A Resume
                                    </p>
                                    <p>
                                        Everything you need to know about how to
                                        display computer skills on your resume
                                        (and beyond) to land a new job...
                                    </p>
                                    <Link to="/blog/skills">
                                        <button>Read More</button>
                                    </Link>
                                </div>
                            </div>
                        </div>
                        <div className="main">
                            <h1>WORKPLACE</h1>
                            <div className="items-container">
                                <div className="item">
                                    <img src={home5} alt="Question" />
                                    <p className="bold">
                                        5 Tips On How To Tell Your Boss You Want
                                        A Transfer
                                    </p>
                                    <p>
                                        When it comes to requesting an internal
                                        transfer, you really don’t want to start
                                        off on the wrong foot. If you have...
                                    </p>
                                    <Link to="/blog/work">
                                        <button>Read More</button>
                                    </Link>
                                </div>

                                <div className="item">
                                    <img src={home6} alt="Signs" />
                                    <p className="bold">
                                        How To Tell Your Boss You Have Too Much
                                        Work Without Complaining
                                    </p>
                                    <p>
                                        Your week, your month, your quarter is
                                        already jampacked with activities and
                                        deadline. Each time your manager
                                        approached your...
                                    </p>
                                    <Link to="/blog/cover">
                                        <button>Read More</button>
                                    </Link>
                                </div>
                            </div>
                        </div>

                        <div className="main">
                            <h1>PERSONAL BRANDING</h1>
                            <div className="items-container">
                                <div className="item">
                                    <img src={home7} alt="Question" />
                                    <p className="bold">
                                        How To Ask For And Get Endorsements On
                                        LinkedIn
                                    </p>
                                    <p>
                                        LinkedIn endorsements can be a huge help
                                        when it comes to your job search. Here’s
                                        how to get more...
                                    </p>
                                    <Link to="/blog/endorsement">
                                        <button>Read More</button>
                                    </Link>
                                </div>

                                <div className="item">
                                    <img src={home8} alt="Signs" />
                                    <p className="bold">
                                        How To Manage Your Online Brand
                                    </p>
                                    <p>
                                        Your online presence is very important
                                        to your physical brand. Nowadays, hiring
                                        personnel scour social media for
                                        profiles of...
                                    </p>
                                    <Link to="/blog/brand">
                                        <button>Read More</button>
                                    </Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="right col-md-4">
                        <div className="inner">
                            <p>
                                Get the latest career resource tips delivered to
                                your email!
                                <br /> Subscribe to our Newsletter below
                            </p>
                            <input type="text" placeholder="Email address" />
                            <button>Subscribe</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Home;
