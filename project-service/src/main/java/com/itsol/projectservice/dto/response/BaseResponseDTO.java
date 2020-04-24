package com.itsol.projectservice.dto.response;

import com.itsol.projectservice.utils.Constants;

public class BaseResponseDTO {
    protected String    message;
    protected String code;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSuccess() {
        this.code = Constants.ApiErrorCode.SUCCESS;
        this.message = Constants.ApiErrorDesc.SUCCESS;
    }

    public void setSuccess(String msg) {
        this.code = Constants.ApiErrorCode.SUCCESS;
        this.message = msg;
    }

    public void setFailed() {
        this.code = Constants.ApiErrorCode.ERROR;
        this.message = Constants.ApiErrorDesc.ERROR;
    }

    public void setFailed(String msg) {
        this.code = Constants.ApiErrorCode.ERROR;
        this.message = msg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
