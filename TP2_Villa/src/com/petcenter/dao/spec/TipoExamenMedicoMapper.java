package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.TipoExamenDTO;

public interface TipoExamenMedicoMapper {
	
	List<TipoExamenDTO> buscarTiposExamen(@Param("nom") String nombre,@Param("desc") String descripcion,@Param("est") Integer est,@Param("esp")Integer esp);

}
