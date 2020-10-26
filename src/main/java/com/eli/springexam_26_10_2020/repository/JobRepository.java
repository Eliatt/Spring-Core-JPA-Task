package com.eli.springexam_26_10_2020.repository;

        import com.eli.springexam_26_10_2020.beans.Job;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.sql.Date;
        import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> getByEndDate(Date date);


    List<Job> getByEndDateBetween (Date d1, Date d2);



}
