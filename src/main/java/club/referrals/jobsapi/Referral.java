package club.referrals.jobsapi;


import javax.persistence.*;
import java.sql.Ref;


@Entity
@Table(name = "REFERRALS")
public class Referral {

    @Id
    @GeneratedValue
    @Column
    int id;

    @Column
    String companyName;

    @Column
    String skillSet;

    @Column
    String referredBy;


    public Referral(int id,String companName,String skillSet,String referredBy){
        this.id= id;
        this.companyName=companName;
        this.skillSet = skillSet;
        this.referredBy=referredBy;
    }

    public Referral(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }
}

