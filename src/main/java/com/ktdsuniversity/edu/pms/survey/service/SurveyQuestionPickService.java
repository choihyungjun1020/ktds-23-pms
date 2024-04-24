package com.ktdsuniversity.edu.pms.survey.service;

import java.util.List;

import com.ktdsuniversity.edu.pms.survey.vo.SearchSurveyQuestionPickVO;
import com.ktdsuniversity.edu.pms.survey.vo.SurveyListVO;
import com.ktdsuniversity.edu.pms.survey.vo.SurveyQuestionPickVO;

public interface SurveyQuestionPickService {

	public boolean createNewAnswer(SurveyQuestionPickVO surveyQuestionPickVO);

	public boolean modifyOneAnswer(SurveyQuestionPickVO surveyQuestionPickVO);

	public boolean modifyOneAnswerSequence(SurveyQuestionPickVO surveyQuestionPickVO);

	public List<SurveyQuestionPickVO> getAllPicks(SearchSurveyQuestionPickVO searchSurveyQuestionPickVO);

	public SurveyListVO getAllPicks();

	public List<SurveyQuestionPickVO> getAllPicks(SurveyQuestionPickVO surveyQuestionPickVO);

}
