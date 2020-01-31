package by.instasite.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class Roles {

    public String GetRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities)
            if (grantedAuthority.getAuthority().equals("ADMIN")) {
                return "admin";
            } else if (grantedAuthority.getAuthority().equals("USER")) {
                return "user";
            }
        return "";
    }

}
