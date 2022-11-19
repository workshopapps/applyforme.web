import "./Main.css";
import illustration6 from "../../../../assets/illustration6.png";

const Main = () => {
	return (
		<section className='endorsment-main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>How To Get Endorsements on LinkedIn</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Okafor Henry</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration6} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
