import check from "./success_mark.png";
import styles from "./Success.module.css";
import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";

function Success() {
    return (
        <div>
            <Nav />
            <div className={styles.success_box}>
                <img src={check} alt="check" />
                <h4>Congratulations !!!</h4>
                <p>
                    Your job profile was created successfully. A link has been
                    sent to your mail. Use that link to continue.
                </p>
            </div>
            <Footer />
        </div>
    );
}

export default Success;
