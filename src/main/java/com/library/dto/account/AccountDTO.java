package com.library.dto.account;

import lombok.*;


import javax.persistence.Column;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AccountDTO {

    @Getter @Setter private String username;

    @Getter @Setter private String password;
    @Getter @Setter private String passwordConfirmation;


}
