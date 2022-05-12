package com.hms.accounts.request;

import java.sql.Timestamp;

public class FetchByDate {
    private Timestamp fromDate;
    private Timestamp toDate;

    public FetchByDate(Timestamp fromDate, Timestamp toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }
}
