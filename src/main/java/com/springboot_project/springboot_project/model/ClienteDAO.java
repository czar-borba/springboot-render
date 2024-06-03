package com.springboot_project.springboot_project.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, preco)" +
                     " VALUES (?,?)";
        Object[] obj = new Object[2];
        //primeiro ?
        obj[0] = cliente.getNome();
        //segundo ?
        obj[1] = cliente.getPreco();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarClientes() {
    	String sql = "SELECT * FROM cliente";
    	return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterCliente(int id){
		String sql = "SELECT * FROM cliente where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj);
	}

    public void atualizarCliente(int id, Cliente cli){
		String sql = "UPDATE cliente SET nome = ?," + 
		             "preco = ? WHERE id = ?";
		Object[] obj = new Object[3];
		obj[0] = cli.getNome();
		obj[1] = cli.getPreco();
		obj[2] = id;
		jdbc.update(sql, obj);
	}

    public void apagarCliente(int id){
		String sql = "DELETE FROM cliente WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}

}