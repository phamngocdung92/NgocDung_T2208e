package subject1Java.java.jpaRepository.main.impl;

import subject1Java.java.jpaRepository.annotation.Entity;
import subject1Java.java.jpaRepository.consts.SqlQueryConstants;
import subject1Java.java.jpaRepository.main.JpaExecutor;
import subject1Java.java.utils.ConnectionPool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class JpaExecutorImpl<T> implements JpaExecutor<T>{
    private Class<T> clazz;
    private String className;
    public String tableName;
    Field[] fields;
    public static void main(String[]args){

    }
    public JpaExecutorImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = clazz.getAnnotation(Entity.class) != null ?
                clazz.getAnnotation(Entity.class).tableName() : className;
        this.fields = clazz.getDeclaredFields();
//        System.err.println("tableName: " + this.tableName);
//        System.err.println("tableName: " + this.tableName);
//        System.err.println("fields: " + this.fields);
    }

    public abstract List<T> rowMapper(ResultSet rs);
    @Override
    public List<T> findAll(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        String sql = SqlQueryConstants.SQL_SELECT_ALL.replace("%table_name%", this.tableName);
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            return rowMapper(rs);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<T> findById(Number id){
        return Optional.empty();
    }
}