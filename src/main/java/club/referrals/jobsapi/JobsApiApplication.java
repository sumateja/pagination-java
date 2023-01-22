package club.referrals.jobsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("referrals")
public class JobsApiApplication {

	@Autowired
	ReferralService referralService;

	@GetMapping APIResponse<List<Referral>> getReferrals(){
		List<Referral> allReferrals = referralService.findAllReferrals();
		return new APIResponse<>(allReferrals.size(),allReferrals);
	}

	@GetMapping("/pagination/{offset}/{limit}")
	APIResponse<Page<Referral>> getReferralsByPagination(@PathVariable int offset,@PathVariable int limit){
		Page<Referral> referralsPaginated = referralService.findAllReferralsPaginated(offset,limit);
		return new APIResponse<>(referralsPaginated.getSize(),referralsPaginated);
	}


	@GetMapping("/{field}")
	APIResponse<List<Referral>> getReferralsBySorting(@PathVariable String field){
		List<Referral> referralsPaginated = referralService.findAllReferralsBySorting(field);
		return new APIResponse<>(referralsPaginated.size(),referralsPaginated);
	}


	@GetMapping("/pagination/{offset}/{limit}/{field}")
	APIResponse<Page<Referral>> getReferralsByPaginationSorting(@PathVariable int offset,@PathVariable int limit,@PathVariable String field){
		Page<Referral> referralsPaginated = referralService.findAllReferralsByPaginationSorting(offset,limit,field);
		return new APIResponse<>(referralsPaginated.getSize(),referralsPaginated);
	}

	public static void main(String[] args) {
		SpringApplication.run(JobsApiApplication.class, args);
	}

}
