package com.example.hospital.service;

import com.example.hospital.model.Users;
import com.example.hospital.repository.UsersRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;

import java.time.LocalDateTime;
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

    public Optional<Users> getUsersById(Long id){
        return Optional.of(usersRepository.getById(id));
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

    public List<Users> findUsers(String username, String password, String realname, String telephone, Long deptId, Long userType, Integer active, LocalDateTime createTime, LocalDateTime lastLogin) {
        return usersRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfNotNull(predicates, username, value -> criteriaBuilder.like(root.get("username"), "%" + value + "%"));
            addIfNotNull(predicates, password, value -> criteriaBuilder.equal(root.get("password"), value));
            addIfNotNull(predicates, realname, value -> criteriaBuilder.like(root.get("realname"), "%" + value + "%"));
            addIfNotNull(predicates, telephone, value -> criteriaBuilder.equal(root.get("telephone"), value));
            addIfNotNull(predicates, deptId, value -> criteriaBuilder.equal(root.get("deptId"), value));
            addIfNotNull(predicates, userType, value -> criteriaBuilder.equal(root.get("userType"), value));
            addIfNotNull(predicates, active, value -> criteriaBuilder.equal(root.get("active"), value));
            addIfNotNull(predicates, createTime, value -> criteriaBuilder.equal(root.get("createTime"), value));
            addIfNotNull(predicates, lastLogin, value -> criteriaBuilder.equal(root.get("lastLogin"), value));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private <T> void addIfNotNull(List<Predicate> predicates, T value, Function<T, Predicate> function) {
        if (value != null) {
            predicates.add(function.apply(value));
        }
    }
}
