import style from "./contactmodal.module.css";

const ContactModal = ({ setSubmitBtn }) => {
    return (
        <div>
            <div
                className={style.overlay}
                onClick={() => setSubmitBtn(false)}
            ></div>
            <div className={style.container}>
                <p className={style.text}>Message sent successfully!</p>
                <button
                    type="button"
                    className={style.button}
                    onClick={() => setSubmitBtn(false)}
                >
                    Ok
                </button>
            </div>
        </div>
    );
};

export default ContactModal;
