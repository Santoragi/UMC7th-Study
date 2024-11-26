package umc7.spring.apiPayload.exception.handler;

import umc7.spring.apiPayload.code.BaseErrorCode;
import umc7.spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
