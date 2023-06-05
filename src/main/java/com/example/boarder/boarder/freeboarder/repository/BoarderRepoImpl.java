package com.example.boarder.boarder.freeboarder.repository;

import com.example.boarder.boarder.freeboarder.mapper.IBoarderMapper;
import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoarderRepoImpl implements IBoarderRepo {

    private IBoarderMapper iBoarderMapper;

    @Override
    public FreeBoarder save(FreeBoarder freeBoarder) {
        this.iBoarderMapper.save(freeBoarder);
        return freeBoarder;
    }

    @Override
    public Optional<FreeBoarder> findBoarder(String title) {
        return this.iBoarderMapper.findByBoarder(title);
    }

    @Override
    public void updateBoarder(BoarderDTO boarderDTO, String title) {
        this.iBoarderMapper.updateBoarder(boarderDTO, title);
    }

    @Override
    public void deleteBoarder(String title) {
        this.iBoarderMapper.deleteBoarder(title);
    }


}
