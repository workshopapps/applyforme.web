import Nav from "../../components/nav/Nav";
import style from "./error.module.css";
import { Link } from "react-router-dom";

const Error = () => {
    return (
        <>
            <Nav />
            <div className={style.container}>
                <h1 className={style.heading}>404</h1>
                <h3 className={style.heading3}>
                    Oops! Something went wrong with this page.
                </h3>

                <p className={style.text}>
                    The page you are looking for might have been removed, had
                    it's name changed, or is temporarily unavailable.
                </p>

                <Link to="/" className={style.link}>
                    Go back
                </Link>
            </div>
        </>
    );
};

export default Error;
