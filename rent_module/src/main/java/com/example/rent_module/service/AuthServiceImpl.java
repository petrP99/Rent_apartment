package com.example.rent_module.service;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.exception.UserException;
import com.example.rent_module.mapper.UserMapper;
import com.example.rent_module.repository.UserInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.rent_module.exception.ExceptionConstants.USER_NOT_FOUND;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private EntityManager entityManager;

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserReadDto registrationUser(UserCreateDto userCreateDto) {
//        UserInfoEntity mayBeUser = userInfoRepository.findByLogin(userCreateDto.login());
//        if (!isNull(mayBeUser)) throw new RuntimeException("Пользователь с таким ником уже существует");
//        else {
//            Optional<UserInfoEntity> newUser = userInfoRepository.save(UserMapper.INSTANCE.toEntity(userCreateDto));
//            return UserMapper.INSTANCE.toDto(newUser);
//        }
        return null;
    }

    @Override
    public Optional<UserReadDto> findByLogin(UserAuthDto userAuthDto) {
        userInfoRepository.findUserByLoginWithJPQL(userAuthDto.getLogin())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND, 1));
        return null;
    }

    private UserInfoEntity findUserByLoginCriteria(String login) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserInfoEntity> query = criteriaBuilder.createQuery(UserInfoEntity.class);
        Root<UserInfoEntity> root = query.from(UserInfoEntity.class);

        query.select(root)
                .where(criteriaBuilder.equal(root.get("login"), login));

        return entityManager.createQuery(query).getSingleResult();
    }


    /**
     * проверка ппароля чрз иквэлс, при несовпадении кастомная ошибка
     * генерировать токен(стринговое значение + сетать его в поле токен в поле сущности) при успешной авторизации
     * допилить критерию(критериярепозиторию и класс)
     * вынести в род класс CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
     * //        CriteriaQuery<UserInfoEntity> query = criteriaBuilder.createQuery(UserInfoEntity.class);
     * //        Root<UserInfoEntity> root = query.from(UserInfoEntity.class);
     *
     * валидаторХэндлер на имейл
     * почитать типы джейсоны и работа с ним
     *ьиьлиотека критерии
     *
     *
     * */

}

