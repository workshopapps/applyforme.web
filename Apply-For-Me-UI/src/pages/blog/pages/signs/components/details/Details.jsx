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
					Getting an interview invite and attending the interview is a huge step to
					securing a job. However, the anticipation of the outcome of the interview
					can keep you on your tiptoes. You don't know if you did well enough to get
					an offer letter or if you did badly and would receive a rejection mail.
					Here are some signs that an interview went well and you'll probably get a
					positive response soon. <br />
					<br />
					<p className='bold'>The Interview was Interactive and Engaging</p>
					<br />
					<p>
						One way to know your interview went well is if the session was interactive
						and engaging. This goes beyond asking you a job or cv related questions.
						They'd ask you about your hobbies, politics, interests, etc. You also get
						to ask the hiring team some questions and they'd respond. This happens
						when they want to gauge your intellect and ability to hold solid
						conversations outside what you have prepared beforehand.
					</p>
					<br />
					<p className='bold'>The Questions Asked were Suggestive of You Staying</p>
					<br />
					<p>
						More often than not, when an interview is going smoothly, you'd be asked
						questions that make it appear like you already work there. For instance,
						you might be asked questions like these;
					</p>
					<ul className='ml-4'>
						<li>
							From your knowledge about us, what would you change if you worked here?
						</li>
						<li>Do you think this place will help you meet your career goal?</li>

						<li>
							Why would you prefer working here, rather than with our competition?
						</li>
					</ul>
					<br />
					<p className='bold'>You Got to Meet in-house Colleagues</p>
					<br />
					The interview stage is often part of the screening stage during
					recruitment. However, when a candidate ticks all the checks and is likely
					to get a job, other employees get involved in the process. These could be
					team leads, bosses, or colleagues you'd most likely work with along the
					line.
					<br />
					<br />
					<p className='bold'>They Asked You to Look out For Your Mails</p>
					<br />
					When the hiring team isn't interested in you, they don't care whether you
					receive their rejection mail or not. On the other hand, if they want to
					meet you again, they'll ask you to look out for mail within a specific
					period. They'd also encourage you to check your spam folder so you don't
					miss the "important" email. <br />
					<br />
					<p className='bold'>The Interview Process took Longer than the others</p>
					<br /> For some candidates, an ideal interview should take no less than a
					few minutes. This might happen because there are many people in the queue
					to be interviewed. It can also happen if the recruiters don't think you can
					do the job or they generally do not find you qualified. Especially if you
					aren't the only one there interviewing for the same role, you want to
					compare the time each person spends with the recruiter. Spending a longer
					time compared to others might mean they find what you're saying
					interesting.
					<br />
					<p className='bold'>Conclusion</p>
					<br />
					So you rehearsed before the interview and carefully poured out your heart
					to the hiring team. Remember that it's not how great you think the
					interview went but what actually happened during the interview. The signs
					in this article will prepare you as you anticipate that follow-up email.
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
