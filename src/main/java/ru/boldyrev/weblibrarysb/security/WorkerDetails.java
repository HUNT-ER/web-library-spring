package ru.boldyrev.weblibrarysb.security;

import java.util.Collection;
import java.util.Collections;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.boldyrev.weblibrarysb.models.Worker;

@Getter
public class WorkerDetails implements UserDetails {

    private final Worker worker;

    public WorkerDetails(Worker worker) {
        this.worker = worker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(worker.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return worker.getPassword();
    }

    @Override
    public String getUsername() {
        return worker.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
