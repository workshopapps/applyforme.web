import "./paystack.css";
import jwt_decode from "jwt-decode";
import { useParams } from "react-router-dom";
import Spinner from "components/spinner/PulseLoader";
import { useState } from "react";
// import { useCallback } from "react";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";

export const PaystackPage = () => {
    const [loading, setLoading] = useState(false);
    let decoded = jwt_decode(localStorage?.getItem("tokenHngKey"));
    const { price, planName, paymentInterval } = useParams();
    const channels = ["card", "bank"];
    const currency = "NGN";

    // const [convertedPrice, setConvertedPrice] = useState();
    // const exchangeBaseUrl = "https://api.apilayer.com/exchangerates_data";
    const token = localStorage.getItem("tokenHngKey");
    // const convertToNaira = useCallback(async () => {
    //     try {
    //         const response = await axios.get(
    //             `${exchangeBaseUrl}/convert?to=NGN&from=USD&amount=${price}`,
    //             {
    //                 headers: {
    //                     "apikey": process.env.REACT_APP_EXCHANGE_RATE_API_KEY
    //                 }
    //             }
    //         );
    //         setConvertedPrice(response?.data?.result);
    //         setLoading(false);
    //     } catch (err) {
    //         toast.error(err?.response?.data?.message);
    //     }
    // }, [price]);

    const createPlan = async(planName,paymentInterval)=>{
        setLoading(true);
        try{
                const  response = await axios
                .post("https://api.applyforme.hng.tech/api/v1/paystack/createplan",
                    {
                        "name": planName.toLowerCase(),
                        "interval": paymentInterval,
                        "amount": Math.round((price*451.60) *100),
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }               
                )
                if(response.data.status === true){
                    let paymentCode = response?.data?.data?.plan_code
                    let paymentPlan = response?.data?.data?.name
                    initializePlan(decoded.emailAddress,currency,paymentCode,channels);
                    localStorage.setItem("paymentPlan", paymentPlan);
                }
        }catch(err){
            toast.error(err?.response?.data?.message);
             setLoading(false);
        }
    }

    const initializePlan = async(email,currency,paymentCode,channels)=>{
        try{
                const  response = await axios
                .post("https://api.applyforme.hng.tech/api/v1/paystack/initializepayment",                  
                    {
                        "amount": Math.round((price*451.60)*100),
                        "email":email,
                        "currency": currency,
                        "plan": paymentCode,
                        "channels":channels
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }    
                )
                if(response.data.status === true){
                    let paymentRef = response?.data?.data?.reference;
                    localStorage.setItem("paymentRef", paymentRef);
                    let AuthorizationUrl = response?.data?.data?.authorization_url
                    console.log(paymentRef);
                   window.location.href = AuthorizationUrl;
                }
        }catch(err){
            toast.error(err?.response?.data?.message);
            setLoading(false);
        }
    }
    // useEffect(() => {
    //     convertToNaira();
    // }, [convertToNaira])
    
    const handleSubmit = (e)=>{
        e.preventDefault();
        createPlan(planName,paymentInterval);
    }
        
    if (loading) {
        return <Spinner />;
    }
    return (
        <>
             <ToastContainer/>
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

        </>
        
  );
};
