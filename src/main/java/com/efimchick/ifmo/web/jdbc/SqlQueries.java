package com.efimchick.ifmo.web.jdbc;

/**
 * Implement sql queries like described
 */
public class SqlQueries {
    //Select all employees sorted by last name in ascending order
    //language=HSQLDB
    //String select01 = null;
    String select01="SELECT * FROM EMPLOYEE ORDER BY LASTNAME";
    //Select employees having no more than 5 characters in last name sorted by last name in ascending order
    //language=HSQLDB
    //String select02 = null;
    String select02="SELECT * FROM EMPLOYEE WHERE LENGTH(LASTNAME)<6 ORDER BY LASTNAME";
    //Select employees having salary no less than 2000 and no more than 3000
    //language=HSQLDB
    //String select03 = null;
    String select03="SELECT * from EMPLOYEE where SALARY between 2000 and 3000";
    //Select employees having salary no more than 2000 or no less than 3000
    //language=HSQLDB
    //String select04 = null;
    String select04="SELECT * FROM EMPLOYEE WHERE SALARY<=2000 OR SALARY>=3000";
    //Select employees assigned to a department and corresponding department name
    //language=HSQLDB
    //String select05 = null;
    String select05="SELECT LASTNAME, NAME, SALARY FROM EMPLOYEE Z JOIN DEPARTMENT TEO ON (Z.DEPARTMENT=TEO.ID)";
    //Select all employees and corresponding department name if there is one.
    //Name column containing name of the department "depname".
    //language=HSQLDB
    //String select06 = null;
    String select06="SELECT LASTNAME, SALARY, TEO.NAME AS DEPNAME FROM EMPLOYEE Z LEFT JOIN DEPARTMENT TEO ON TEO.ID=Z.DEPARTMENT";
    //Select total salary pf all employees. Name it "total".
    //language=HSQLDB
    //String select07 = null;
    String select07="SELECT SUM(SALARY) AS TOTAL FROM EMPLOYEE";
    //Select all departments and amount of employees assigned per department
    //Name column containing name of the department "depname".
    //Name column containing employee amount "staff_size".
    //language=HSQLDB
    //String select08 = null;
    String select08="SELECT TEO.NAME AS DEPNAME, COUNT(Z.DEPARTMENT) AS STAFF_SIZE FROM DEPARTMENT TEO INNER JOIN EMPLOYEE Z ON TEO.ID=Z.DEPARTMENT GROUP BY TEO.NAME";
    //Select all departments and values of total and average salary per department
    //Name column containing name of the department "depname".
    //language=HSQLDB
    //String select09 = null;
    String select09="SELECT TEO.NAME AS DEPNAME, SUM(SALARY) AS TOTAL, AVG(SALARY) AS AVERAGE FROM DEPARTMENT TEO INNER JOIN EMPLOYEE Z ON TEO.ID = Z.DEPARTMENT GROUP BY TEO.NAME";
    //Select all employees and their managers if there is one.
    //Name column containing employee lastname "employee".
    //Name column containing manager lastname "manager".
    //language=HSQLDB
    //String select10 = null;
    String select10="SELECT Z.LASTNAME AS EMPLOYEE, Z_1.LASTNAME AS MANAGER FROM EMPLOYEE Z LEFT JOIN EMPLOYEE Z_1 ON Z.MANAGER=Z_1.ID";

}
