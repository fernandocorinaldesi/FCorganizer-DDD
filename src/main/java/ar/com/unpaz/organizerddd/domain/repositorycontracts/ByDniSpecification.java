package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import ar.com.unpaz.organizerddd.domain.entitys.Password;

public class ByDniSpecification implements Specification<Password> {

private final int dni;

public ByDniSpecification(int dni) {
    this.dni = dni;
  }


@Override
public boolean specified(Password entity) {
	// TODO Auto-generated method stub
	return dni == entity.getDni();
}

}
