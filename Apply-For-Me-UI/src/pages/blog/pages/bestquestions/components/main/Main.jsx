import "./Main.css";
import illustration1 from "../../../../assets/illustration1.png";

const Main = () => {
	return (
		<section className='main'>
			<div className='item-wrapper'>
				<div className='content'>
					<div className='item'>
						<h1 className='bold'>5 Best Questions To Ask In An Interview</h1>
						<p className='date'>November 16, 2022</p>
						<p className='author'>By Rukevwe Erakpotobor</p>
					</div>
				</div>
			</div>

			<div className='image-container'>
				<img src={illustration1} alt='illustration' />
			</div>
		</section>
	);
};

export default Main;
