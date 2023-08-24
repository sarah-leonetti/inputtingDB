package com.iaustin.ggsapi.model;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;



enum GuardianRelationEnum {
   firstkin ("DAUGHTER/SON"),
    nibling ("NIECE/NEPHEW"),
    grand("GRANDCHILD"),
    friend("FRIEND"),
    stepin("HELPER GUARDIAN");
    String relation;

    GuardianRelationEnum(String relation){
        this.relation = relation;
    }
}
public class Guardian extends User{

    @Id
    @OneToOne(mappedBy = "id")
    public Long id; //connects to user's "ID" variable

    private Boolean isActiveGuardian;
    private GuardianRelationEnum relationToUser;
    private String notes;


}
