//PROPS FOR THE PRICING PAGE.

//Icons for components
import iconCheck from "pages/pricing_plan/pricingAssets/check.png";
import iconArrowDown from "pages/pricing_plan/pricingAssets/arrowdown.png";
import iconCheckOutline from "pages/pricing_plan/pricingAssets/checkoutline.png";

export const pricingPage = {
  primaryHeading: "Choose a plan that suits your needs",
  primaryText:
    "Our pricing plans are designed specifically to help you find a plan that works best for you and get started on the path to finding a new job.",
  secondaryHeading: "Why choose us?",
  secondaryText:
    "With us you can easily find the best job for your qualifications and interests—one that is a good fit for both you and the employer. Our pricing plans are budget friendly",
  toggleInfo: { text1: "Pay montly", text2: "Pay yearly" },
  faqSection: {
    faqHeading: "Frequently asked questions",
    faqText:
      "We have the best reverse  recruiter service in the industry. Our recruiters are highly experienced, and they know exactly what to look for when they're recruiting.",
    faqBtnText: "Contact Us",
    questions: [
      {
        mainQuestion: "What do I have to do?",
        answer:
          "To get your dream job, all you need to do is join our membership plan and give us control of your application process.",
        subIcon: iconArrowDown
      },
      {
        mainQuestion: "Who can apply",
        answer: "Anybody looking to secure a new job can apply",
        subIcon: iconArrowDown
      },
      {
        mainQuestion: "Who is applying  on this jobs for me",
        answer:
          "Our in-house reverse recruiters are skilled and will handle your job application process.",
        subIcon: iconArrowDown
      },
      {
        mainQuestion: "What do I have to do?",
        answer:
          "The membership plan you are on determines how many job profiles you can create. Our plans include Basic, Standard, and Premium. To learn more, see our price page.",
        subIcon: iconArrowDown
      }
    ]
  },

  plans: [
    {
      planName: "Free plan",
      price: "0",
      duration: "Per month",
      model: [
        {
          icon: iconCheck,
          text: "Up to 5 applications per month",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "Can create up to 1 job profiles",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "2 Keywords per job profile",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "Access to 2 cover letter templates",
          alt: "icon, specifying status"
        }
      ],
      btnText: "Get started"
    },
    {
      planName: "Starter plan",
      price: "3.99",
      duration: "Per month",
      model: [
        {
          icon: iconCheckOutline,
          text: "up to 20 applications per month",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheckOutline,
          text: "Can create up to 2 job profiles",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheckOutline,
          text: "2 keywords per profile",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheckOutline,
          text: "Access to 5 cover letter templates",
          alt: "icon, specifying status"
        }
      ],
      btnText: "Get started",
      stamp: "Popular choice"
    },
    {
      planName: "Basic plan",
      price: "14.99",
      duration: "Per month",
      model: [
        {
          icon: iconCheck,
          text: "Up to 60 applications per month",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "Can create up to 4 job profiles",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "Two Keywords per job profile",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "Access to 10 cover letter templates",
          alt: "icon, specifying status"
        },
        {
          icon: iconCheck,
          text: "On demand CV rebuild",
          alt: "icon, specifying status"
        }
      ],
      btnText: "Get started"
    },
  ]
};
