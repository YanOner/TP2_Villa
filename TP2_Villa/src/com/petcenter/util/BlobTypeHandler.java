package com.petcenter.util;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(byte[].class)
public class BlobTypeHandler extends BaseTypeHandler<byte[]> {
	
	    @Override
	    public void setNonNullParameter(PreparedStatement preparedStatement, int i, byte[] bytes, JdbcType jdbcType) throws SQLException {
	        /*/ see setBlobAsBytes method from https://jira.spring.io/secure/attachment/11851/OracleLobHandler.java
	        try {
	            if (bytes != null) {
	                //prepareLob
	                Blob Blob = Blob.createTemporary(preparedStatement.getConnection(), true, Blob.DURATION_SESSION);

	                //callback.populateLob
//	                OutputStream os = Blob.getBinaryOutputStream();
	                try {
//	                    os.writeC(bytes);
	                } catch (Exception e) {
	                    throw new SQLException(e);
	                } finally {
	                    try {
	                        os.close();
	                    } catch (Exception e) {
	                        e.printStackTrace();//ignore
	                    }
	                }
	                preparedStatement.setBlob(i, Blob);
	            } else {
	                preparedStatement.setBlob(i, (Blob) null);
	            }
	        } catch (Exception e) {
	            throw new SQLException(e);
	        }*/
	    }

	    /** see getBlobAsBytes method from https://jira.spring.io/secure/attachment/11851/OracleLobHandler.java */
	    private byte[] getBlobAsBytes(Blob Blob) throws SQLException {

	        //initializeResourcesBeforeRead
//	        if(!Blob.isTemporary()) {
//	            Blob.open(Blob.MODE_READONLY);
//	        }

	        //read
	        byte[] bytes = Blob.getBytes(1L, (int)Blob.length());

	        //releaseResourcesAfterRead
//	        if(Blob.isTemporary()) {
//	            Blob.freeTemporary();
//	        } else if(Blob.isOpen()) {
//	            Blob.close();
//	        }

	        return bytes;
	    }

	    @Override
	    public byte[] getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
	        try {
	            //use a custom oracle.sql.Blob
	            Blob Blob = (Blob) resultSet.getBlob(columnName);
	            return getBlobAsBytes(Blob);
	        } catch (Exception e) {
	            throw new SQLException(e);
	        }
	    }

	    @Override
	    public byte[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
	        try {
	            //use a custom oracle.sql.Blob
	            Blob Blob = (Blob) resultSet.getBlob(i);
	            return getBlobAsBytes(Blob);
	        } catch (Exception e) {
	            throw new SQLException(e);
	        }
	    }

	    @Override
	    public byte[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
	        try {
	            //use a custom oracle.sql.Blob
	            Blob Blob = (Blob) callableStatement.getBlob(i);
	            return getBlobAsBytes(Blob);
	        } catch (Exception e) {
	            throw new SQLException(e);
	        }
	    }
}
