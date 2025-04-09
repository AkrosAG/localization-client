package org.akros.model;


import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class SATObject implements Serializable {

    //"class":"SKY","device":"udp://127.0.0.1:12358","vdop":99.00,"hdop":99.00,"pdop":99.00,
    // "satellites":[{"PRN":29,"el":77,"az":46,"ss":0,"used":false}
    // ,{"PRN":28,"el":57,"az":239,"ss":0,"used":false},
    @SerializedName("class")
    private final String NAME = "SAT";
    private int PRN = -1;
    private int az = -1; //azimuth
    private int el = -1; // elevation
    private int ss = -1; //Signal Strenght
    private boolean used = true; // used :false
}
