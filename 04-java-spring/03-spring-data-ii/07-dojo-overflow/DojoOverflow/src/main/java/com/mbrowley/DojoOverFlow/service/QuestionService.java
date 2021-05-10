package com.mbrowley.DojoOverFlow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbrowley.DojoOverFlow.model.Answer;
import com.mbrowley.DojoOverFlow.model.NewQuestion;
import com.mbrowley.DojoOverFlow.model.Question;
import com.mbrowley.DojoOverFlow.model.Tag;
import com.mbrowley.DojoOverFlow.repository.AnswerRepository;
import com.mbrowley.DojoOverFlow.repository.QuestionRepository;
import com.mbrowley.DojoOverFlow.repository.TagRepository;

@Service
public class QuestionService {
	

	@Autowired
	private AnswerRepository aRepo;
	
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private TagRepository tRepo;
	
	// get all questions
	public List<Question> allQuestions() {
		return this.qRepo.findAll();
	}
	//get a single question
	public Question singleQuestion(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	//get all answers
	public List<Answer> allAnswers(){
		return aRepo.findAll();
	}
	//create a question from the new question class 
	public void createQuestion(NewQuestion question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			if(!questionsTags.contains(tag)){
				questionsTags.add(tag);
			}
		}
		
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
}
