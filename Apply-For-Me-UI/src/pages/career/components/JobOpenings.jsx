import "../styles/JobOpenings.css";

const JobOpenings = () => {
    return (
        <section>
            <div className="job-openings-wrapper">
                <h3>Explore available Job openings</h3>

                <div className="job-openings-mobile">
                    <div className="job-openings-container">
                        <div className="job-openings-column job-openings-column-heading">
                            <h4 className="job-openings-role-title">Role</h4>
                            <p className="job-openings-location">Location</p>
                            <p className="job-openings-description">
                                Description
                            </p>
                        </div>
                        <div className="job-openings-column job-openings-column-one">
                            <h4 className="job-openings-role">
                                Software Engineer
                            </h4>
                            <p className="job-openings-location">Remote</p>
                            <p className="job-openings-description">
                                Analyzing and modifying existing software as
                                well as maintaining current infrastructure for
                                end-user testing.
                            </p>
                        </div>
                        <div className="job-openings-column job-openings-column-two">
                            <h4 className="job-openings-role">
                                Senior Product Designer
                            </h4>
                            <p className="job-openings-location">Remote</p>
                            <p className="job-openings-description">
                                Responsible for coordinating with user research
                                experts for informed product decisions that are
                                scalable.
                            </p>
                        </div>
                        <div className="job-openings-column job-openings-column-three">
                            {" "}
                            <h4 className="job-openings-role">
                                Frontend Developer
                            </h4>
                            <p className="job-openings-location">Remote</p>
                            <p className="job-openings-description">
                                Developing new user facing features and
                                determining structure by optimizing page load
                                times for optimal performance.
                            </p>
                        </div>
                    </div>
                </div>

                <p className="last-line">That's all we have for now.</p>
            </div>
        </section>
    );
};

export default JobOpenings;
