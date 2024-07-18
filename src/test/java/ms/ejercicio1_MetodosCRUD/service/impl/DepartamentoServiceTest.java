package ms.ejercicio1_MetodosCRUD.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;

    List<Departamento> departamentoList;
    Departamento departamento, departamentoEmpty, departamentoTest;
    @BeforeEach
    void setUp() {
        log.info("ejecutando beforeEach");
        List<Departamento> departamentoList=new ArrayList<>();
        departamentoTest=new Departamento(1L, 200.5, 651.5, true);
        departamento=new Departamento(1L, 100.5, 5002.2, true);
        departamentoEmpty=new Departamento();
        departamentoList.add(departamento);
    }

    @AfterEach
    void tearDown() {
        log.info("ejecutando afterEach");
    }

    @Test
    void readById() {
        log.info("ejecutando readById");
        Departamento departamento = new Departamento(1L, 200.2, 5962.055, true);
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.of(departamento));
        Optional<Departamento> departamentoOptional = departamentoService.readById(1L);
        Assertions.assertEquals(departamento, departamentoOptional.get());

    }

    @Test
    void readAll() {
        log.info("ejecutando readAll");
        Mockito.when(departamentoRepository.findAll()).thenReturn(departamentoList);
        List<Departamento> departamentosResponse=departamentoService.readAll();
        Assertions.assertEquals(departamentoList, departamentosResponse);

    }

    @Test
    void create() {
        log.info("ejecutando createVehicle");
        Departamento departamento = new Departamento(2L, 150.5, 7003.2, true);
        Mockito.when(departamentoRepository.save(any(Departamento.class))).thenReturn(departamento);
        Departamento createdDepartamento = departamentoService.create(departamento);
        Assertions.assertEquals(createdDepartamento, departamento);
    }

    @Test
    void update() {
        log.info("ejecutando update");
        Departamento updatedDepartamento = new Departamento(1L, 150.5, 7002.2, false);
        Mockito.when(departamentoRepository.save(updatedDepartamento)).thenReturn(updatedDepartamento);
        Departamento departamento = departamentoService.update(updatedDepartamento);
        Assertions.assertNotNull(departamento);
        Assertions.assertEquals(updatedDepartamento, departamento);
    }

    @Test
    void delete() {
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(departamentoTest));
        String messageResponse=departamentoService.delete(departamentoTest);
        Assertions.assertEquals("departamento 1 Borrado", messageResponse);
    }

    @Test
    void deleteElse(){
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        String messageResponse=departamentoService.delete(departamentoTest);
        Assertions.assertEquals("No se encontro el departamento", messageResponse);
    }

    @Test
    void deleteCatch(){
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(departamentoTest));
        Mockito.doThrow(new RuntimeException("Test Exception")).when(departamentoRepository).delete(departamentoTest);
        String messageResponse = departamentoService.delete(departamentoTest);
        Assertions.assertEquals("No se pudo eliminar", messageResponse);
    }


}