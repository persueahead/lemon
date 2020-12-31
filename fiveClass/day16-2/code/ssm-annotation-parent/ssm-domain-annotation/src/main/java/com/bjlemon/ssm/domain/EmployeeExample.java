package com.bjlemon.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordIsNull() {
            addCriterion("employee_password is null");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordIsNotNull() {
            addCriterion("employee_password is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordEqualTo(String value) {
            addCriterion("employee_password =", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordNotEqualTo(String value) {
            addCriterion("employee_password <>", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordGreaterThan(String value) {
            addCriterion("employee_password >", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("employee_password >=", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordLessThan(String value) {
            addCriterion("employee_password <", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordLessThanOrEqualTo(String value) {
            addCriterion("employee_password <=", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordLike(String value) {
            addCriterion("employee_password like", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordNotLike(String value) {
            addCriterion("employee_password not like", value, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordIn(List<String> values) {
            addCriterion("employee_password in", values, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordNotIn(List<String> values) {
            addCriterion("employee_password not in", values, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordBetween(String value1, String value2) {
            addCriterion("employee_password between", value1, value2, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeePasswordNotBetween(String value1, String value2) {
            addCriterion("employee_password not between", value1, value2, "employeePassword");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryIsNull() {
            addCriterion("employee_salary is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryIsNotNull() {
            addCriterion("employee_salary is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryEqualTo(Float value) {
            addCriterion("employee_salary =", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryNotEqualTo(Float value) {
            addCriterion("employee_salary <>", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryGreaterThan(Float value) {
            addCriterion("employee_salary >", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryGreaterThanOrEqualTo(Float value) {
            addCriterion("employee_salary >=", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryLessThan(Float value) {
            addCriterion("employee_salary <", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryLessThanOrEqualTo(Float value) {
            addCriterion("employee_salary <=", value, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryIn(List<Float> values) {
            addCriterion("employee_salary in", values, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryNotIn(List<Float> values) {
            addCriterion("employee_salary not in", values, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryBetween(Float value1, Float value2) {
            addCriterion("employee_salary between", value1, value2, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeSalaryNotBetween(Float value1, Float value2) {
            addCriterion("employee_salary not between", value1, value2, "employeeSalary");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIsNull() {
            addCriterion("employee_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIsNotNull() {
            addCriterion("employee_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("employee_birthday =", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("employee_birthday <>", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("employee_birthday >", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employee_birthday >=", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("employee_birthday <", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employee_birthday <=", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("employee_birthday in", values, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("employee_birthday not in", values, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employee_birthday between", value1, value2, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employee_birthday not between", value1, value2, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}