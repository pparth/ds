package com.odesk.directoryservice.client;

import com.odesk.directoryservice.representations.parameters.responses.getAll_result;
import com.odesk.directoryservice.representations.ApplicantRecommendation;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.*;

import java.io.InputStream;
import java.util.*;



public class TestClient
{
    public static void main(String [] args) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet("http://89.210.153.236:8050/applicantrecommendations");

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            /*ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            TMemoryBuffer memoryBuffer = new TMemoryBuffer(1);
            memoryBuffer.write(responseBody.getBytes());
            getAll_result result = new getAll_result();
            result.read(new TJSONProtocol(memoryBuffer));*/

            HttpResponse response = httpclient.execute(httpget);
            HttpEntity content = response.getEntity();
            InputStream data = content.getContent();
            TMemoryBuffer memoryBuffer = new TMemoryBuffer(1);
            byte[] dataBytes = new byte[(int) content.getContentLength()];
            data.read(dataBytes);
            memoryBuffer.write(dataBytes);
            getAll_result result = new getAll_result();
            result.read(new TBinaryProtocol(memoryBuffer));
            List<ApplicantRecommendation> applicantRecommendations = result.getSuccess();
            for (ApplicantRecommendation applicantRecommendation : applicantRecommendations)
            {
                System.out.println(applicantRecommendation.toString());
            }

            // System.console().wait();

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }






    }




}
