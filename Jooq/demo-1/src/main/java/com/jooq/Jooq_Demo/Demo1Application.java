package com.jooq.Jooq_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	 / 1
	  @CrossOrigin
	    @GetMapping("/public/v2/jobs/search/company-name")
	    public ResponseEntity<?> getJobsByCompanyNameV2(@RequestParam(required = false) String searchText) throws ResourceNotFoundException, JSONException, JsonProcessingException {
	        return this.jobService.getAutoSearchOfJobByCompanyNameV2(searchText);
	    }
	
	//2
	 @Override
	    public ResponseEntity<?> getAutoSearchOfJobByCompanyNameV2(String searchText) {
	        HashMap<String,Object> hashMap=new HashMap<>();
	        List<String> companyName=null;
	        try {
	            companyName= jobJooqRepository.autoCompleteOfJobByCompanyNameV2(searchText.toLowerCase());
	            hashMap.put("companyName", companyName);
	            hashMap.put("message", "Success");
	        }catch (Exception e){
	            hashMap.put("massage","something Went wrong");
	            e.printStackTrace();
	        }

	       return  ResponseEntity.ok(hashMap);
	    }
	
	/// 3
	 public List<String> autoCompleteOfJobByCompanyNameV2(String lowerCase) {
		    DSLContext dslContext= DSL.using(dataSource,SQLDialect.POSTGRES);
		    Job job=Tables.JOB.as("job");
		    Employer employer=Tables.EMPLOYER.as("employer");

		    return dslContext.selectDistinct(DSL.trim(job.COMPANY_NAME))
		            .from(job)
		            .join(employer)
		            .on(employer.ID.eq(job.EMPLOYER_ID))
		            .where(DSL.lower(DSL.trim(job.COMPANY_NAME)).like("%" + lowerCase + "%").or(DSL.lower(DSL.trim(employer.ORGANIZATION_NAME)).like("%" + lowerCase + "%")))
		            .fetchInto(String.class);
		}

	////4
	package com.shramin.backend.employer;

	public record DashboardMetricsDTO(
	     long totalCandidates,
	     long vacancies,
	     long totalColleges,
	     long directEmployers,
	     long staffingAgencies
	) {}
	
	
	

}
