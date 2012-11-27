package com.odesk.directoryservice.db;

import com.odesk.directoryservice.representations.ApplicantRecommendation;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicantRecommendationMapper implements ResultSetMapper<ApplicantRecommendation>{

    @Override
    public ApplicantRecommendation map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        ApplicantRecommendation applicantRecommendation = new ApplicantRecommendation();
        applicantRecommendation.setApplication_id(resultSet.getLong("application"));
        applicantRecommendation.setAlgorithm(resultSet.getString("algorithm"));
        applicantRecommendation.setAnnotation(resultSet.getInt("annotation"));
        applicantRecommendation.setScore(resultSet.getFloat("application_score"));
        return applicantRecommendation;
    }
}
