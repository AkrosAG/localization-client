package org.akros.model;


import com.google.gson.annotations.SerializedName;
import de.taimos.gpsd4java.types.IGPSObject;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
public class TPVObject  implements IGPSObject {

    @SerializedName("class")
    private final String NAME = "TPV";

/*    private double timestamp = Double.NaN; //OtlsGps
    private double latitude = Double.NaN;
    private double longitude = Double.NaN;  //OtlsGps
    private double altitude = Double.NaN; //OtlsGps
    private double latitudeError = Double.NaN; // horizontalAccuracy * 5
    private double longitudeError = Double.NaN; // horizontalAccuracy * 5
    private double altitudeError = Double.NaN;  // verticalAccuracy * 5
    private double course = Double.NaN; // heading --> Olts attitude
    private double speed = Double.NaN; // OtlsOdometer
    private ENMEAMode mode; // OtlsGps quality*/


    private String tag = null;

    private String device = null;

    @SerializedName("time")
    private double timestamp = Double.NaN;

    @SerializedName("ept")
    private double timestampError = Double.NaN;

    @SerializedName("lat")
    private double latitude = Double.NaN;

    @SerializedName("lon")
    private double longitude = Double.NaN;

    @SerializedName("alt")
    private double altitude = Double.NaN;

    @SerializedName("epy")
    private double latitudeError = Double.NaN;

    @SerializedName("epx")
    private double longitudeError = Double.NaN;

    @SerializedName("epv")
    private double altitudeError = Double.NaN;

    @SerializedName("track")
    private double course = Double.NaN;

    @SerializedName("speed")
    private double speed = Double.NaN;

    @SerializedName("climb")
    private double climbRate = Double.NaN;

    @SerializedName("epd")
    private double courseError = Double.NaN;

    @SerializedName("eps")
    private double speedError = Double.NaN;

    @SerializedName("epc")
    private double climbRateError = Double.NaN;

    @SerializedName("mode")
    private de.taimos.gpsd4java.types.ENMEAMode mode;



}
