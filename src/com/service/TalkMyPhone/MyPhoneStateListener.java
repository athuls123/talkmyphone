package com.service.TalkMyPhone;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MyPhoneStateListener extends PhoneStateListener {

    public void onCallStateChanged(int state,String incomingNumber) {
        switch(state) {
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                TalkMyPhone service = TalkMyPhone.getInstance();
                if (service != null) {
                    String contact = service.getContactName(incomingNumber);
                    service.send(contact + " is calling");
                }
                break;
        }
    }
}
