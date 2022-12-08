import check from "./success_mark.png";
import styles from "./Success.module.css";
import BlueButton from "components/buttons/blue_background/BlueButton";
import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import { useNavigate } from "react-router-dom";

function Success() {
    const navigate = useNavigate();

    return (
        <div>
            <Nav />
            <div className={styles.success_box}>
                <img src={check} alt="check" />
                <h4>Congratulations !!!</h4>
                <p>
                    Your job profile was created successfully. Upload your CV,
                    cover letter and view your upcoming interviews when you sign
                    up.
                </p>
                <BlueButton
                    text="Sign up"
                    width={274}
                    func={() => {
                        navigate("/wel1");
                    }}
                />
            </div>
            <Footer />
        </div>
    );
}

export default Success;
