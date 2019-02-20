package com.stocks.sysservice.exception;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 11:40
 * @Description:
 */
public class UserException extends RuntimeException {
    private UserType type;

    public UserException() {
    }

    public UserException(String message, UserType type) {
        super(message);
        this.type = type;
    }

    public UserType type(){
        return type;
    }

    enum UserType{
        ACCOUNT_AND_PASSWORD_IS_NULL,
        USER_AUTH_FAIL,
        USER_NOT_LOGIN,
        USER_NOT_FOUND;
    }
}
