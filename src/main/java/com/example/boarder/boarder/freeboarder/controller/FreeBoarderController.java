package com.example.boarder.boarder.freeboarder.controller;


import com.example.boarder.boarder.freeboarder.repository.IBoarderRepo;
import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FreeBoarderController {


    private final IBoarderRepo iBoarderRepo;

    /**
     * RedirectAttribute를 통해 객체르 받고 있다. <br><br>
     * 그냥 전체 목록을 조회해서 뿌려주어 해결이 된다면 굳이 RedirectAttribute를 사용하지 않아도 된다.<br><br>
     *
     * @param model
     * @return ModelAndVeiw
     * @ModelAttribute 말고 Model만 사용
     */
    @GetMapping("/freeBoarder")
    public String freeBoarder(Model model) {
        List<FreeBoarder> boarderList = this.iBoarderRepo.findAllBoarder();
        log.info("findAllBoarder : {}", boarderList);
        model.addAttribute("boarderList", boarderList);
        return "/freeboarder/freeBoarder";
    }


    // TODO 아래의 메소드는 검색 기능을 구현하기 위해 만들어놓은 메소드
    @PostMapping("/freeBoarder-filter")
    public String freeBoarder_filter() {
        return "/freeboarder/freeBoarder";
    }

    /**
     * 글 작성 컨트롤러 Get
     *
     * @param boarderDTO
     * @return ModelAndView
     */

    @GetMapping("/freeboarder/write_boarder")
    public String write_boarder(@ModelAttribute("BoarderDTO") BoarderDTO boarderDTO) {
        return "/freeboarder/write";
    }


    /**
     * 아래의 컨트롤러는 글쓰기 작성 후 저장할 때 실행되는 컨트롤러이다.
     *
     * @return ModelAndView
     */
    @PostMapping("/freeBoarder")
    public String freeBoarderPost(@ModelAttribute("BoarderDTO") BoarderDTO boarderDTO) {

        // TODO 회원만 클쓰기를 할 수 있도록 할 것 , 해당 회원이 작성한 글 목록을 보기 위해 JOIN을 사용 할 목적이다.

        FreeBoarder freeBoarder = new FreeBoarder
                (boarderDTO.getTitle(), "TEST", LocalDateTime.now(), 0, boarderDTO.getPost_content(), "tlsqhdrbs");

        FreeBoarder savedFreeBoarder = this.iBoarderRepo.save(freeBoarder);
        log.info("savedFreeBoarder : {}", savedFreeBoarder);
        return "redirect:/freeBoarder";
    }

    /**
     * 아래의 컨트롤러는 글 번호로 처리하려 했지만 DB에서 PK는 인덱스를 갖고 있다. 때문에 게시글을 찾을 때 PK를 이용 <br>
     * 때문에 DB에 저장되어있다 Boarder_Number를 이용하여 DB에 접근하는 방법을 선택
     *
     * @param boarderNumber
     * @return
     */
    @GetMapping("/freeboarder/contextBoarder/{number}")
    public String contextBoarder(@PathVariable("number") Integer boarderNumber) {
        log.info("PathVariable Number : {} ", boarderNumber);
        // TODO findBoarder 할 시 객체가 없을 떄를 방지해서 Optional로 처리하였다. 하지만 PathVariable 값을 받아서 사용하므로 나중에 없애주는 작업을 할 수 있도록 하자.
        Optional<FreeBoarder> boarder = this.iBoarderRepo.findBoarder(boarderNumber);
        log.info("boarder : {}", boarder);
        return "freeboarder/contextBoarder";
    }
}
