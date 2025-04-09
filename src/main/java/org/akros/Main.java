package org.akros;

import com.google.gson.Gson;
import org.akros.model.Sky;
import org.akros.model.Tpv;
import org.akros.services.ReadCsvFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ServerSocket ss = new ServerSocket(2947);
        Gson gson = new Gson();
        while(true) {
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept();
            System.out.println("Connection from " + socket + "!");
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            BufferedWriter outputStream =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            ReadCsvFile readCsvFile = new ReadCsvFile();
            List<Sky>  sykList = readCsvFile.transformCsvFileRepresenationToSky();
            List<Tpv> tpvList = readCsvFile.transformCsvFileRepresenationToTpvObjekt();

            for(Sky sky : sykList) {
                double currentTimeStamp = Calendar.getInstance().get(Calendar.MILLISECOND);
                sky.setTimestamp(currentTimeStamp);
                String jsonArray = gson.toJson(sky);
                System.out.println(jsonArray);
                outputStream.write(jsonArray);
                outputStream.newLine();
                outputStream.flush();
                Thread.sleep(500);
            }

            for(Tpv tpv : tpvList) {
                double currentTimeStamp = Calendar.getInstance().get(Calendar.MILLISECOND);
                tpv.setTimestamp(currentTimeStamp);
                String jsonArray = gson.toJson(tpv);
                System.out.println(jsonArray);
                outputStream.write(jsonArray);
                outputStream.newLine();
                outputStream.flush();
                Thread.sleep(500);
            }
        }

    }
}