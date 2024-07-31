package com.example.paymentservice2.Services.PaymentGateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Service("razorpaypaymentgateway")
public class RazorpayPaymentGateway implements  PaymentGateway{
    private RazorpayClient razorpay;
    public RazorpayPaymentGateway(RazorpayClient razorpay){
        this.razorpay=razorpay;
    }
    @Override
    public String generatePaymentLink(Long orderId, String name, int amount) throws RazorpayException {
        //call razorpayapi to generate the paymentlink

       // RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
       // paymentLinkRequest.put("accept_partial",true);
      // paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",  1731984621);
        paymentLinkRequest.put("reference_id","1234567");
        paymentLinkRequest.put("description","Payment for aniket");
        JSONObject customer = new JSONObject();
        customer.put("name","9826265295");
        customer.put("contact","Aniket gurjar");
        customer.put("email","2001aniketgurjar@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","aniket Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        System.out.println(payment.toString());
        return payment.toString();
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
