package com.odesk.directoryservice.db;

import com.odesk.directoryservice.representations.ApplicantRecommendation;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ApplicantRecommendationMapper.class)
public interface ApplicantRecommendationDAO {
    @SqlQuery("select * from applicant_recommendations")
    List<ApplicantRecommendation> findAll();
}
