package club.gsjglob.domain;

import java.util.ArrayList;
import java.util.List;

public class GsjFolderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GsjFolderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("`parent_id` is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("`parent_id` is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("`parent_id` =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("`parent_id` <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("`parent_id` >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`parent_id` >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("`parent_id` <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("`parent_id` <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("`parent_id` in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("`parent_id` not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("`parent_id` between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`parent_id` not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("`key` is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("`key` is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("`key` =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("`key` <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("`key` >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("`key` >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("`key` <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("`key` <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("`key` like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("`key` not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("`key` in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("`key` not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("`key` between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("`key` not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("`path` is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("`path` is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("`path` =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("`path` <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("`path` >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("`path` >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("`path` <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("`path` <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("`path` like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("`path` not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("`path` in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("`path` not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("`path` between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("`path` not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("`sort` is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("`sort` is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("`sort` =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("`sort` <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("`sort` >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("`sort` >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("`sort` <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("`sort` <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("`sort` in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("`sort` not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("`sort` between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("`sort` not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIsNull() {
            addCriterion("`jump_url` is null");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIsNotNull() {
            addCriterion("`jump_url` is not null");
            return (Criteria) this;
        }

        public Criteria andJumpUrlEqualTo(String value) {
            addCriterion("`jump_url` =", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotEqualTo(String value) {
            addCriterion("`jump_url` <>", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlGreaterThan(String value) {
            addCriterion("`jump_url` >", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("`jump_url` >=", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLessThan(String value) {
            addCriterion("`jump_url` <", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLessThanOrEqualTo(String value) {
            addCriterion("`jump_url` <=", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLike(String value) {
            addCriterion("`jump_url` like", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotLike(String value) {
            addCriterion("`jump_url` not like", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIn(List<String> values) {
            addCriterion("`jump_url` in", values, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotIn(List<String> values) {
            addCriterion("`jump_url` not in", values, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlBetween(String value1, String value2) {
            addCriterion("`jump_url` between", value1, value2, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotBetween(String value1, String value2) {
            addCriterion("`jump_url` not between", value1, value2, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("`material_type` is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("`material_type` is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(Integer value) {
            addCriterion("`material_type` =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(Integer value) {
            addCriterion("`material_type` <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(Integer value) {
            addCriterion("`material_type` >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`material_type` >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(Integer value) {
            addCriterion("`material_type` <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`material_type` <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<Integer> values) {
            addCriterion("`material_type` in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<Integer> values) {
            addCriterion("`material_type` not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(Integer value1, Integer value2) {
            addCriterion("`material_type` between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`material_type` not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("`site_id` is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("`site_id` is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("`site_id` =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("`site_id` <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("`site_id` >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`site_id` >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("`site_id` <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("`site_id` <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("`site_id` in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("`site_id` not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("`site_id` between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`site_id` not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNull() {
            addCriterion("`seo_title` is null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("`seo_title` is not null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("`seo_title` =", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("`seo_title` <>", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("`seo_title` >", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`seo_title` >=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("`seo_title` <", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("`seo_title` <=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("`seo_title` like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("`seo_title` not like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIn(List<String> values) {
            addCriterion("`seo_title` in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotIn(List<String> values) {
            addCriterion("`seo_title` not in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("`seo_title` between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("`seo_title` not between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsIsNull() {
            addCriterion("`seo_keywords` is null");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsIsNotNull() {
            addCriterion("`seo_keywords` is not null");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsEqualTo(String value) {
            addCriterion("`seo_keywords` =", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsNotEqualTo(String value) {
            addCriterion("`seo_keywords` <>", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsGreaterThan(String value) {
            addCriterion("`seo_keywords` >", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("`seo_keywords` >=", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsLessThan(String value) {
            addCriterion("`seo_keywords` <", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsLessThanOrEqualTo(String value) {
            addCriterion("`seo_keywords` <=", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsLike(String value) {
            addCriterion("`seo_keywords` like", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsNotLike(String value) {
            addCriterion("`seo_keywords` not like", value, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsIn(List<String> values) {
            addCriterion("`seo_keywords` in", values, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsNotIn(List<String> values) {
            addCriterion("`seo_keywords` not in", values, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsBetween(String value1, String value2) {
            addCriterion("`seo_keywords` between", value1, value2, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordsNotBetween(String value1, String value2) {
            addCriterion("`seo_keywords` not between", value1, value2, "seoKeywords");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionIsNull() {
            addCriterion("`seo_description` is null");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionIsNotNull() {
            addCriterion("`seo_description` is not null");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionEqualTo(String value) {
            addCriterion("`seo_description` =", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionNotEqualTo(String value) {
            addCriterion("`seo_description` <>", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionGreaterThan(String value) {
            addCriterion("`seo_description` >", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("`seo_description` >=", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionLessThan(String value) {
            addCriterion("`seo_description` <", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionLessThanOrEqualTo(String value) {
            addCriterion("`seo_description` <=", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionLike(String value) {
            addCriterion("`seo_description` like", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionNotLike(String value) {
            addCriterion("`seo_description` not like", value, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionIn(List<String> values) {
            addCriterion("`seo_description` in", values, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionNotIn(List<String> values) {
            addCriterion("`seo_description` not in", values, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionBetween(String value1, String value2) {
            addCriterion("`seo_description` between", value1, value2, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andSeoDescriptionNotBetween(String value1, String value2) {
            addCriterion("`seo_description` not between", value1, value2, "seoDescription");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("`update_time` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("`update_time` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("`update_time` =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("`update_time` <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("`update_time` >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`update_time` >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("`update_time` <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("`update_time` <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("`update_time` like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("`update_time` not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("`update_time` in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("`update_time` not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("`update_time` between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("`update_time` not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("`update_id` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("`update_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("`update_id` =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("`update_id` <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("`update_id` >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`update_id` >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("`update_id` <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("`update_id` <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("`update_id` in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("`update_id` not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("`update_id` between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`update_id` not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("`create_time` is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("`create_time` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("`create_time` =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("`create_time` <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("`create_time` >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`create_time` >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("`create_time` <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("`create_time` <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("`create_time` like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("`create_time` not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("`create_time` in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("`create_time` not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("`create_time` between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("`create_time` not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("`create_id` is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("`create_id` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("`create_id` =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("`create_id` <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("`create_id` >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`create_id` >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("`create_id` <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("`create_id` <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("`create_id` in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("`create_id` not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("`create_id` between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`create_id` not between", value1, value2, "createId");
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