package br.cesed.si.tap.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cesed.si.tap.sboot.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByName(String name);	
	
}
