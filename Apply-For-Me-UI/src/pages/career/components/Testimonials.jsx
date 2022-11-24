import "../styles/Testimonials.css";
import testimonialsPic from "../../../assets/images/testimonial-pic.png";

const Testimonials = () => {
    return (
        <section>
            <div className="testimonials-wrapper">
                <div className="testimonials-image-card">
                    <img src={testimonialsPic} alt="" />
                </div>

                <div className="testimonials-text">
                    <p>
                        Working as a communications relation expert at
                        Applyforme for the past decade has been a very rewarding
                        experience for me and has helped me appreciate the
                        importance of a conducive and enabling environment for
                        work. AFM is truly a worldclass company.
                    </p>
                    <p>
                        <span className="bold">Sandra Akoi</span>,
                        Communications relation expert
                    </p>
                </div>
            </div>
        </section>
    );
};

export default Testimonials;
