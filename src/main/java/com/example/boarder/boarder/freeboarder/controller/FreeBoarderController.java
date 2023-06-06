package com.example.boarder.boarder.freeboarder.controller;


import com.example.boarder.boarder.freeboarder.repository.IBoarderRepo;
import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FreeBoarderController {


    private final IBoarderRepo iBoarderRepo;

    /**
     * RedirectAttribute를 통해 객체르 받고 있다. <br><br>
     * 그냥 전체 목록을 조회해서 뿌려주어 해결이 된다면 굳이 RedirectAttribute를 사용하지 않아도 된다.<br><br>
     *
     * @param freeBoarder
     * @return ModelAndVeiw
     */
    @GetMapping("/freeBoarder")
    public String freeBoarder(@ModelAttribute("boarder_data") FreeBoarder freeBoarder) {
        List<FreeBoarder> boarderAll = this.iBoarderRepo.findAllBoarder();
        log.info("findAllBoarder : {}", boarderAll);
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
        FreeBoarder freeBoarder = new FreeBoarder
                (boarderDTO.getTitle(), "TEST", LocalDateTime.now(), 0, boarderDTO.getPost_content(), "tlsqhdrbs");

        FreeBoarder savedFreeBoarder = this.iBoarderRepo.save(freeBoarder);
        log.info("savedFreeBoarder : {}", savedFreeBoarder);
        // redirectAttributes.addFlashAttribute("boarder_data", savedFreeBoarder);
        return "redirect:/freeBoarder";
    }
}
