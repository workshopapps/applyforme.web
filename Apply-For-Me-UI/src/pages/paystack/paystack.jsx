import "./paystack.css";
import jwt_decode from "jwt-decode";
import { useParams, useNavigate } from "react-router-dom";
import Spinner from "components/spinner/PulseLoader";
import { useEffect, useState } from "react";
import { useCallback } from "react";
import axios from "axios";

export const PaystackPage = () => {
  const [loading, setLoading] = useState(true);
  const [authorisation, setAuthorisation] = useState('');
  const [convertedPrice, setConvertedPrice] = useState()
  let decoded = jwt_decode(localStorage?.getItem("tokenHngKey"));
  const { price, planName, paymentInterval } = useParams();
  const channels = ["card", "bank"];
  const currency = "NGN";
  console.log(price, planName, paymentInterval, channels, currency);
  const navigate = useNavigate()


  const exchangeBaseUrl = "https://api.apilayer.com/exchangerates_data";
  const convertToNaira = async () => {
    try {
      // setLoading(false);
    const res = await axios.get(
        `${exchangeBaseUrl}/convert?to=NGN&from=USD&amount=${price}`,
        {
          headers: {
            "apikey": process.env.REACT_APP_EXCHANGE_RATE_API_KEY
          }
        }
      );
      setConvertedPrice(res.data.result)
      return res.data.result
      // setLoading(false);
    } catch (err) {
      console.log(err);
    }
  };
  useEffect(() => {
      setTimeout(() => {
        setLoading(false)
      }, 1000);
  }, []);
  if (loading) {
    return <Spinner />;
  }
  const token = localStorage.getItem("tokenHngKey");
  const createPlan = async (convertedPrice) => {
    try {
      const res = await axios.post("https://api.applyforme.hng.tech/api/v1/paystack/createplan",

        {
          "name": decoded?.fullName,
          "amount": Math.round(convertedPrice * 100) / 100,
          "interval": paymentInterval
        },
        {
          headers: {
            "Authorization": `Bearer ${token}`
          },
          
        }
      );
      console.log(res)
    } catch (error) {
      console.log(error)
      throw error
    }
  }

  const initializePayment = async () => {
    try {
      const res = await axios.post("https://api.applyforme.hng.tech/api/v1/paystack/initializepayment",
        {
          "amount": Math.round(convertedPrice * 100) / 100,
          "email": decoded?.emailAddress,
          "currency": currency,
          "plan": planName,
          "channels": channels
        },
        {
          headers: {
            "Authorization": `Bearer ${token}`
          }
        }
      );
      console.log(res)
      // setAuthorisation(res?.data?.data?.authorization_url)
      // localStorage.setItem("paymentPlan", planName)
      // localStorage.setItem("paymentRef", res?.data?.data.reference)
    } catch (error) {
      console.log(error)
      throw error
    }
  }

  const handleSubmit = async () => {
    try {
    const converted = await convertToNaira()
    await createPlan(converted)
    const res = await initializePayment()
    localStorage.setItem("paymentPlan", planName)
    localStorage.setItem("paymentRef", res?.data?.data?.reference)
    navigate(res?.data?.data?.authorization_url)
    } catch (error) {
      console.log(error)
    }

  }


  return (
    <div className="form_wrapper_bg">
      <header className="pay_header">
        <div>
          <img
            src="https://res.cloudinary.com/hamskid/image/upload/v1672269145/Frame_qq7kqh.svg"
            alt="object not found"
            className="afm"
          />
        </div>
        <div className="header_cred_wrapper">
          <span>
            <img
              src="https://res.cloudinary.com/hamskid/image/upload/v1672269145/account_circle_hwbanv.svg"
              alt="object not found"
              className="avatar"
            />
          </span>
          <span className="cred_wrapper">
            <h3 className="header_credName">{decoded?.fullName}</h3>
          </span>
        </div>
      </header>
      <div>
        <form className="pay_form_wrapper" onSubmit={(e) => {
          e.preventDefault();
          handleSubmit()
        }}>
          <div>
            <img
              src="https://res.cloudinary.com/hamskid/image/upload/v1672269145/Frame_51449_tk7pzn.svg"
              alt="object not found"
              onClick={() => window.history.back()}
            />
          </div>
          <p className="confirm_text">
            Please Confirm your payment information to continue
          </p>
          <div className="inputDiv_wrapper">
            <label htmlFor="name" className="form_label">
              Name
            </label>
            <input
              type="text"
              name="name"
              className="pay_input"
              defaultValue={decoded?.fullName}
            />
          </div>
          <div className="inputDiv_wrapper">
            <label htmlFor="email" className="form_label">
              Email
            </label>
            <input
              type="email"
              name="email"
              className="pay_input"
              defaultValue={decoded?.emailAddress}
            />
          </div>
          <div className="inputDiv_wrapper">
            <label htmlFor="amount" className="form_label">
              Amount
            </label>
            <input
              type="text"
              name="amount"
              className="pay_input"
              defaultValue={`$ ${price}`}
            />
          </div>
          <button className="submit_btn">Make payment</button>
        </form>
        <div className="paystack_footer">
          <img
            src="https://res.cloudinary.com/hamskid/image/upload/v1672272450/Secured_by_paystack_payment_gateway_hqgk1j.svg"
            alt="object not found"
          />
        </div>
      </div>
    </div>
  );
};
