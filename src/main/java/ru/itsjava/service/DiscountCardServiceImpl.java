package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.repository.DiscountCardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    @Transactional
    @Override
    public DiscountCard saveDiscountCard(DiscountCard discountCard) {
        return discountCardRepository.saveDiscountCard(discountCard);
    }

    @Transactional (readOnly = true)
    @Override
    public void deleteDiscountCardById(long id) {
        discountCardRepository.deleteDiscountCardById(id);
    }

    @Transactional
    @Override
    public void updateDiscountCard(DiscountCard discountCard) {
        discountCardRepository.updateDiscountCard(discountCard);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<DiscountCard> findById(long id) {
        return discountCardRepository.findById(id);
    }

    @Transactional (readOnly = true)
    @Override
    public List<DiscountCard> findAll() {
        return discountCardRepository.getAll();
    }
}
