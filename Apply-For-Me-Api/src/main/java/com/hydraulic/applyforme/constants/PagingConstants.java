package com.hydraulic.applyforme.constants;

import org.springframework.beans.factory.annotation.Value;

public class PagingConstants {
    public static final String DEFAULT_PAGE_NUMBER = "0";

    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final Integer STATUS_CODE_OK = 200;
    public static final Integer STATUS_CODE_CREATED = 201;
    public static final String PAYSTACK_INIT = "https://api.paystack.co/plan";
    public static final String PAYSTACK_INITIALIZE_PAY = "https://api.paystack.co/transaction/initialize";
    public static final String PAYSTACK_VERIFY = "https://api.paystack.co/transaction/verify/";
}
