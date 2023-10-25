package com.StarRailDmg.http;

public enum HttpStatusCode {
    /**
     * Client errors are 400 codes
     */
    CLIENT_ERROR_400_BAD_REQUEST(400, "Bad Request"),
    CLIENT_ERROR_401_NOT_ALLOWED(401, "Method Not Alllowed"),
    CLIENT_ERROR_414_BAD_REQUEST(414, "URL Too Long"),

    /**
     * Server errors are 500 codes
     */
    SERVER_ERROR_500_INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(500, "Not Implemented"),
    ;
    public final int STATUS_CODE;
    public final String MESSAGE;

    HttpStatusCode(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }
}
