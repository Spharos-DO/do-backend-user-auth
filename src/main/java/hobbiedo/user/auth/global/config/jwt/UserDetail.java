package hobbiedo.user.auth.global.config.jwt;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import hobbiedo.user.auth.user.dto.request.LoginRequestDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetail implements UserDetails {
	private final LoginRequestDTO loginDTO;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add((GrantedAuthority)loginDTO::getUsername);
		return collection;
	}

	@Override
	public String getPassword() {
		return loginDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return loginDTO.getUsername();
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
