import "../styles/HeroSection.css";
import heroImage from "../../../assets/images/hero-image.svg";

const HeroSection = () => {
    return (
        <section>
            <div className="hero-section-wrapper">
                <div className="hero-column hero-column-one">
                    <h1>An experience like no other!</h1>
                    <p>Get in sync. Build the future!</p>
                    <button>See Open Positions</button>
                </div>
                <div className="hero-column hero-column-two">
                    <div className="hero-image">
                        <img src={heroImage} alt="" />
                    </div>
                </div>
            </div>
        </section>
    );
};

export default HeroSection;
