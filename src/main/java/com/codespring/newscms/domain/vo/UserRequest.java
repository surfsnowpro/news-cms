package com.codespring.newscms.domain.vo;

import com.codespring.newscms.domain.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    String identity;
    String name;
    Role role;
}
