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
					Understanding and acquiring a combination of both hard and soft can be
					advantageous when applying for jobs, each skill distinct but both are
					necessary to successfully perform and advance in most jobs.
					<br />
					<br />
					<p className='bold'>Hard Skills</p>
					<br />
					Hard skills are abilities that let you tackle job-specific duties and
					responsibilities. They can be learned through courses, vocational training,
					and on the job and can otherwise be defined as technical knowledge or
					training that you have gained through any life experience, including in
					your career or education. Examples of hard skills include:
					<br />
					<br />
					<ul className='ml-4'>
						<li>Bilingual or multilingual</li>
						<li>Database management</li>
						<li>Adobe software suite</li>
						<li>Network security</li>
						<li>SEO/SEM marketing</li>
						<li>Statistical analysis</li>
						<li>Data mining</li>
						<li>Mobile development</li>
						<li>User interface design</li>
						<li>Marketing campaign management</li>
						<li>Storage systems and management</li>
						<li>Programming languages (such as Perl, Python, Java, and Ruby)</li>
					</ul>
					<br />
					<p className='bold'>Soft Skills</p>
					<br />
					Soft skills on the other hand are character traits and interpersonal skills
					that characterize a person's relationships with other people. Some of the
					most in-demand soft skills include: <br />
					<br />
					<ul className='ml-4'>
						<li>Integrity</li>
						<li>Dependability</li>
						<li>Effective communication</li>
						<li>Open-mindedness</li>
						<li>Teamwork</li>
						<li>Creativity</li>
						<li>Problem-solving</li>
						<li> Critical thinking</li>
						<li>Adaptability</li>
						<li>Organization</li>
						<li>Willingness to learn</li>
						<li>Empathy</li>
					</ul>
					<br />
					<p className='bold'>
						The role of Hard skills and Soft Skills in a workplace
					</p>
					<br />
					Soft skills are crucial for both your work and job search. Soft skills are
					required to establish a productive workplace, whereas hard skills are
					required to properly complete technical responsibilities in a job.
					Employers frequently look for candidates with solid soft and hard talents
					because of this. <br />
					<br />
					Due to the fact that soft skills can occasionally be more challenging to
					develop, some companies might choose to choose individuals who have a
					stronger collection of soft skills over hard talents. When interviewing for
					a job, The most effective way to showcase your hard and soft skills is to
					share specific stories from your past experience that directly relate to
					the requirements of the job you’re interviewing for.
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
