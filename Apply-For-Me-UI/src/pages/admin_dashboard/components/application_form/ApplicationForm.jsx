import style from "./ApplicationForm.module.css";

const ApplicationForm = () => {
    return (
        <form className={style.form}>
            <p>Please, fill this form for every application submitted</p>
            <label htmlFor="name">
                <span>Applicant's Name</span>
                <br />
                <input id="name" type="text" placeholder="John Doe" />
            </label>

            <label htmlFor="role">
                <span>Job Role</span>
                <br />
                <input id="role" type="text" placeholder="Product Design" />
            </label>
            <label htmlFor="plan">
                <span>Membership Plan</span>
                <br />
                <input id="plan" type="text" placeholder="Premium" />
            </label>
            <label htmlFor="company">
                <span>Company's Name</span>
                <br />
                <input id="company" type="text" placeholder="Rapid River" />
            </label>
            <label htmlFor="reverse-recruiter">
                <span>Reverse Recruiter's Name</span>
                <br />
                <input id="reverse-recruiter" type="text" placeholder="Ora Smith" />
            </label>
            <input id="submit" type="submit" value="Submit" />
        </form>
    );
};

export default ApplicationForm;
