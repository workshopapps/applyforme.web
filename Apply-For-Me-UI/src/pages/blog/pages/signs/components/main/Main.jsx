import "./Main.css";
import illustration2 from "../../../../assets/illustration2.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>5 Signs an Interview Went Well</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Rukevwe Erakpotobor</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration2} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
