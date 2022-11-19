import "./Main.css";
import illustration4 from "../../../../assets/illustration4.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>The Do’s and Don'ts of Resume Writing</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Okafor Henry</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration4} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
