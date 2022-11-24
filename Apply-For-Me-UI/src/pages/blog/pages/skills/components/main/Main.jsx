import "./Main.css";
import illustration7 from "../../../../assets/illustration7.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>Hard Skills vs Soft Skills</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Okafor Henry</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration7} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
