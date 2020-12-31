package com.department.manager.domain;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andDepIdIsNull() {
            addCriterion("DEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("DEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Integer value) {
            addCriterion("DEP_ID =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Integer value) {
            addCriterion("DEP_ID <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Integer value) {
            addCriterion("DEP_ID >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEP_ID >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Integer value) {
            addCriterion("DEP_ID <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEP_ID <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Integer> values) {
            addCriterion("DEP_ID in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Integer> values) {
            addCriterion("DEP_ID not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Integer value1, Integer value2) {
            addCriterion("DEP_ID between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEP_ID not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("DEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("DEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("DEP_NAME =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("DEP_NAME <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("DEP_NAME >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_NAME >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("DEP_NAME <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("DEP_NAME <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("DEP_NAME like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("DEP_NAME not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("DEP_NAME in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("DEP_NAME not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("DEP_NAME between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("DEP_NAME not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepStateIsNull() {
            addCriterion("DEP_STATE is null");
            return (Criteria) this;
        }

        public Criteria andDepStateIsNotNull() {
            addCriterion("DEP_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andDepStateEqualTo(Integer value) {
            addCriterion("DEP_STATE =", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotEqualTo(Integer value) {
            addCriterion("DEP_STATE <>", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateGreaterThan(Integer value) {
            addCriterion("DEP_STATE >", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEP_STATE >=", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateLessThan(Integer value) {
            addCriterion("DEP_STATE <", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateLessThanOrEqualTo(Integer value) {
            addCriterion("DEP_STATE <=", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateIn(List<Integer> values) {
            addCriterion("DEP_STATE in", values, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotIn(List<Integer> values) {
            addCriterion("DEP_STATE not in", values, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateBetween(Integer value1, Integer value2) {
            addCriterion("DEP_STATE between", value1, value2, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotBetween(Integer value1, Integer value2) {
            addCriterion("DEP_STATE not between", value1, value2, "depState");
            return (Criteria) this;
        }

        public Criteria andDepDescIsNull() {
            addCriterion("DEP_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDepDescIsNotNull() {
            addCriterion("DEP_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDepDescEqualTo(String value) {
            addCriterion("DEP_DESC =", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescNotEqualTo(String value) {
            addCriterion("DEP_DESC <>", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescGreaterThan(String value) {
            addCriterion("DEP_DESC >", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_DESC >=", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescLessThan(String value) {
            addCriterion("DEP_DESC <", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescLessThanOrEqualTo(String value) {
            addCriterion("DEP_DESC <=", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescLike(String value) {
            addCriterion("DEP_DESC like", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescNotLike(String value) {
            addCriterion("DEP_DESC not like", value, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescIn(List<String> values) {
            addCriterion("DEP_DESC in", values, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescNotIn(List<String> values) {
            addCriterion("DEP_DESC not in", values, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescBetween(String value1, String value2) {
            addCriterion("DEP_DESC between", value1, value2, "depDesc");
            return (Criteria) this;
        }

        public Criteria andDepDescNotBetween(String value1, String value2) {
            addCriterion("DEP_DESC not between", value1, value2, "depDesc");
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