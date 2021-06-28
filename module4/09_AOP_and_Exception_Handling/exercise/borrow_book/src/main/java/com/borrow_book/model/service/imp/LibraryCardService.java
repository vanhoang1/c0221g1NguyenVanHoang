package com.borrow_book.model.service.imp;

import com.borrow_book.model.entity.LibraryCard;
import com.borrow_book.model.repository.LibraryCardRepository;
import com.borrow_book.model.service.ILibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LibraryCardService implements ILibraryCardService {
   private final  LibraryCardRepository libraryCardRepository;

    @Autowired
    public LibraryCardService(LibraryCardRepository libraryCardRepository) {
        this.libraryCardRepository = libraryCardRepository;
    }

    @Override
    public Page<LibraryCard> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<LibraryCard> findAll() {
        return null;
    }


    @Override
    public void save(LibraryCard libraryCard) {
        libraryCardRepository.save(libraryCard);
    }

    @Override
    public Optional<LibraryCard> findById(int id) throws Exception {
        Optional<LibraryCard> libraryCard=libraryCardRepository.findById(id);
        if (!libraryCard.isPresent()) {
            throw new Exception("LibraryCard not found!");
        }
        return libraryCard;

    }

    @Override
    public void remove(int id) {

    }
}
