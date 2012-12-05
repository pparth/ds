package com.odesk.directoryservice.resource;

import com.odesk.directoryservice.db.ApplicantRecommendationDAO;
import com.odesk.directoryservice.representations.ApplicantRecommendation;
import com.odesk.directoryservice.representations.parameters.responses.getAll_result;
import com.yammer.metrics.annotation.Timed;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TMemoryBuffer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/applicantrecommendations")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicantRecommendationResource {

    private ApplicantRecommendationDAO dao;

    public ApplicantRecommendationResource(ApplicantRecommendationDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public byte[] GetAll() {

        List<ApplicantRecommendation> recommendations = dao.findAll();
        if (recommendations == null) throw new WebApplicationException(Response.Status.NO_CONTENT);
        getAll_result result = new getAll_result(recommendations);
        TMemoryBuffer memoryBuffer = new TMemoryBuffer(1);
        /*try {
            result.write(new TJSONProtocol(memoryBuffer));
            memoryBuffer.flush();
        } catch (TException e) {
            e.printStackTrace();
        }

        // byte[] resultByte = memoryBuffer.
        try {
            return memoryBuffer.toString("UTF-8").getBytes();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new byte[0];*/

        try {
            result.write(new TBinaryProtocol(memoryBuffer));
            memoryBuffer.flush();
        } catch (TException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return memoryBuffer.getArray();

    }
}
