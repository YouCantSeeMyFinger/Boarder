package com.example.boarder.boarder.freeboarder.repository;

import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;

import java.util.List;
import java.util.Optional;

public interface IBoarderRepo {
    public FreeBoarder save(FreeBoarder freeBoarder);

    public Optional<FreeBoarder> findBoarder(String title);

    public void updateBoarder(BoarderDTO boarderDTO, String title);

    public void deleteBoarder(String title);

    public List<FreeBoarder> findAllBoarder();
}
