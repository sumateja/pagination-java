package club.referrals.jobsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class ReferralService {


    @Autowired
    ReferralsRepository repository;

        @PostConstruct
    public void initDB() {
        List<Referral> products = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new Referral(i,"VISA"+i,"Teja"+i,"Java"))
                .collect(Collectors.toList());
        repository.saveAll(products);
    }

    public List<Referral> findAllReferrals(){
        return repository.findAll();
    }


    public Page<Referral> findAllReferralsPaginated(int offset, int limit) {
            Page<Referral> referrals= repository.findAll(PageRequest.of(offset,limit));
            return referrals;
    }

    public List<Referral> findAllReferralsBySorting(String field) {
            List<Referral> sortedReferrals= repository.findAll(Sort.by(Sort.Direction.ASC,field));
            return sortedReferrals;
    }

    public Page<Referral> findAllReferralsByPaginationSorting(int offset, int limit, String field) {
           Page<Referral> result= repository.findAll(PageRequest.of(offset,limit).withSort(Sort.Direction.ASC,field));
            return result;
    }
}
