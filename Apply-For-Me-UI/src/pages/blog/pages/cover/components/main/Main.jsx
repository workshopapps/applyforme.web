import "./Main.css";
import illustration3 from "../../../../assets/illustration3.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>How To Send Your Resume</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Olwaseun Bamidele</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration3} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
