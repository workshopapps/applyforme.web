import { useEffect, useState } from "react";
import styles from "../CreateProfile.module.css";
import classes from "./CoverLetter.module.css";
import Dropdown from "../../components/Dropdown/Dropdown";
import Input from "../../components/InputField/InputField";
const CoverLetter = ({ formData, setFormData }) => {
    const [clTemplates, setClTemplates] = useState();
    const [templateFocus, setTemplateFocus] = useState(false);
    const [promptColor, setPromptColor] = useState("#2e3192");

    useEffect(() => {
        fetch(
            "https://api.applyforme.hng.tech/api/v1/cover-letter-template/entries/all"
        )
            .then(response => response.json())
            .then(data => setClTemplates(data));
    }, []);

    const clNames = clTemplates?.map(onetemp => ({
        label: onetemp.title,
        value: onetemp.title,
        id: onetemp.id,
        content: onetemp.content
    }));

    function populateInputs(e) {
        const abc = clNames?.find(
            item => item.value === e.target.value
        )?.content;
        setFormData({
            ...formData,
            coverletter_subject: e.target.value,
            coverletter_template: e.target.value,
            coverletter_body: abc
        });
    }
    return (
        <form className={styles.form_body}>
            <h3>Create a cover letter template for this profile</h3>
            <div className={styles.dropdownbox}>
                <p className={classes.cl_text}>Template name</p>
                <Dropdown
                    options={clNames}
                    width={90}
                    placeholderText="Browse Templates"
                    onChange={e => {
                        populateInputs(e);
                    }}
                    onFocus={e => {
                        setTemplateFocus(true);
                    }}
                    value={formData.coverletter_template}
                />
            </div>
            {templateFocus && (
                <small style={{ color: `${promptColor}` }}>
                    If you have selected a template, update the details
                    appropriately
                </small>
            )}
            <div className={classes.cover_letter}>
                <label>
                    <p className={classes.cl_text}>Cover letter subject</p>
                </label>
                <Input
                    className={classes.clsubject_input}
                    type="text"
                    value={formData.coverletter_subject}
                    name="coverletter_subject"
                    width={90}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            coverletter_subject: e.target.value
                        });
                    }}
                />
            </div>
            <div>
                <label>
                    <p className={classes.cl_text}>Cover letter body</p>
                </label>
                <textarea
                    className={classes.cl_textarea}
                    placeholder="Hello,
I checked your website and social profiles recently and I came across your job posting regarding the opening at london.I am interested in applying my knowledge in a real project in Rapid river where I will learn a lot of things!I want to learn if you have opportunities related to my profile. I have attached my resume to let you learn more about me.
I would love to talk to you in more detail. Let me know your availability in the coming weeks.
Thanks,
Enwono Ikono"
                    value={formData.coverletter_body}
                    name="coverletter_body"
                    onChange={e => {
                        setFormData({
                            ...formData,
                            coverletter_body: e.target.value
                        });
                    }}
                    onFocus={e => {
                        setPromptColor("#6d6e71");
                    }}
                />
            </div>
        </form>
    );
};

export default CoverLetter;
