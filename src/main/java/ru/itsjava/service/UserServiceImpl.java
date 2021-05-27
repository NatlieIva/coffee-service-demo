package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<User> findUserById(long id) {
        return userRepository.findUserById(id);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<User> findUserByEmail(Email email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.getAll();
    }
}
