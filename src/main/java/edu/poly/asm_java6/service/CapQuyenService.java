package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.CapQuyen;

import java.util.List;

public interface CapQuyenService {
    public List<CapQuyen> findAuthoritiesOfAdministrators();

    public List<CapQuyen> findAll();

    public CapQuyen create(CapQuyen auth);

    public void delete(Integer id);
}
