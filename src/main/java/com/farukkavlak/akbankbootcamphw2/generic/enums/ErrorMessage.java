package com.farukkavlak.akbankbootcamphw2.generic.enums;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.generic.exceptions.BaseErrorMessage;

public enum ErrorMessage implements BaseErrorMessage{
    PRODUCT_NOT_FOUND("Product not found"),
    COMMENT_NOT_FOUND("Comment not found"),
    USER_NOT_FOUND("User not found"),
    PHONE_USERNAME_DOES_NOT_MATCH("The '%s' username and '%s' phone number do not match."),
    USER_HAS_NO_COMMENTS("User '%s' has no comments."),
    PRODUCT_HAS_NO_COMMENTS("Product '%s' has not been commented yet."),
    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null."),
    PASSWORD_IS_NOT_STRONG_ENOUGH("Your password is not strong enough. Your password must contain at least one uppercase letter, one lowercase letter, one number and one symbol."),
    ITEM_NOT_FOUND("Item not found."),;
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
