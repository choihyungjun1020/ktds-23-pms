package com.ktdsuniversity.edu.pms.review.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.pms.review.vo.ReviewVO;

@Repository
public class ReviewDaoImpl extends SqlSessionDaoSupport implements ReviewDao{

	@Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
	@Override
	public List<ReviewVO> selectAllReview() {
		return getSqlSession().selectList(ReviewDao.NAME_SPACE + ".selectAllReview");
	}

}
