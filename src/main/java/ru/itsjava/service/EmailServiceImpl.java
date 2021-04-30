package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;
import ru.itsjava.repository.EmailRepository;

import javax.persistence.NoResultException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    @Transactional
    @Override
    public Email saveEmail(Email email) {
        return emailRepository.saveEmail(email);
    }

    @Transactional
    @Override
    public void deleteEmailById(long id) {
        emailRepository.deleteEmailById(id);
    }

    @Transactional
    @Override
    public void updateEmail(Email email) {
        emailRepository.updateEmail(email);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Email> findById(long id) {
        return emailRepository.findById(id);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Email> findByEmailName(String emailName) {
        try {
            return emailRepository.findByEmailName(emailName);
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }
}
