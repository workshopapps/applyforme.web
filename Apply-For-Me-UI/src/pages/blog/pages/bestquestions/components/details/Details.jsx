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
					So you think you've had a successful interview so far but just before you
					leave, the recruiter drops a bombshell and asks "do you have questions
					you'd like to ask us?" <br />
					<br />
					This point in the interview is crucial because it is an open floor to win
					your recruiter over and nail the job, hence you should never say NO. Many
					employers feel confident about candidates who ask thoughtful questions
					about the company and the position. You should take time before the
					interview to prepare several questions for your interviewer(s) that show
					you’ve researched the company and are well-versed about the position.
					<br />
					<br />
					<p>
						Here are some of the best questions you can ask your recruiter in an
						interview:
					</p>
					<br />
					<ul className='ml-4'>
						<li>
							Do you make provisions for on-the-job training for your employees?
						</li>
						<li>What are your expectations from me if you hire me for this role?</li>
						<li>How important is this role for the progress of this company?</li>
						<li>
							What are the primary challenges the company encounters and how can I
							contribute my quota in tackling them?
						</li>
						<li>
							What are the short and long-term goals of the company in terms of growth
							and development?
						</li>
					</ul>
					<p className='bold'>
						Why You Should Always Ask a Question During an Interview
					</p>
					<br />
					<p className='bold'>Shows You are Genuinely Interested in the Job</p>
					<br />
					<p>
						When you ask the right question, the hiring team gets the impression
						you're really interested in the job and would like to know more about the
						company. This includes their mission, values, and beliefs. For instance,
						you can ask them where they plan to see the company in the next 5 or 10
						years.
					</p>
					<br />
					<p className='bold'>Proof You've Been Paying Attention</p>
					<br /> Especially when you make references to sentences or lines used by
					one of the recruiters, asking questions during interviews is proof that you
					have been listening. It also shows that you have received whatever message
					they have passed across during the course of the interview. Be that as it
					may, do not ask questions that have already been addressed because it makes
					you appear like you haven't been paying attention. <br /> <br />
					<p className='bold'>
						An Opportunity to Understand who You'll be Working with Better
					</p>
					<br />
					Here, you're presented with the opportunity of asking deeper questions that
					probably have not been addressed on their website, their pages, or during
					the interview. Ask real life questions that actually interest you. These
					questions could be regarding the insurance policy, employee management, or
					even their risk mitigation measures. <br />
					<br />
					<p className='bold'> It Positions You as a Critical Thinker</p>
					<br />
					Unlike what many job seekers believe, an interview isn't always a
					question-and-answer session. Sometimes, you have to be expressive and ask
					crucial questions that prove you did not just rehearse everything you have
					said. It positions you to be a critical and smart thinker who is thirsty
					for learning. <br />
					<br />
					<p className='bold'> Conclusion</p>
					<br /> Saying you do not have a question during an interview can come out
					as rude and dismissive. Hence, whatever you do, always prepare to ask at
					least one question at the end of the interview. That being said, you want
					to be strategic and ask the right questions to properly back up your claims
					as being the right candidate for the job. The template in this article
					should help you decide what questions you can ask your recruiters when next
					you attend an interview.
				</div>

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
