import { useEffect, useState, useCallback } from "react";
import axios from "axios";
import Spinner from "components/spinner/MoonLoader";
import {FaRegTimesCircle,FaRegCheckCircle} from 'react-icons/fa';
import "./verification.css";
import { useNavigate } from "react-router-dom";


const PaymentVerification = () => {
    const navigate = useNavigate();
    const baseURL = "https://api.applyforme.hng.tech";
    const token = localStorage?.getItem("tokenHngKey");
    const reference = localStorage?.getItem("paymentRef");
    const plan = localStorage?.getItem("paymentAccessCode");
    const [verificationDetails, setVerificationDetails] = useState({
        status:null,
        message:null
    });
    const [status, setStatus] = useState(false);
    const [isLoading, setisLoading] = useState(true);

    const verifyPayment = useCallback(async () => {
        try {
            const response = await axios.get(
                `${baseURL}/api/v1/paystack/verifypayment/${reference}/${plan}`,
                {
                    params:{
                        'reference':reference,
                        'plan':plan
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response?.data);
            setVerificationDetails({
                status:response?.data?.status,
                message:response?.data.message
            });
            setStatus(true);
            setisLoading(false);
            setTimeout(()=>{
                navigate("/pricing");
            },4000);
        } catch (err) {
            console.log(err);
            setVerificationDetails({...verificationDetails, message: err.response?.data.message});
            setisLoading(false);
            setTimeout(()=>{
                navigate("/pricing");
            },4000);
        }
    }, [plan, reference, token,navigate,verificationDetails]);

    useEffect(() => {
        verifyPayment();
        console.log("Working");
    }, [verifyPayment]);

    if(isLoading){
        return(
                <div>
                    {isLoading && <Spinner />}
                </div>       
        )      
    }
    return (
        <>
            {
                verificationDetails.status === true &&
                    <div className="message_container">
                        <FaRegCheckCircle color="green" size="7rem"/>
                        <p className="ver_text">{verificationDetails.message}</p>
                    </div>
            }
            {
                (verificationDetails.status === false || !status) &&
                 <div  className="message_container">
                    <FaRegTimesCircle color="rgb(255, 0, 72)" size="7rem"/>
                    <p className="ver_text">{verificationDetails.message}</p>
                 </div>

            }
        </>
    )
};

export default PaymentVerification;
