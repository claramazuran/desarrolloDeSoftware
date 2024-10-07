package org.example.Controladores;

import org.example.Entidades.EntidadBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public interface ControladorBase <E extends EntidadBase, ID extends Serializable> {
    public ResponseEntity<?>  getAll();
    public ResponseEntity<?>  getOne(@PathVariable ID id);
    public ResponseEntity<?>  save(@RequestBody E entity);
    public ResponseEntity<?>  update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?>  delete(@PathVariable ID id);
    public ResponseEntity<?>  getAllMutants();
    public ResponseEntity<?>  getAllNoMutants();
}
