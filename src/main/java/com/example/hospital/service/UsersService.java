package com.example.hospital.service;

import com.example.hospital.model.Users;
import com.example.hospital.repository.UsersRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UsersService {

    public final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public void deleteUsersById(Long id){
        usersRepository.deleteById(id);
    }

    public Users saveUsers(Users users){
        return usersRepository.save(users);
    }

    public Optional<Optional<Users>> getUsersById(Long id){
        return Optional.of(usersRepository.findById(id));
    }

    public Optional<Users> updateUsers(Long id, Users usersDetails) {
        return usersRepository.findById(id).map(users -> {
            users.setUsername(usersDetails.getUsername());
            users.setPassword(usersDetails.getPassword());
            users.setPhone(usersDetails.getPhone());
            users.setUserType(usersDetails.getUserType());

            return usersRepository.save(users);
        });
    }

    public List<Users> findUsers(String username, String password, String email, String phone, Long userId, Long userType) {
        return usersRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, username, value -> criteriaBuilder.like(root.get("username"), "%" + value + "%"));
            addIfNotNull(predicates, password, value -> criteriaBuilder.equal(root.get("password"), value));
            addIfNotNull(predicates, userType, value -> criteriaBuilder.equal(root.get("userType"), value));
            addIfNotNull(predicates, email, value -> criteriaBuilder.like(root.get("email"), "%" + value + "%"));
            addIfNotNull(predicates, phone, value -> criteriaBuilder.like(root.get("phone"), "%" + value + "%"));
            addIfNotNull(predicates, userId, value -> criteriaBuilder.equal(root.get("userId"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
