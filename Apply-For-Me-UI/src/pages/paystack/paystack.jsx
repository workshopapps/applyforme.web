import "./paystack.css";
import jwt_decode from "jwt-decode";
import {useNavigate, useParams } from "react-router-dom";
import Spinner from "components/spinner/PulseLoader";
import { useEffect, useState } from "react";
import { useCallback } from "react";
import axios from "axios";

export const PaystackPage = () => {
    const navigate = useNavigate();
    const [loading, setLoading] = useState(true);
    const [planCode, setPlanCode] = useState()
    let decoded = jwt_decode(localStorage?.getItem("tokenHngKey"));
    const { price, planName, paymentInterval } = useParams();
    const channels = ["card", "bank"];
    const currency = "NGN";
    console.log(price, planName, paymentInterval, channels, currency);

    const [convertedPrice, setConvertedPrice] = useState();
    const exchangeBaseUrl = "https://api.apilayer.com/exchangerates_data";
    const token = localStorage.getItem("tokenHngKey");
    const convertToNaira = useCallback(async () => {
        try {
            const response = await axios.get(
                `${exchangeBaseUrl}/convert?to=NGN&from=USD&amount=${price}`,
                {
                    headers: {
                        "apikey": process.env.REACT_APP_EXCHANGE_RATE_API_KEY
                    }
                }
            );
            setConvertedPrice(response?.data?.result);
            console.log(convertedPrice);
            setLoading(false);
        } catch (err) {
            console.log(err);
        }
    }, [price, convertedPrice]);

    const createPlan = async(planName,paymentInterval,setPlanCode)=>{
        console.log(paymentInterval,planName)
        try{
                const  response = await axios
                .post("https://api.applyforme.hng.tech/api/v1/paystack/createplan",
                    {
                        "name": planName,
                        "interval": paymentInterval,
                        "amount": Math.round(((convertedPrice *100) + Number.EPSILON) *100)/100,
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }               
                )
                
                
                if(response.data.status === true){
                    let paymentRef = response.data.reference
                    let paymentCode = response.data.access_code
                    setPlanCode(response?.data?.data?.plan_code)
                    console.log(response?.data?.data?.plan_code)
                    localStorage.setItem("paymentRef", paymentRef);
                    localStorage.setItem("paymentAccessCode", paymentCode);
                }
        }catch(err){
            console.log(err)
        }
    }

    const initializePlan = async(email,currency,planCode,channels)=>{
      console.log(planCode, "ran here")
        try{
                const  response = await axios
                .post("https://api.applyforme.hng.tech/api/v1/paystack/initializepayment",                  
                    {
                        "amount": Math.round(((convertedPrice *100) + Number.EPSILON) *100)/100,
                        "email":email,
                        "currency": currency,
                        "plan": planCode,
                        "channels":channels
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }    
                )
                console.log(response);
                if(response.data.status === true){
                    let paymentRef = response.data.reference
                    let paymentCode = response.data.access_code
                    let AuthorizationUrl = response.data.authorization_url

                    localStorage.setItem("paymentRef", paymentRef);
                    localStorage.getItem("paymentAccessCode", paymentCode);
                    navigate(AuthorizationUrl);
                }
        }catch(err){
            console.log(err)
        }
    }
    useEffect(() => {
        convertToNaira();
    }, [convertToNaira])
    
    const handleSubmit = (e)=>{
        e.preventDefault();
        createPlan(planName,paymentInterval,setPlanCode);
        initializePlan(decoded.emailAddress,currency,planCode,channels);
    }
        
    if (loading) {
        return <Spinner />;
    }
    return (
        <div className="form_wrapper_bg">
            
      <div>
        <form className="pay_form_wrapper" onSubmit={
          handleSubmit
        }>
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
