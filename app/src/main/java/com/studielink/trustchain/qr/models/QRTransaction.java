package com.studielink.trustchain.qr.models;

import com.squareup.moshi.Json;

public class QRTransaction {
    public long down;
    public long up;

    @Json(name = "total_up")
    public long totalUp;

    @Json(name = "total_down")
    public long totalDown;
}
