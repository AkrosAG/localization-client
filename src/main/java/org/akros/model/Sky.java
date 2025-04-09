package org.akros.model;


import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
@Data
public class Sky  implements Serializable {

    //"class":"SKY","device":"udp://127.0.0.1:12358","vdop":99.00,"hdop":99.00,"pdop":99.00,


    @SerializedName("class")
    private final String NAME = "SKY";

    private String device ="udp://127.0.0.1:12358";

    private double timestamp = Double.NaN;  // null


    //private double longitudeDOP = Double.NaN; //horizontalAccuracy

    //private double latitudeDOP = Double.NaN;   //horizontalAccuracy

    private double vdop = Double.NaN; // verticalAccuracy -> altitudeDOP

   // private double timestampDOP = Double.NaN;

    private double hdop = Double.NaN; //horizontalAccuracy horizontalDOP

   // private double sphericalDOP = Double.NaN; // pdop

    private double pdop = Double.NaN; // hypersphericalDOP

    private List<SATObject> satellites =  new ArrayList<>();
}
