package org.akros.payload;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtlsGpsCsvFileObjectRepresentation {
    @CsvBindByName(column = "timestamp")
    private double timestamp;

    @CsvBindByName(column = "longitude")
    private double longitude;

    @CsvBindByName(column = "latitude")
    private double latitude;

    @CsvBindByName(column = "altitude")
    private double altitude;

    @CsvBindByName(column = "numberUsedSatellites")
    private int numberUsedSatellites;

    @CsvBindByName(column = "quality")
    private String quality;

    @CsvBindByName(column = "pdop")
    private double pdop;

    @CsvBindByName(column = "lastRtkCorrections")
    private double lastRtkCorrections;

    @CsvBindByName(column = "horizontalAccuracy")
    private double horizontalAccuracy;

    @CsvBindByName(column = "verticalAccuracy")
    private double verticalAccuracy;

}
