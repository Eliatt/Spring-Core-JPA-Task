package com.eli.springexam_26_10_2020.repository;

        import com.eli.springexam_26_10_2020.beans.Employee;
        import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getByName(String name);




}
