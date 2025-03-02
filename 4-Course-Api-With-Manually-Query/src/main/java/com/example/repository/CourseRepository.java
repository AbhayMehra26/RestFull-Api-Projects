package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>
{


	@Modifying
	@Transactional
	@Query(value = "INSERT INTO Course (cid, cname, cduration, cprice) VALUES (:cid,:cname, :cduration, :cprice)", nativeQuery = true)
	//sql query
	void Coursesave( 
                     @Param("cid") Integer cid,
	                 @Param("cname") String cname, 
	                 @Param("cduration") String cduration, 
	                 @Param("cprice") Integer cprice);

//jpql query

//  sql //@Query(value="select * from Course,nativeQuery = true)
	
	@Query("Select c from Course c")
	List<Course> findAllCourses();

//sql //@Query(value="select * from Course  where cid=:agr",nativeQuery = true)

	 @Query("select c from Course c where c.cid=:agr")
	 Course findByUserId(@Param ("agr")  int cid);

	@Modifying
	@Transactional
	@Query("DELETE FROM Course c WHERE c.cid = :agr1")
	void deleteUserById(@Param("agr1") int cid);

	@Modifying
	@Transactional
	@Query("UPDATE Course c SET c.cname = :arg1, c.cduration = :arg2, c.cprice = :arg3 WHERE c.cid = :arg4")
	void updateCourseById(@Param ("arg1") String cname,
						  @Param ("arg2")String cduration,
	       			      @Param ("arg3")Integer cprice, 
	                      @Param ("arg4")Integer cid );

		
}
