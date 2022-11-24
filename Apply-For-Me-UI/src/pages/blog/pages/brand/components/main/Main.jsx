import "./Main.css";
import illustration5 from "../../../../assets/illustration5.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>How to Manage Your Online Brand</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Soji Ayoade</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration5} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
