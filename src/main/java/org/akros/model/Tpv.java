package org.akros.model;


import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.akros.enums.ENMEAMode;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
public class Tpv {

    @SerializedName("class")
    private final String NAME = "TPV";

    private double timestamp = Double.NaN; //OtlsGps
    private double latitude = Double.NaN;
    private double longitude = Double.NaN;  //OtlsGps
    private double altitude = Double.NaN; //OtlsGps
    private double latitudeError = Double.NaN; // horizontalAccuracy * 5
    private double longitudeError = Double.NaN; // horizontalAccuracy * 5
    private double altitudeError = Double.NaN;  // verticalAccuracy * 5
    private double course = Double.NaN; // heading --> Olts attitude
    private double speed = Double.NaN; // OtlsOdometer
    private ENMEAMode mode; // OtlsGps quality

}
