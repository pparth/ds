namespace java test

struct ApplicantRecommendation {
  1: i64 applicationId,
  2: string algorithm,
  3: double score,
  4: i32 annotation
}


service ApplicantRecommendationResource {

   list<ApplicantRecommendation> getAll()
}
