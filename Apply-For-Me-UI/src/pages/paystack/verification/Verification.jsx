import { useEffect, useState, useCallback } from "react";
import axios from "axios";
import Spinner from "components/spinner/MoonLoader";

const PaymentVerification = () => {
    const baseURL = "https://api.applyforme.hng.tech";
    const token = localStorage.getItem("tokenHngKey");

    const reference = localStorage?.getItem("paymentRef");
    const plan = localStorage?.getItem("paymentPlan");

    const [isLoading, setisLoading] = useState(true);

    const verifyPayment = useCallback(async () => {
        try {
            const response = await axios.get(
                `${baseURL}/api/v1/paystack/verifypayment/${reference}/${plan}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response?.data);
            setisLoading(false);
        } catch (err) {
            console.log(err);
            setisLoading(false);
        }
    }, [plan, reference, token]);

    useEffect(() => {
        verifyPayment();
        console.log("Working");
    }, [verifyPayment]);

    return <div>{isLoading && <Spinner />}Verification</div>;
};

export default PaymentVerification;
