package com.odesk.directoryservice.resource;

import com.odesk.directoryservice.db.ApplicantRecommendationDAO;
import com.odesk.directoryservice.representations.ApplicantRecommendation;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/applicantrecommendations")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicantRecommendationResource {

    private ApplicantRecommendationDAO dao;

    public ApplicantRecommendationResource(ApplicantRecommendationDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public List<ApplicantRecommendation> GetAll() {

        List<ApplicantRecommendation> recommendations = dao.findAll();
        if (recommendations != null) return recommendations;

        throw new WebApplicationException(Response.Status.NO_CONTENT);
    }
}
