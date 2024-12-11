package kr.ac.kku.cs.wp.wsd.user.mapper;

import javax.annotation.processing.Generated;
import kr.ac.kku.cs.wp.wsd.user.dto.UserRoleDTO;
import kr.ac.kku.cs.wp.wsd.user.entity.UserRole;
import kr.ac.kku.cs.wp.wsd.user.entity.UserRoleId;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T21:54:31+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRole toEntity(UserRoleDTO userRoleDTO) {
        if ( userRoleDTO == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        userRole.setId( userRoleDTOToUserRoleId( userRoleDTO ) );
        userRole.setRoleName( userRoleDTO.getRoleName() );

        return userRole;
    }

    protected UserRoleId userRoleDTOToUserRoleId(UserRoleDTO userRoleDTO) {
        if ( userRoleDTO == null ) {
            return null;
        }

        UserRoleId userRoleId = new UserRoleId();

        userRoleId.setUserId( userRoleDTO.getUserId() );
        userRoleId.setRoleId( userRoleDTO.getRoleId() );

        return userRoleId;
    }
}
