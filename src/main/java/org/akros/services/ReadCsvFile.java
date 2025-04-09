package org.akros.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.akros.model.SATObject;
import org.akros.model.Sky;
import org.akros.model.TPVObject;
import org.akros.payload.OtlsGpsCsvFileObjectRepresentation;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadCsvFile {

    private File otlsfile;

    public CsvToBean getCsvBean(Reader reader) {
        HeaderColumnNameMappingStrategy<OtlsGpsCsvFileObjectRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(OtlsGpsCsvFileObjectRepresentation.class);
        return new CsvToBeanBuilder<OtlsGpsCsvFileObjectRepresentation>(reader)
                .withMappingStrategy(strategy)
                .withIgnoreEmptyLine(true)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
    }


    public List<Sky> transformCsvFileRepresenationToSky() throws FileNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/otlsGps-testdata.csv");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            CsvToBean<OtlsGpsCsvFileObjectRepresentation> csvToBean = getCsvBean(reader);
            return csvToBean.stream().map(csvLine -> Sky.builder()
                            .vdop(csvLine.getVerticalAccuracy())
                            .device("udp://127.0.0.1:12358")
                            .hdop(csvLine.getHorizontalAccuracy())
                            .pdop(csvLine.getPdop())
                            .satellites(getSattelites(csvLine.getNumberUsedSatellites()))
                            .build())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TPVObject> transformCsvFileRepresenationToTpvObjekt() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/otlsGps-testdata.csv");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            CsvToBean<OtlsGpsCsvFileObjectRepresentation> csvToBean = getCsvBean(reader);
            return csvToBean.stream().map(csvLine -> TPVObject.builder()
                            .longitude(csvLine.getLongitude()).altitude(csvLine.getAltitude())
                            .latitudeError(csvLine.getHorizontalAccuracy() * 5)
                            .longitudeError(csvLine.getHorizontalAccuracy() * 5)
                            .altitudeError(csvLine.getVerticalAccuracy() * 5)
                            .course(csvLine.getAltitude())
                            .mode(getMode(csvLine.getQuality()))
                            .build())
                    .collect(Collectors.toList());
        }
    }

    private de.taimos.gpsd4java.types.ENMEAMode getMode(String eNMEAMode) {
        if (eNMEAMode == "GNSS_FIX_NOT_AVAILABLE") {
            return de.taimos.gpsd4java.types.ENMEAMode.NoFix;
        } else if (eNMEAMode == "GNSS_FIX_VALID") {
            return de.taimos.gpsd4java.types.ENMEAMode.TwoDimensional;
        } else {
            return de.taimos.gpsd4java.types.ENMEAMode.ThreeDimensional;
        }
    }


    private List<SATObject> getSattelites(int numberOfElements) {
        return IntStream.range(0, numberOfElements).mapToObj(x -> new SATObject()).collect(Collectors.toList());
    }

}
