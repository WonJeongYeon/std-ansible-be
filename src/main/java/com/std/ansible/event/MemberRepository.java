package com.std.ansible.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

//    @Query("SELECT c FROM Parts c WHERE (:type is null or c.type = :type) and (:name is null"
//            + " or c.name LIKE CONCAT('%', :name, '%')) and (:serial is null or c.serial LIKE CONCAT('%', :serial, '%')) and (:buyAt is null or c.buyAt = :buyAt)")
//    List<GetPartsDto> findAllByTypeAndNameAndSerialAndBuyAt(Parts.Type type, String name, String serial, LocalDate buyAt);


    @Query(value = "SELECT * FROM member order by RAND() limit 3",nativeQuery = true)
    List<Member> randomResult();
}

