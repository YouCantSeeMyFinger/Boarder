package com.example.boarder.boarder.freeboarder.controller;


import com.example.boarder.boarder.freeboarder.dto.BoarderSearchDTO;
import com.example.boarder.boarder.freeboarder.repository.IBoarderRepo;
import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
     * @param model , BoarderSearchDTO
     * @return ModelAndVeiw
     */
    @GetMapping("/freeBoarder")
    public String freeBoarder(Model model, @ModelAttribute("filter") BoarderSearchDTO boarderSearchDTO) {
        log.info("redirect boarderSearchDTO : {}", boarderSearchDTO);
        List<FreeBoarder> boarderList = this.iBoarderRepo.findAllBoarder(boarderSearchDTO);
        model.addAttribute("boarderList", boarderList);
        return "/freeboarder/freeBoarder";
    }

    /**
     * 게시물 검색 컨트롤러
     *
     * @return ModelAndView
     */

    @GetMapping("/freeBoarder-filter")
    public String freeBoarder_filter(@ModelAttribute("filter") BoarderSearchDTO boarderSearchDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("filter", boarderSearchDTO);
        // @ModelAttribute는 default로 해당 객체의 이름으로 받는다.
        // filter로 이름을 지정해놨기 때문에 받을 때도 filter라고 attributeName을 지정해야한다.
        return "redirect:/freeBoarder";
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
    public String contextBoarder(@PathVariable("number") Integer boarderNumber, Model model) {
        // TODO findBoarder 할 시 객체가 없을 떄를 방지해서 Optional로 처리하였다. 하지만 PathVariable 값을 받아서 사용하므로 나중에 없애주는 작업을 할 수 있도록 하자.
        Optional<FreeBoarder> boarder = this.iBoarderRepo.findBoarder(boarderNumber);
        if (boarder.isPresent()) {
            FreeBoarder freeBoarder = boarder.get();
            this.iBoarderRepo.updateViewCount(boarderNumber);
            model.addAttribute("boarderContext", freeBoarder);
        }
        return "freeboarder/contextBoarder";
    }

    /**
     * 게시글 업데이트 컨트롤러이다. <br>
     * 업데이트할 내용은 2가지 <br><br>
     * 1. 수정된 제목 <br>
     * 2. 수정된 내용 <br><br>
     * <p>
     * # Notice # <br>
     * 1. 폼에서 전달되는 데이터를 전달 받기 위해 ModelAttribute를 남발<br>
     * 2. 생각해보니 ModelAttribute는 객체를 생성하고 전달받은 데이터 (name 속성에 의해서)를 필드와 매핑시켜 값을 저장 후 Model에 담아 해당 뷰에서 객체를 사용 할 수 있도록 함<br>
     * 3. 그런데 현재 나는 VIEW를 redirect하여 출력한 데이터를 따로 가공할 필요가 없음 <br>
     * 4. 때문에 HtttpServletRequest 혹은 @RequestParam을 사용하는 것이 어떤가 생각
     *
     * @return ModelAndView
     */

    @PostMapping("/freeboarder/updatecontextBoarder")
    public String updateContextBoarder(@RequestParam("title") String title, HttpServletRequest request) {
        String postContent = request.getParameter("post_content");
        int number = Integer.parseInt(request.getParameter("boarder_number"));
        BoarderDTO boarderDTO = new BoarderDTO(title, postContent);
        this.iBoarderRepo.updateBoarder(boarderDTO, number);
        return "redirect:/freeBoarder";
    }
}
