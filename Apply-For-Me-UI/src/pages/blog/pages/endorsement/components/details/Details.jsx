import React from "react";
import "./Details.css";
import facebook from "../../../../assets/facebook-2.png";
import twitter from "../../../../assets/twitter-2.png";
import instagram from "../../../../assets/instagram-2.png";

import like from "../../../../assets/like.png";
import dislike from "../../../../assets/dislike.png";
import { Link } from "react-router-dom";

const Details = () => {
	return (
		<div className='details'>
			<div className='content'>
				<div>
					LinkedIn endorsements can be a huge help when it comes to the job search;
					here's how to get more.
					<br />
					<br />
					<p className='bold'>What are LinkedIn endorsements?</p>
					<br />
					LinkedIn endorsements are a simple way for your colleagues and connections
					to recognize your expertise in a specific field with just one click. These
					seemingly simple endorsements can elevate you and your profile above the
					other thousands of people on LinkedIn vying for the same career path as you
					<br />
					<br />
					<p className='bold'>
						What is the difference between LinkedIn endorsements and recommendations?
					</p>
					<br />
					With LinkedIn endorsements, your connections can endorse the skills that
					you included in your profile with just one click. Meanwhile, a LinkedIn
					recommendation is a written testimonial that is added to your profile by a
					connection who took the time to write out why you are a professional worth
					working with.
					<br />
					<br />
					Recommendations add more value to your profile than the one-click
					endorsements — but both are still necessary for a successful profile. Since
					LinkedIn's collaborative features were released, several million people
					received endorsements from colleagues they never thought to ask. Here are a
					few steps to optimize your endorsements and return the love.
					<br />
					<br />
					<p className='bold'>How to get endorsements on LinkedIn</p>
				</div>
				<br />
				<p className='bold'>List your relevant skills</p>
				<br />
				Think like a salesperson. Determine which of your technical skills and core
				competencies are most important to your industry and relevant to your
				current job goals. List these skills first, from most important to least
				important. This is a road map for people to endorse the correct talents.{" "}
				<br />
				<br />
				<p className='bold'>Endorse fellow professionals</p>
				<br />
				Start with your closest colleagues, since these are the people who you know
				the best and are most likely to return the favor. For these colleagues,
				endorse the skills you've seen them demonstrate in the workplace and they
				will be sure to reciprocate. After endorsing your closest colleagues,
				endorse the skills of those you met at important functions or during your
				time spent at work, such as clients, vendors, or freelancers. <br />
				<br />
				<p className='bold'>Ask for endorsements on LinkedIn</p> <br />
				This is the trickiest of all techniques: how to ask for endorsements on your
				LinkedIn profile. You want people to acknowledge your skills and strengths,
				but you don't want to come off as begging for disingenuous endorsements.
				<br />
				Instead of sending tons of generic “please endorse me” messages, personalize
				your requests by making note of a specific project you worked on with each
				person you ask. Gently remind them of your contributions, and ask them to
				offer comments on the project in the form of skill endorsements.
				<br />
				<br />
				<p className='bold'>Make updates and link to your social media profiles</p>
				<br />
				Do you have a blog? This is a great way to display your skills and earn
				endorsements for connections you don't know that well. Share your latest
				blog posts, make changes to your profile often, and engage other users who
				connect with you. In other words, don't become the LinkedIn equivalent of a
				wallflower. If you're sharing insightful quotes and quality content related
				to the LinkedIn skills you have listed, you'll also give them a reason to
				endorse you for those skills.
				<br />
				<br />
				<p className='bold'>Finally, Remember your manners</p>
				<br />
				Don't forget to say thank you after you've received an endorsement. So many
				LinkedIn users take the endorsements their friends and colleagues post for
				granted and never take the time to say thanks. This is not only rude, but it
				also can hurt your relationship with the person. A quick, but kind, thank
				you for a LinkedIn endorsement goes a long way.
				<div className='review-container'>
					<div className='first'>
						Did you enjoy this post?
						<div>
							<img src={like} alt='like' />
							Yes
						</div>
						<div>
							<img src={dislike} alt='dislike' />
							No
						</div>
					</div>

					<div className='second'>
						Share this article on:
						<div>
							<Link to='/'>
								<img src={facebook} alt='facebook' />
							</Link>
							<Link to='/'>
								<img src={twitter} alt='twitter' />
							</Link>
							<Link to='/'>
								<img src={instagram} alt='instagram' />
							</Link>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default Details;
