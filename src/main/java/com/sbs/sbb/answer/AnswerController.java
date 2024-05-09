package com.sbs.sbb.answer;

import com.sbs.sbb.question.Question;
import com.sbs.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content){
        // 답변 부모 질문 객체를 받아온다.
        Question q = this.questionService.getQuestion(id);

        // TODO: 답변 객체를 만든다.
        // TODO는 해야할 일을 써넣는 주석이다.

        Answer answer = this.answerService.create(q, content);

        return "redirect:/question/detail/%d".formatted(id);
    }
}
