package com.javarush.prokhorov.entity;

@SuppressWarnings("ALL")
public class Result {
    private final ResultCode resultCode;
    private final String masseger;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMasseger() {
        return masseger;
    }

    public Result(ResultCode resultCode, String masseger) {
        this.resultCode = resultCode;
        this.masseger = masseger;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", masseger='" + masseger + '\'' +
                '}';
    }
}
