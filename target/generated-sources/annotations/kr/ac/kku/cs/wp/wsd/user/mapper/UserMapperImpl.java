package kr.ac.kku.cs.wp.wsd.user.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.ac.kku.cs.wp.wsd.user.dto.UserDTO;
import kr.ac.kku.cs.wp.wsd.user.dto.UserRoleDTO;
import kr.ac.kku.cs.wp.wsd.user.entity.User;
import kr.ac.kku.cs.wp.wsd.user.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T21:54:31+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserRoles( userRoleDTOListToUserRoleList( userDTO.getUserRoles() ) );
        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setStatus( userDTO.getStatus() );
        user.setPhoto( userDTO.getPhoto() );
        user.setCreatedAt( userDTO.getCreatedAt() );
        user.setUpdatedAt( userDTO.getUpdatedAt() );

        return user;
    }

    protected List<UserRole> userRoleDTOListToUserRoleList(List<UserRoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<UserRole> list1 = new ArrayList<UserRole>( list.size() );
        for ( UserRoleDTO userRoleDTO : list ) {
            list1.add( userRoleMapper.toEntity( userRoleDTO ) );
        }

        return list1;
    }
}
