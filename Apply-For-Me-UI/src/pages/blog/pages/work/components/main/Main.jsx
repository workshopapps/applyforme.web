import "./Main.css";
import illustration8 from "../../../../assets/illustration8.png";

const Main = () => {
	return (
		<section className='work-main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>How To Work Smarter And Get Shit Done</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Oluwaseun Bamidele</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration8} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
