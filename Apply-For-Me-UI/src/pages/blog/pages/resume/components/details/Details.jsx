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
					Having a good resume is essential in your job search but these days writing
					one can be a puzzle - every month we learn about a fresh resume commandment
					like "you shouldn't send a resume in a pdf format", "you shouldn't
					overstate your responsibilities in a specific role"...and so on, and the
					next month it becomes the exact opposite of what has been said.
					<br />
					<br />
					It can be a little frustrating making these changes, trying to figure out
					what works while job hunting. Perhaps a refresher course on what a resume
					is, could help a general definition of what it should contain.
					<br />
					<br />
					<p className='bold'>What is a Resume and why is it important?</p>
					<br />A resume is a formal document that a job applicant creates to itemize
					their qualification for a position. It is a tool for marketing yourself to
					prospective employers outlining your background, skills and education. It
					tells the prospective employer what to expect from you and what qualities
					you can bring to the company.
					<br />
					<br />
					<p className='bold'>The Do’s of Resume writing</p>
					<br />
					When writing a resume, here are a few things to consider:
					<br />
					<br />
					<ul className='ml-4'>
						<li>Include soft skills.</li>
						<li>Highlight your most relevant experience.</li>
						<li>Quantify data.</li>
						<li>Include personal achievements.</li>
						<li>Tell the truth.</li>
						<li>Make it concise.</li>
						<li>Use plain and understandable English.</li>
						<li>Consider a creative or digital resume.</li>
						<li>Start from a template; you can use resume builders.</li>
						<li>Make your Job Titles or companies stand out.</li>
						<li>Align your dates and locations to the right.</li>
						<li>Spell check.</li>
						<li>
							Use digits in place of words for example use "4" instead of "four"
						</li>
					</ul>
					<br />
					<p className='bold'>The Don’ts of Resume Writing</p>
					<br />
					On the other hand, a few of you should avoid:
					<br />
					<br />
					<ul className='ml-4'>
						<li>Don't steal your job description's exact wording.</li>
						<li>Avoid including confidential information.</li>
						<li>Inclusion of obvious skills for example Microsoft word.</li>
						<li>Don't use objective statements.</li>
						<li>Don't use role-specific jargon.</li>
						<li>Using Negative phrases.</li>
						<li>
							Don't include any information that could be discriminated against for
							instance age, race, gender e.t.c. Trying to squeeze in as much
							information as possible.
						</li>
						<li>Don't spend all your time on the resume design.</li>
						<li>Don't use more than 2 fonts.</li>
						<li>Don't send it as a Word document.</li>
					</ul>
					<br />
					Building a resume shouldn't be as challenging as it has been made to look,
					with the help of resume builders you can create a detailed resume that
					perfectly sells your skills to prospective employers. You have your resume
					ready and you need to land those jobs? Then checkout ApplyForMe.
					<br />
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
